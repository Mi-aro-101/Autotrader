/**
 * 
 */
package org.autotrader.model;

import java.util.Set;
import org.hibernate.annotations.ManyToAny;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;

/**
 * @author miaro
 *
 */
@Entity
@Table(name="utilisateur")
public class Utilisateur {

	@Id
	@Column(name="idutilisateur")
	Integer idUtilisateur;
	
	@Column(name="email")
	String email;
	
	@Column(name="password")
	String password;
	
	@ManyToAny(fetch = FetchType.EAGER)
	@JoinTable(
			name="utilisateur_role",
			joinColumns = {@JoinColumn(name="idutilisateur", referencedColumnName = "idutilisateur")},
			inverseJoinColumns = {@JoinColumn(name="idrole", referencedColumnName = "idrole")}
			)
	private Set<Role> roles;
	
	
	public Integer getIdUtilisateur() {
		return idUtilisateur;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}
	
	public void setIdUtilisateur(Integer idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}
