/**
 * 
 */
package org.autotrader.controller;

import org.autotrader.dto.CategorieVoitureDto;
import org.autotrader.service.CategorieVoitureService;
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
@RequestMapping(path="/api/")
@CrossOrigin(origins = "*")
public class CategorieVoitureController {
	
	@Autowired
	CategorieVoitureService categorieVoitureService;
	
	@GetMapping("public/categorie")
	public ResponseEntity<?> getAllCategorieVoitures(){
		try {
			return categorieVoitureService.getCategorieVoiture();
		} catch (Exception e) {
			return new ResponseEntity<>(e.toString()+"\n"+e.getMessage()+"\n"+e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("categorie/voiture")
	public ResponseEntity<?> insertCategorieVoiture(@RequestBody CategorieVoitureDto categorie){
		try {
			return categorieVoitureService.insertCategorieVoitrue(categorie);
		} catch (Exception e) {
			return new ResponseEntity<>(e.toString()+"\n"+e.getMessage()+"\n"+e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
