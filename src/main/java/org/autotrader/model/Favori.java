/**
 * 
 */
package org.autotrader.model;

import org.hibernate.annotations.Collate;

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
@Table(name="favori")
public class Favori {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idfavor")
	Integer idFavori;
	
	@ManyToOne
	@JoinColumn(name="idUtilisateur")
	Utilisateur utilisateur;
	
	@ManyToOne
	@JoinColumn(name="idannonce")
	Annonce annonce;
	
	public Favori() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getIdFavori() {
		return idFavori;
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	
	public Annonce getAnnonce() {
		return annonce;
	}
	
	public void setIdFavori(Integer idFavori) {
		this.idFavori = idFavori;
	}
	
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}
	
}
