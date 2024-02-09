/**
 * 
 */
package org.autotrader.service;

import java.util.ArrayList;
import java.util.List;

import org.autotrader.model.MarqueVoiture;
import org.autotrader.repository.MarqueVoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author miaro
 *
 */
@Service
public class MarqueVoitureService {
	
	@Autowired
	MarqueVoitureRepository marqueVoitureRepository;
	
	public ResponseEntity<?> getMarqueVoitures()throws Exception{
		List<MarqueVoiture> marqueVoitures = new ArrayList<>();
		marqueVoitureRepository.findAll().forEach(marqueVoitures::add);
		
		return new ResponseEntity<>(marqueVoitures, HttpStatus.OK);
	}

}
