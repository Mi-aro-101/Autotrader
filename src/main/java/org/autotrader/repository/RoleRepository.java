/**
 * 
 */
package org.autotrader.repository;

import java.util.Optional;

import org.autotrader.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author miaro
 *
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {

	Optional<Role> findByDesignation(String designation);
	
}
