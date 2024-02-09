/**
 * 
 */
package org.autotrader.repository;

import java.util.List;

import org.autotrader.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author miaro
 *
 */
public interface PhotoRepository extends JpaRepository<Photo, Integer> {
	

}
