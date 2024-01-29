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
@Table(name="marque_voiture")
public class MarqueVoiture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idmarque_voiture")
	Integer idMarqueVoiture;
	
	@Column(name="nom")
	String nom;
	
	public MarqueVoiture() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getIdMarqueVoiture() {
		return idMarqueVoiture;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setIdMarqueVoiture(Integer idMarqueVoiture) {
		this.idMarqueVoiture = idMarqueVoiture;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
}
