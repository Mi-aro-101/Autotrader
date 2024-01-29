/**
 * 
 */
package org.autotrader.repository;

import java.util.Optional;

import org.autotrader.model.Commission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author miaro
 *
 */
public interface CommissionRepository extends JpaRepository<Commission, Integer> {
	
	@Query(nativeQuery = true,
			value = "SELECT * FROM commission where min_tarif <= ?1 and max_tarif >= ?1")	
	Optional<Commission> getCommissionCorrespondant(double tarif);

}
