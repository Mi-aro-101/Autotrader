/**
 * 
 */
package org.autotrader.repository;

import org.autotrader.model.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author miaro
 *
 */
public interface VenteRepository extends JpaRepository<Vente, Integer> {
	
	@Query(nativeQuery = true, value = "SELECT nextVal('vente_idvente_seq')")
	Integer getVenteSeq();

}
