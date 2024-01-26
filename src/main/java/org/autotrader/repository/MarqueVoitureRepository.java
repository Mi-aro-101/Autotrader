package org.autotrader.repository;

import org.autotrader.model.MarqueVoiture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarqueVoitureRepository extends JpaRepository<MarqueVoiture, Integer> {
    
}
