/**
 * 
 */
package org.autotrader.controller;

import org.autotrader.service.ModeleVoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author miaro
 *
 */
@RestController
@RequestMapping(path="/api/")
public class ModeleVoitureController {
	
	@Autowired
	ModeleVoitureService modeleVoitureService;
	
	@GetMapping("public/modele")
	public ResponseEntity<?> getAllModeleVoiture(){
		try {
			
			return modeleVoitureService.getAllModeleVoiture();
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.toString()+"\n"+e.getMessage()+"\n"+e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
