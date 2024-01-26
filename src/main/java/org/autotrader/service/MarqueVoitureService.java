package org.autotrader.service;

import java.util.ArrayList;

import org.autotrader.dto.MarqueVoitureDto;
import org.autotrader.model.MarqueVoiture;
import org.autotrader.repository.MarqueVoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MarqueVoitureService {
    
    @Autowired
    private MarqueVoitureRepository marqueVoitureRepository;

    public ResponseEntity<?> insertMarqueVoiture(MarqueVoitureDto marqueVoitureDto){
        MarqueVoiture marque = new MarqueVoiture();
        marque.setIdMarqueVoiture(marqueVoitureDto.getIdMarqueVoiture());
        marque.setNom(marqueVoitureDto.getNomMarqueVoiture());
        marqueVoitureRepository.save(marque);

        return new ResponseEntity<>("Insertion avec succes", HttpStatus.OK);
    }

    public ResponseEntity<?> getAllMarqueVoitures(){
        ArrayList<MarqueVoiture> lsMarqueVoitures = new ArrayList<>();
        marqueVoitureRepository.findAll().forEach(lsMarqueVoitures::add);
        
        return new ResponseEntity<>(lsMarqueVoitures, HttpStatus.OK);
    }

}
