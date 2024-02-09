/**
 * 
 */
package org.autotrader.service;

import java.util.ArrayList;
import java.util.List;

import org.autotrader.dto.CategorieVoitureDto;
import org.autotrader.model.CategorieVoiture;
import org.autotrader.repository.CategorieVoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author miaro
 *
 */
@Service
public class CategorieVoitureService {
	
	@Autowired
	CategorieVoitureRepository categorieVoitureRepository;
	
	public ResponseEntity<?> getCategorieVoiture()throws Exception{
		List<CategorieVoiture> categorieVoitures = new ArrayList<>();
		categorieVoitureRepository.findAll().forEach(categorieVoitures::add);
		
		return new ResponseEntity<>(categorieVoitures, HttpStatus.OK);
	}
	
	public ResponseEntity<?> insertCategorieVoitrue(CategorieVoitureDto categorieVoitureDto)throws Exception{
		CategorieVoiture categorie = new CategorieVoiture();
		categorie.setIdCategorieVoiture(null);
		categorie.setNom(categorieVoitureDto.getNom());
		
		categorieVoitureRepository.save(categorie);
		
		return new ResponseEntity<>("Insertion de categorie voiture avec success", HttpStatus.OK);
	}

}
