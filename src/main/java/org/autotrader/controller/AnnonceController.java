/**
 * 
 */
package org.autotrader.controller;

import org.autotrader.dto.AnnonceDto;
import org.autotrader.service.AnnonceService;
import org.autotrader.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author miaro
 *
 */
@RestController
@RequestMapping(path="/api/")
@CrossOrigin(origins = "*")
public class AnnonceController {

	@Autowired
	AnnonceService annonceService;
	
	@Autowired
	AuthService authService;
	
	@PostMapping("annonce")
	public ResponseEntity<?> publierAnnonce(@RequestPart AnnonceDto annonceDto , @RequestParam(value = "files", required = false) MultipartFile[] files){
		
		try {
			
			return annonceService.save(annonceDto, files);
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.toString()+" : "+e.getMessage()+" : "+e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("public/annonce")
	public ResponseEntity<?> voirAnnonce(){
		try {
			
			return annonceService.getAnnonces();
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.toString()+" : "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("annonce/{id}")
	public ResponseEntity<?> detailsAnnonce(@PathVariable String id){
		try {
			
			Integer idAnnonce = Integer.parseInt(id);
			return annonceService.detailsAnnonce(idAnnonce);
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.toString()+"\n"+e.getMessage()+"\n"+e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("annonce/{id}")
	public ResponseEntity<?> toFavori(@PathVariable String id){
		try {
			Integer idAnnonce = Integer.parseInt(id);
			return annonceService.favoriser(idAnnonce);
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.toString()+"\n"+e.getMessage()+"\n"+e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("annonce/valider/{id}")
	public ResponseEntity<?> valider(@PathVariable Integer idAnnonce){
		try {
			
			return annonceService.valider(idAnnonce);
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.toString()+"\n"+e.getMessage()+"\n"+e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("annonce/refuser/{id}")
	public ResponseEntity<?> refuser(@PathVariable Integer idAnnonce){
		try {
			
			return annonceService.refuser(idAnnonce);
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.toString()+"\n"+e.getMessage()+"\n"+e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("annonce/nonvalide")
	public ResponseEntity<?> getAnnonceNonValide(){
		try {
			
			return annonceService.getAnnonceNonValide();
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.toString()+"\n"+e.getMessage()+"\n"+e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("mes/annonces")
	public ResponseEntity<?> getMyAnnonce(){
		try {
			
			return annonceService.getMyAnnonce();
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.toString()+"\n"+e.getMessage()+"\n"+e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("mes/favoris")
	public ResponseEntity<?> getFavoris(){
		try {
			
			return annonceService.getFavoris();
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.toString()+"\n"+e.getMessage()+"\n"+e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
