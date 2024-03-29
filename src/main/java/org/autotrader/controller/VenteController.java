/**
 * 
 */
package org.autotrader.controller;

import org.autotrader.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class VenteController {

	@Autowired
	VenteService venteService;
	
	@PostMapping("/proposer")
	public ResponseEntity<?> proposer(@RequestParam Integer idAnnonce, Integer idUtilisateur){
		try {
			
			return venteService.propositionVente(idAnnonce, idUtilisateur);
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.toString()+"\n"+e.getMessage()+"\n"+e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/vendre")
	public ResponseEntity<?> vendre(@RequestParam Integer idVente){
		try {
			
			return venteService.vendre(idVente);
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.toString()+"\n"+e.getMessage()+"\n"+e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
