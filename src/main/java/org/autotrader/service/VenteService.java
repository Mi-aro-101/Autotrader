/**
 * 
 */
package org.autotrader.service;

import org.autotrader.model.Annonce;
import org.autotrader.model.Commission;
import org.autotrader.model.CommissionVente;
import org.autotrader.model.Utilisateur;
import org.autotrader.model.Vente;
import org.autotrader.repository.AnnonceRepository;
import org.autotrader.repository.CommissionRepository;
import org.autotrader.repository.CommissionVenteRepository;
import org.autotrader.repository.UtilisateurRepository;
import org.autotrader.repository.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

/**
 * @author miaro
 *
 */
@Service
public class VenteService {

	@Autowired
	UtilisateurRepository utilisateurRepository;
	
	@Autowired
	VenteRepository venteRepository;
	
	@Autowired
	CommissionRepository commissionRepository;
	
	@Autowired
	CommissionVenteRepository commissionVenteRepository;
	
	@Autowired
	AnnonceRepository annonceRepository;
	
	double calculTarifCommission(double tarif, int pourcentage) {
		double result = 0;
		
		result = (tarif*pourcentage)/100;
		
		return result;
	}
	
	@Transactional
	public ResponseEntity<?> vendre(Integer idAnnonce, Integer idUtilisateur)throws Exception{
		
		
		Annonce annonce = annonceRepository.findById(idAnnonce).orElseThrow();
		Utilisateur acheteur = utilisateurRepository.findById(idUtilisateur).orElseThrow();
		
		double prixVente = annonce.getTarif();

		// Prendre la commission correspondant pour avoir sa pourcentage a payer
		Commission commssion = commissionRepository.getCommissionCorrespondant(annonce.getTarif()).orElseThrow();
		
		Integer venteId = venteRepository.getVenteSeq();
		Vente vente = new Vente();
		vente.setAnnonce(annonce);
		vente.setDateVente(null);
		vente.setIdVente(venteId);
		vente.setUtilisateur(acheteur);
		
		CommissionVente commissionVente = new CommissionVente();
		commissionVente.setIdCommissionVente(null);
		// 5 non payee et 10 payee
		commissionVente.setStatut(5);
		commissionVente.setVente(vente);
		double tarifCommission = this.calculTarifCommission(prixVente, commssion.getPourcentage());
		commissionVente.setValeurCommission(tarifCommission);
		
		venteRepository.save(vente);
		commissionVenteRepository.save(commissionVente);
		
		return new ResponseEntity<>("Vente effectues, veuillez payer "
				+ "votre commission de valeur : "+commissionVente.getValeurCommission(), HttpStatus.OK);
		
	}
	
}
