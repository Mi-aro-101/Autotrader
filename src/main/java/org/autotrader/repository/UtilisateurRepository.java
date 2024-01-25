/**
 * 
 */
package org.autotrader.repository;

import org.autotrader.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author miaro
 *
 */
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

	Utilisateur findByEmail(String email);
	
	@Query(nativeQuery = true, value="SELECT nextval('utilisateur_idutilisateur_seq')")
	Integer getUtilisateurSeq();
	
}
