/**
 * 
 */
package org.autotrader.controller;

import org.autotrader.service.MarqueVoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author miaro
 *
 */
@RestController
@RequestMapping(path="/api/")
@CrossOrigin(origins = "*")
public class MarqueVoitureController {
	
	@Autowired
	MarqueVoitureService marqueVoitureService;
	
	@GetMapping("public/marque")
	public ResponseEntity<?> getAllMarqueVoitures(){
		try {
			
			return marqueVoitureService.getMarqueVoitures();
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.toString()+"\n"+e.getMessage()+"\n"+e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
