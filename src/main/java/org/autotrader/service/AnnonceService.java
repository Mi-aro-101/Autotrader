/**
 * 
 */
package org.autotrader.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.autotrader.configuration.jwt.JwtUtils;
import org.autotrader.dto.AnnonceDto;
import org.autotrader.model.Annonce;
import org.autotrader.model.Carburant;
import org.autotrader.model.CategorieVoiture;
import org.autotrader.model.Favori;
import org.autotrader.model.ModeleVoiture;
import org.autotrader.model.Utilisateur;
import org.autotrader.repository.AnnonceRepository;
import org.autotrader.repository.CarburantRepository;
import org.autotrader.repository.CategorieVoitureRepository;
import org.autotrader.repository.FavoriRepository;
import org.autotrader.repository.ModeleVoitureRepository;
import org.autotrader.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
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
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	JwtUtils jwt;
	
	/**
	 * Insertion d'une annonce d'un utilisateur qui tente de publier une annonce, (annonce qui sera valider ou refuse par l'admin)
	 * @param annonceDto
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public ResponseEntity<?> save(AnnonceDto annonceDto , MultipartFile[] files)throws Exception{
		
		// Ilay utilisateur alaina @ alalan'ny token fa ataoko static aloha eto
		
		// Get the actual user
		Utilisateur user = jwt.getActualUser(request, utilisateurRepository);
		
//		Utilisateur user = utilisateurRepository.findById(2).orElseThrow(
//				() ->
//				new Exception("L'utilisateur essayant de publier n'existe pas"));
		///////////////////////////////////////////////////////////////////////
		
		// Get the id of the annonce actual
		Integer idAnnonce = annonceRepository.getAnnonceSeq();
		
		Carburant carburant = carburantRepository.findById(annonceDto.getIdCarburant()).orElseThrow(
				() ->
				new Exception("Carburant non valide id : "+annonceDto.getIdCarburant()));
		CategorieVoiture categorieVoiture = categorieVoitureRepository.findById(annonceDto.getIdModeleVoiture()).orElseThrow(
				() ->
				new Exception("Categorie de voiture non valide id : "+annonceDto.getIdCategorieVoiture()));
		ModeleVoiture modeleVoiture = modeleVoitureRepository.findById(annonceDto.getIdModeleVoiture()).orElseThrow(
				() ->
				new Exception("Modele de voiture non valide non valide id : "+annonceDto.getIdModeleVoiture()));
		
		Annonce annonce = new Annonce();
		annonce.setIdAnnonce(idAnnonce);
		annonce.setUtilisateur(user);
		annonce.setCarburant(carburant);
		annonce.setCategorieVoiture(categorieVoiture);
		annonce.setModeleVoiture(modeleVoiture);
		annonce.setAnnee(annonceDto.getAnnee());
		
		LocalDate dateNow = LocalDate.now();
		annonce.setDateAnnonce(dateNow);
		
		LocalTime timeNow = LocalTime.now();
		annonce.setTempsAnnonce(timeNow);
		annonce.setDescriptionAnnonce(annonceDto.getDescriptionAnnonce());
		// (Etat = 5) <=> Annonce en attente de validation par l'admin
		annonce.setEtat(5);
		///////////////////////////////////////////////////////////
		annonce.setKilometrage(annonceDto.getKilometrage());
		annonce.setNombrePlace(annonceDto.getNombrePlace());
		annonce.setNombrePorte(annonceDto.getNombrePorte());
		annonce.setTarif(annonceDto.getTarif());
		
		annonceRepository.save(annonce);
		
		photoService.savePhotos(files, annonce);
		
		return new ResponseEntity<>("Insertion avec succes", HttpStatus.OK);
		
	}
	
	/**
	 * No auth :: obtenir toutes les annonces
	 * @return
	 * @throws Exception
	 */
	public ResponseEntity<?> getAnnonces()throws Exception{
		List<Annonce> annonces = new ArrayList<>();
		annonceRepository.findAll().forEach(annonces::add);
		
//		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
//		utilisateurRepository.findAll().forEach(utilisateurs::add);
		
//		Annonce annonces = annonceRepository.findById(5).orElseThrow(() -> new Exception("No such annonce"));
		
		return new ResponseEntity<>(annonces, HttpStatus.OK);
	}
	
	/**
	 * Favoriser une annonce
	 * @param idAnnonce
	 * @return
	 * @throws Exception
	 */
	public ResponseEntity<?> favoriser(Integer idAnnonce)throws Exception{
		Annonce annonce = annonceRepository.findById(idAnnonce).orElseThrow();
		
		// Utilisateur en token
		Utilisateur user = jwt.getActualUser(request, utilisateurRepository);
		///////////////////////
		
		Favori favori = new Favori();
		favori.setIdFavori(null);
		favori.setUtilisateur(user);
		favori.setAnnonce(annonce);
		
		favoriRepository.save(favori);
		
		return new ResponseEntity<>("Annonce mis dans votre liste de favori", HttpStatus.OK);
		
	}
	
	/**
	 * Admin : valider la publication d'une annonce
	 * @param idAnnonce
	 * @return
	 * @throws Exception
	 */
	public ResponseEntity<?> valider(Integer idAnnonce)throws Exception{
		Annonce annonce = annonceRepository.findById(idAnnonce).orElseThrow(
				()-> 
				new Exception("L'annonce a valider n'existe pas id : "+idAnnonce)
				);
		annonce.setEtat(10);
		
		annonceRepository.save(annonce);
		
		return new ResponseEntity<>("Cette annonce a ete valide", HttpStatus.OK);
		
	}
	
	/**
	 * Obtenir les demande de publication d'annonce
	 * @return
	 * @throws Exception
	 */
	public ResponseEntity<?> getAnnonceNonValide()throws Exception{
		List<Annonce> annonces = new ArrayList<>();
		annonceRepository.findByEtat(5).forEach(annonces::add);
		
		return new ResponseEntity<>(annonces, HttpStatus.OK);
		
	}
	
	/**
	 * Admin : refuser la publication d'une annonce
	 * @param idAnnonce
	 * @return
	 * @throws Exception
	 */
	public ResponseEntity<?> refuser(Integer idAnnonce)throws Exception{
		Annonce annonce = annonceRepository.findById(idAnnonce).orElseThrow(
				()-> 
				new Exception("L'annonce a valider n'existe pas id : "+idAnnonce)
				);
		annonce.setEtat(0);
		
		annonceRepository.save(annonce);
		
		return new ResponseEntity<>("Cette annonce a ete refuser", HttpStatus.OK);
	}
	
}
