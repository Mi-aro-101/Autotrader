package org.autotrader.controller;

import org.autotrader.dto.ModeleVoitureDto;
import org.autotrader.service.ModeleVoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/")
public class ModeleVoitureController {

    @Autowired
    private ModeleVoitureService modeleVoitureService;

    @PostMapping("/modele")
    public ResponseEntity<?> insertCarburant(@RequestBody ModeleVoitureDto modeleVoitureDto) {
        try {
            return modeleVoitureService.insertModeleVoiture(modeleVoitureDto);
            
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString()+" : "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/modele/{idMarque}")
    public ResponseEntity<?> getModeleByMarque(@PathVariable(value = "idMarque") Integer idMarque) {
        try {
            ResponseEntity<?> response = modeleVoitureService.getModeleVoitureByIdMarque(idMarque);
            return response; 
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString()+" : "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
