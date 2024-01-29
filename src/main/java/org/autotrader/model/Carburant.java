/**
 * 
 */
package org.autotrader.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author miaro
 *
 */
@Entity
@Table(name="carburant")
public class Carburant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idcarburant")
	Integer idCarburant;
	
	
	@Column(name="nom")
	String nom;
	
	public Carburant() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getIdCarburant() {
		return idCarburant;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setIdCarburant(Integer idCarburant) {
		this.idCarburant = idCarburant;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
}
