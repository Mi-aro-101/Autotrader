/**
 * 
 */
package org.autotrader.controller;

import org.autotrader.dto.AnnonceDto;
import org.autotrader.service.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public ResponseEntity<?> publierAnnonce(@RequestBody AnnonceDto annonceDto, MultipartFile[] files){
		
		try {
			
			return annonceService.save(annonceDto, files);
			
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
		
}
