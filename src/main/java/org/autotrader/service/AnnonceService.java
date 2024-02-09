/**
 * 
 */
package org.autotrader.service;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.autotrader.configuration.jwt.JwtUtils;
import org.autotrader.dto.AnnonceDto;
import org.autotrader.model.Annonce;
import org.autotrader.model.Carburant;
import org.autotrader.model.CategorieVoiture;
import org.autotrader.model.Favori;
import org.autotrader.model.ModeleVoiture;
import org.autotrader.model.Photo;
import org.autotrader.model.Utilisateur;
import org.autotrader.repository.AnnonceRepository;
import org.autotrader.repository.CarburantRepository;
import org.autotrader.repository.CategorieVoitureRepository;
import org.autotrader.repository.FavoriRepository;
import org.autotrader.repository.ModeleVoitureRepository;
import org.autotrader.repository.PhotoRepository;
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
	PhotoRepository photoRepository;

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
		
		LocalTime timeNow = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
		annonce.setTempsAnnonce(timeNow);
		annonce.setDescriptionAnnonce(annonceDto.getDescriptionAnnonce());
		// (Etat = 5) <=> Annonce en attente de validation par l'admin
		annonce.setEtat(5);
		///////////////////////////////////////////////////////////
		annonce.setKilometrage(annonceDto.getKilometrage());
		annonce.setNombrePlace(annonceDto.getNombrePlace());
		annonce.setNombrePorte(annonceDto.getNombrePorte());
		annonce.setTarif(annonceDto.getTarif());
		
//		annonce.setPhotos(photos);
		
		annonceRepository.save(annonce);
		
		photoService.savePhotos(files, annonce);
		
		return new ResponseEntity<>("Insertion avec succes", HttpStatus.OK);
		
	}
	
//	public List<Photo> loadPhotos(MultipartFile[] files, Annonce annonce)throws Exception{
//		File[] fileStock = photoService.convertToFiles(files);
//		List<Photo> photos = new ArrayList<>();
//		
//		for(File file : fileStock) {
//			Photo photo = new Photo();
//			photo.setIdPhoto(null);
//			photo.setAnnonce(annonce);
//			photo.setUrlPhoto(photoService.upload(file));
//			
////			annonce.addPhoto(photo);
//			photos.add(photo);
//			
//			file.delete();
//		}
//		
//		return photos;
//	}
	
	/**
	 * No auth :: obtenir toutes les annonces
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public ResponseEntity<?> getAnnonces()throws Exception{
		List<Annonce> annonces = new ArrayList<>();
		annonceRepository.findByEtat(10).forEach(annonces::add);
		
		return new ResponseEntity<>(annonces, HttpStatus.OK);
	}
	
	/**
	 * Favoriser une annonce
	 * @param idAnnonce
	 * @return
	 * @throws Exception
	 */
	@Transactional
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
	@Transactional
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
	@Transactional
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
	@Transactional
	public ResponseEntity<?> refuser(Integer idAnnonce)throws Exception{
		Annonce annonce = annonceRepository.findById(idAnnonce).orElseThrow(
				()-> 
				new Exception("L'annonce a valider n'existe pas id : "+idAnnonce)
				);
		annonce.setEtat(0);
		
		annonceRepository.save(annonce);
		
		return new ResponseEntity<>("Cette annonce a ete refuser", HttpStatus.OK);
	}
	
	@Transactional
	public ResponseEntity<?> detailsAnnonce(Integer id)throws Exception{
		Annonce annonce = annonceRepository.findById(id).orElseThrow(() ->
				new Exception("Cette annonce n'existe pas"));
				
		return new ResponseEntity<>(annonce, HttpStatus.OK);
	}
	
	/**
	 * Get all annonce posted by me
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public ResponseEntity<?> getMyAnnonce()throws Exception{
		Utilisateur user = jwt.getActualUser(request, utilisateurRepository);
		List<Annonce> myAnnonce = new ArrayList<>();
		annonceRepository.findByPoster(user.getIdUtilisateur()).forEach(myAnnonce::add);
		
		return new ResponseEntity<>(myAnnonce, HttpStatus.OK);
		
	}
	
	public ResponseEntity<?> getFavoris()throws Exception{
		Utilisateur user = jwt.getActualUser(request, utilisateurRepository);
		List<Favori> favoris = new ArrayList<>();
		favoriRepository.getMyFavoris(user.getIdUtilisateur()).forEach(favoris::add);
		
		return new ResponseEntity<>(favoris, HttpStatus.OK);
	}
	
}
