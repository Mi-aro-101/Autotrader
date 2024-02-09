/**
 * 
 */
package org.autotrader.repository;

import java.util.List;

import org.autotrader.model.Favori;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author miaro
 *
 */
public interface FavoriRepository extends JpaRepository<Favori, Integer> {
	
	@Query(value = "SELECT f from Favori f where f.utilisateur.idUtilisateur = ?1")
	List<Favori> getMyFavoris(Integer idUser);

}
