/**
 * 
 */
package org.autotrader.repository;

import java.util.List;

import org.autotrader.model.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author miaro
 *
 */
public interface AnnonceRepository extends JpaRepository<Annonce, Integer> {

	@Query(nativeQuery = true, value = "SELECT nextval('annonce_idannonce_seq')")
	Integer getAnnonceSeq();
	
	List<Annonce> findByEtat(Integer etat);
	
}
