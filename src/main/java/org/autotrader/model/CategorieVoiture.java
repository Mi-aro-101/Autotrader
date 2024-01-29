/**
 * 
 */
package org.autotrader.model;

import java.util.Set;

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
@Table(name="categorie_voiture")
public class CategorieVoiture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idcategorie_voiture")
	Integer idCategorieVoiture;
	
	@Column(name="nom")
	String nom;
	
	public CategorieVoiture() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getIdCategorieVoiture() {
		return idCategorieVoiture;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setIdCategorieVoiture(Integer idCategorieVoiture) {
		this.idCategorieVoiture = idCategorieVoiture;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
