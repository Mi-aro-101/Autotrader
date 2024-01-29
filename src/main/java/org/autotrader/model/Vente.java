/**
 * 
 */
package org.autotrader.model;

import java.time.LocalDate;

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
@Table(name="vente")
public class Vente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idvente")
	Integer idVente;
	
	@Column(name="date_vente")
	LocalDate dateVente;
	
	//Contient le vendeur
	@ManyToOne
	@JoinColumn(name="idannonce")
	Annonce annonce;
	
	// Acheteur
	@ManyToOne
	@JoinColumn(name="idutilisateur")
	Utilisateur utilisateur;
	
	public Vente() {
		// TODO Auto-generated constructor stub
	}
	
	public Annonce getAnnonce() {
		return annonce;
	}
	
	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}
	
	public LocalDate getDateVente() {
		return dateVente;
	}
	
	public void setDateVente(LocalDate dateVente) {
		this.dateVente = dateVente;
	}
	
	public Integer getIdVente() {
		return idVente;
	}
	
	public void setIdVente(Integer idVente) {
		this.idVente = idVente;
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
}
