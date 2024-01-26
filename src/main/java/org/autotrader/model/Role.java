/**
 * 
 */
package org.autotrader.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author miaro
 *
 */
@Entity
@Table(name="role")
public class Role {

	@Id
	@Column(name="idrole")
	Integer idRole;
	
	@Column(name="designation")
	String designation;
	
	public Integer getIdRole() {
		return idRole;
	}
	
	public String getDesignation() {
		return designation;
	}
	
	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}
	
	public void setDesignation(String designation) {
		this.designation = designation;
	}
}
