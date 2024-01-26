package org.autotrader.service;

import java.util.ArrayList;

import org.autotrader.dto.CarburantDto;
import org.autotrader.model.Carburant;
import org.autotrader.repository.CarburantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CarburantService {

    @Autowired
    private CarburantRepository carburantRepository;

    public ResponseEntity<?> insertCarburant(CarburantDto carburantDto) {
        Carburant carburant = new Carburant();
        carburant.setIdCarburant(carburantDto.getIdCarburant());
        carburant.setNom(carburantDto.getNomCarburant());

        carburantRepository.save(carburant);
        return new ResponseEntity<>("Insertion avec succes", HttpStatus.OK);
    }

    public ResponseEntity<?> getCarburants(){
        ArrayList<Carburant> lsCarburant = new ArrayList();
        carburantRepository.findAll().forEach(lsCarburant::add);

        return new ResponseEntity<>(lsCarburant, HttpStatus.OK);
    }
}
