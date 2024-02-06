/**
 * 
 */
package org.autotrader.controller;

import org.autotrader.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author miaro
 *
 */
@RestController
@RequestMapping("/api/vente")
@CrossOrigin(origins = "*")
public class VenteController {

	@Autowired
	VenteService venteService;
	
	@PostMapping("/proposer/{id}")
	public ResponseEntity<?> proposer(@PathVariable String id){
		try {
			
			Integer idAnnonce = Integer.parseInt(id);
			return venteService.propositionVente(idAnnonce);
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.toString()+"\n"+e.getMessage()+"\n"+e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/vendre/{id}")
	public ResponseEntity<?> vendre(@PathVariable String id){
		try {
			
			Integer idVente = Integer.parseInt(id);
			return venteService.vendre(idVente);
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.toString()+"\n"+e.getMessage()+"\n"+e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("")
	public ResponseEntity<?> getDemandeVente(){
		try {
			
			return venteService.getDemandeVente();
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.toString()+"\n"+e.getMessage()+"\n"+e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
