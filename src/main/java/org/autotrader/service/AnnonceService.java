/**
 * 
 */
package org.autotrader.service;

import java.util.ArrayList;
import java.util.List;

import org.autotrader.dto.AnnonceDto;
import org.autotrader.model.Annonce;
import org.autotrader.model.Carburant;
import org.autotrader.model.CategorieVoiture;
import org.autotrader.model.Favori;
import org.autotrader.model.FavoriRepository;
import org.autotrader.model.ModeleVoiture;
import org.autotrader.model.Utilisateur;
import org.autotrader.repository.AnnonceRepository;
import org.autotrader.repository.CarburantRepository;
import org.autotrader.repository.CategorieVoitureRepository;
import org.autotrader.repository.ModeleVoitureRepository;
import org.autotrader.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.transaction.Transactional;

/**
 * @author miaro
 *
 */
@Service
public class AnnonceService {

	@Autowired
	AnnonceRepository annonceRepository;
	
	@Autowired
	UtilisateurRepository utilisateurRepository;
	
	@Autowired
	CarburantRepository carburantRepository;
	
	@Autowired
	CategorieVoitureRepository categorieVoitureRepository;
	
	@Autowired
	ModeleVoitureRepository modeleVoitureRepository;
	
	@Autowired
	FavoriRepository favoriRepository;
	
	@Autowired
	PhotoService photoService;
	
	@Transactional
	public ResponseEntity<?> save(AnnonceDto annonceDto /*, MultipartFile[] files*/)throws Exception{
		
		// Ilay utilisateur alaina @ alalan'ny token fa ataoko static aloha eto
		Utilisateur user = utilisateurRepository.findById(1).orElseThrow();
		///////////////////////////////////////////////////////////////////////
		
		// Get the id of the annonce actual
		Integer idAnnonce = annonceRepository.getAnnonceSeq();
		
		Carburant carburant = carburantRepository.findById(annonceDto.getIdCarburant()).orElseThrow();
		CategorieVoiture categorieVoiture = categorieVoitureRepository.findById(annonceDto.getIdModeleVoiture()).orElseThrow();
		ModeleVoiture modeleVoiture = modeleVoitureRepository.findById(annonceDto.getIdModeleVoiture()).orElseThrow();
		
		Annonce annonce = new Annonce();
		annonce.setIdAnnonce(idAnnonce);
		annonce.setUtilisateur(user);
		annonce.setCarburant(carburant);
		annonce.setCategorieVoiture(categorieVoiture);
		annonce.setCategorieVoiture(categorieVoiture);
		annonce.setAnnee(annonceDto.getAnnee());
		annonce.setDateAnnonce(null);
		annonce.setTempsAnnonce(null);
		annonce.setDescriptionAnnonce(annonceDto.getDescriptionAnnonce());
		// (Etat = 5) <=> Annonce en attente de validation par l'admin
		annonce.setEtat(5);
		///////////////////////////////////////////////////////////
		annonce.setKilometrage(annonceDto.getKilometrage());
		annonce.setNombrePlace(annonceDto.getNombrePlace());
		annonce.setNombrePorte(annonceDto.getNombrePorte());
		annonce.setTarif(annonceDto.getTarif());
		
		annonceRepository.save(annonce);
		
//		photoService.savePhotos(files, annonce);
		
		return new ResponseEntity<>("Insertion avec succes", HttpStatus.OK);
		
	}
	
	public ResponseEntity<?> getAnnonces()throws Exception{
		List<Annonce> annonces = new ArrayList<>();
		annonceRepository.findAll().forEach(annonces::add);
		
		return new ResponseEntity<>(annonces, HttpStatus.OK);
	}
	
	public ResponseEntity<?> favoriser(Integer idAnnonce)throws Exception{
		Annonce annonce = annonceRepository.findById(idAnnonce).orElseThrow();
		
		// Utilisateur en token
		Utilisateur user = utilisateurRepository.findById(1).orElseThrow();
		///////////////////////
		
		Favori favori = new Favori();
		favori.setIdFavori(null);
		favori.setUtilisateur(user);
		favori.setAnnonce(annonce);
		
		favoriRepository.save(favori);
		
		return new ResponseEntity<>("Annonce mis dans votre liste de favori", HttpStatus.OK);
		
	}
	
}
