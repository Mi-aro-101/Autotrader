/**
 * 
 */
package org.autotrader.service;

import java.util.ArrayList;
import java.util.List;

import org.autotrader.model.Carburant;
import org.autotrader.repository.CarburantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author miaro
 *
 */
@Service
public class CarburantService {
	
	@Autowired
	CarburantRepository carburantRepository;
	
	public ResponseEntity<?> getAllCarburant()throws Exception{
		List<Carburant> carburant = new ArrayList<>();
		carburantRepository.findAll().forEach(carburant::add);
		
		return new ResponseEntity<>(carburant, HttpStatus.OK);
	}

}
