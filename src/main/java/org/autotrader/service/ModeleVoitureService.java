/**
 * 
 */
package org.autotrader.service;

import java.util.ArrayList;
import java.util.List;

import org.autotrader.model.ModeleVoiture;
import org.autotrader.repository.ModeleVoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author miaro
 *
 */
@Service
public class ModeleVoitureService {
	
	@Autowired
	ModeleVoitureRepository modeleVoitureRepository;
	
	public ResponseEntity<?> getAllModeleVoiture()throws Exception{
		List<ModeleVoiture> modeleVoitures = new ArrayList<>();
		modeleVoitureRepository.findAll().forEach(modeleVoitures::add);
		
		return new ResponseEntity<>(modeleVoitures, HttpStatus.OK);
	}

}
