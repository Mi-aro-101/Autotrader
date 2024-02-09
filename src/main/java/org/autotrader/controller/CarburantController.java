/**
 * 
 */
package org.autotrader.controller;

import org.autotrader.dto.CarburantDto;
import org.autotrader.service.CarburantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author miaro
 *
 */
@RestController
@CrossOrigin(origins="*")
@RequestMapping(path="/api/")
public class CarburantController {
	
	@Autowired
	CarburantService carburantService;
	
	@GetMapping("public/carburant")
	public ResponseEntity<?> getAllCarburant(){
		try {
			return carburantService.getAllCarburant();
		} catch (Exception e) {
			return new ResponseEntity<String>(e.toString()+" : "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("carburant")
	public ResponseEntity<?> insertCarburant(@RequestBody CarburantDto carburant){
		try {
			return carburantService.insertCarburant(carburant);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.toString()+" : "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
