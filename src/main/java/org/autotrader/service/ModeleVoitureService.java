package org.autotrader.service;

import java.util.ArrayList;

import org.autotrader.dto.ModeleVoitureDto;
import org.autotrader.model.MarqueVoiture;
import org.autotrader.model.ModeleVoiture;
import org.autotrader.repository.MarqueVoitureRepository;
import org.autotrader.repository.ModeleVoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class ModeleVoitureService {

    @Autowired
    private MarqueVoitureRepository marqueVoitureRepository;

    @Autowired
    private ModeleVoitureRepository modeleVoitureRepository;

    
    public ResponseEntity<?> insertModeleVoiture(ModeleVoitureDto modeleVoitureDto){

        MarqueVoiture marque = marqueVoitureRepository.findById(modeleVoitureDto.getIdMarqueVoiture()).orElseThrow();

        ModeleVoiture modele = new ModeleVoiture();
        modele.setNom(modeleVoitureDto.getNomModeleVoiture());
        modele.setMarqueVoiture(marque);

        modeleVoitureRepository.save(modele);

        return new ResponseEntity<>("Insertion avec succes", HttpStatus.OK);
    }

    public ResponseEntity<?> getModeleVoitureByIdMarque(Integer idMarque) {

        ArrayList<ModeleVoiture> modeles = modeleVoitureRepository.findByMarqueVoitureId(idMarque);
    
        if (modeles.isEmpty()) {
            return new ResponseEntity<>("Aucun modèle trouvé pour la marque spécifiée", HttpStatus.NOT_FOUND);
        }
    
        return new ResponseEntity<>(modeles, HttpStatus.OK);
    }
    
}
