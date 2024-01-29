/**
 * 
 */
package org.autotrader.repository;

import org.autotrader.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author miaro
 *
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByDesignation(String designation);
	
}
