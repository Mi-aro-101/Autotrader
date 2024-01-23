/**
 * 
 */
package org.autotrader.repository;

import org.autotrader.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author miaro
 *
 */
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

	Utilisateur findByEmail(String email);
	
}
