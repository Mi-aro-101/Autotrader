/**
 * 
 */
package org.autotrader.controller;

import org.autotrader.dto.AnnonceDto;
import org.autotrader.model.Utilisateur;
import org.autotrader.service.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author miaro
 *
 */
@RestController
@RequestMapping(path="/api/")
public class AnnonceController {

	@Autowired
	AnnonceService annonceService;
	
	@PostMapping("annonce")
	public ResponseEntity<?> publierAnnonce(@RequestBody AnnonceDto annonceDto /*, MultipartFile[] files*/){
		
		try {
			
			return annonceService.save(annonceDto/*, files*/);
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.toString()+" : "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
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
	
	@PutMapping("annonce/{id}")
	public ResponseEntity<?> toFavori(@PathVariable Integer idAnnonce){
		try {
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
}
