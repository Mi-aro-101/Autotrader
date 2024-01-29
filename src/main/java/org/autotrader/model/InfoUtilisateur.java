/**
 * 
 */
package org.autotrader.model;

import jakarta.annotation.Generated;
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
@Table(name="info_utilisateur")
public class InfoUtilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idinfo_utilisateur")
	Integer idInfoUtilisateur;
	
	@Column(name="nom")
	String nom;
	
	@Column(name="prenom")
	String prenom;
	
	@Column(name="contact")
	String contact;
	
	@Column(name="adresse")
	String adresse;
	
	@ManyToOne
	@JoinColumn(name = "idutilisateur")
	Utilisateur utilisateur;
	
	public InfoUtilisateur() {
		// TODO Auto-generated constructor stub
	}
	
	public String getAdresse() {
		return adresse;
	}
	
	public String getContact() {
		return contact;
	}
	
	public Integer getIdInfoUtilisateur() {
		return idInfoUtilisateur;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public void setIdInfoUtilisateur(Integer idInfoUtilisateur) {
		this.idInfoUtilisateur = idInfoUtilisateur;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
}
