/**
 * 
 */
package org.autotrader.repository;

import org.autotrader.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author miaro
 *
 */
public interface PhotoRepository extends JpaRepository<Photo, String> {

}
