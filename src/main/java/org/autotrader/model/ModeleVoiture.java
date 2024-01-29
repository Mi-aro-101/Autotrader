/**
 * 
 */
package org.autotrader.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author miaro
 *
 */
@Entity
@Table(name="modele_voiture")
public class ModeleVoiture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idmodele_voiture")
	Integer idModeleVoiture;
	
	@Column(name="nom")
	String nom;
	
	@ManyToOne
	@JoinColumn(name="idmarque_voiture")
	MarqueVoiture marqueVoiture;
	
	public ModeleVoiture() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getIdModeleVoiture() {
		return idModeleVoiture;
	}
	
	public String getNom() {
		return nom;
	}
	
	public MarqueVoiture getMarqueVoiture() {
		return marqueVoiture;
	}
	
	public void setIdModeleVoiture(Integer idModeleVoiture) {
		this.idModeleVoiture = idModeleVoiture;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setMarqueVoiture(MarqueVoiture marqueVoiture) {
		this.marqueVoiture = marqueVoiture;
	}
}
