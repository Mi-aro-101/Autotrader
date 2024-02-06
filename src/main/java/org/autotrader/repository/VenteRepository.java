/**
 * 
 */
package org.autotrader.repository;

import java.util.List;

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
	
	@Query(value = "SELECT v from Vente v where v.annonce.utilisateur.idUtilisateur = ?1")
	List<Vente> getDemande(Integer idutilisateur);
	
	@Query(value = "SELECT v from Vente v where v.utilisateur.idUtilisateur = ?1")
	List<Vente> getDemandeEnvoyes(Integer idUtilisateur);

}
