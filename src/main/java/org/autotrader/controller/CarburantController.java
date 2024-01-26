package org.autotrader.controller;


import org.autotrader.dto.CarburantDto;
import org.autotrader.service.CarburantService;
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
public class CarburantController {

    @Autowired
    private CarburantService carburantService;

    @PostMapping("/carburant")
    public ResponseEntity<?> insertCarburant(@RequestBody CarburantDto carburantDto) {
        try {
            return carburantService.insertCarburant(carburantDto);
            
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString()+" : "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/carburants")
    public ResponseEntity<?> getAllCarburants(){
        try {
            return carburantService.getCarburants();
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString()+" : "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
