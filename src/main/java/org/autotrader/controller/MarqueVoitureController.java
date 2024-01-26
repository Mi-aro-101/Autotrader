package org.autotrader.controller;

import org.autotrader.dto.MarqueVoitureDto;
import org.autotrader.service.MarqueVoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/")
public class MarqueVoitureController {
    
    @Autowired
    private MarqueVoitureService marqueVoitureService;

    @PostMapping("marque")
    public ResponseEntity<?> insertMarqueVoiture(@RequestBody MarqueVoitureDto marqueVoitureDto){
        try {
            return marqueVoitureService.insertMarqueVoiture(marqueVoitureDto);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString()+" : "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("marques")
    public ResponseEntity<?> getAllMarqueVoiture(){
        try {
           return marqueVoitureService.getAllMarqueVoitures();
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString()+" : "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
