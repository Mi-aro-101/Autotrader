/**
 * 
 */
package org.autotrader.repository;

import java.util.ArrayList;

import org.autotrader.model.ModeleVoiture;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author miaro
 *
 */
public interface ModeleVoitureRepository extends JpaRepository<ModeleVoiture, Integer> {

    ArrayList<ModeleVoiture> findByMarqueVoitureId(Integer idMarque);

}
