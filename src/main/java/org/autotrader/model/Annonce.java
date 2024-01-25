
/**
 * 
 */
package org.autotrader.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * @author miaro
 *
 */
@Entity
@Table(name="annonce")
public class Annonce {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idannonce")
	Integer idAnnonce;
	
	@Column(name="annee")
	Integer annee;
	
	@Column(name="description_annonce")
	String descriptionAnnonce;
	
	@Column(name="nombre_place")
	int nombrePlace;
	
	@Column(name="nombre_porte")
	int nombrePorte;
	
	@Column(name="puissance")
	double puissance;
	
	@Column(name="kilometrage")
	double kilometrage;
	
	@Column(name="tarif")
	double tarif;
	
	@Column(name="date_annonce")
	LocalDateTime dateAnnonce;
	
	@Column(name="etat")
	Integer etat;
	
	@ManyToOne
	@JoinColumn(name="idutilisateur")
	Utilisateur utilisateur;
	
	@ManyToOne
	@JoinColumn(name="idcarburant")
	Carburant carburant;
	
	@ManyToOne
	@JoinColumn(name="idcategorie_voiture")
	CategorieVoiture categorieVoiture;
	
	@ManyToOne
	@JoinColumn(name="idmodele_voiture")
	ModeleVoiture modeleVoiture;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "annonce", cascade = CascadeType.ALL)
	List<Photo> photos;
	
	public Annonce() {
		
	}
	
	public Integer getIdAnnonce() {
		return idAnnonce;
	}
	
	public Integer getAnnee() {
		return annee;
	}
	
	public String getDescriptionAnnonce() {
		return descriptionAnnonce;
	}
	
	public int getNombrePlace() {
		return nombrePlace;
	}
	
	public int getNombrePorte() {
		return nombrePorte;
	}
	
	public double getPuissance() {
		return puissance;
	}
	
	public double getKilometrage() {
		return kilometrage;
	}
	
	public double getTarif() {
		return tarif;
	}
	
	public LocalDateTime getDateAnnonce() {
		return dateAnnonce;
	}
	
	public Integer getEtat() {
		return etat;
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	
	public Carburant getCarburant() {
		return carburant;
	}
	
	public CategorieVoiture getCategorieVoiture() {
		return categorieVoiture;
	}
	
	public ModeleVoiture getModeleVoiture() {
		return modeleVoiture;
	}
	
	public List<Photo> getPhotos() {
		return photos;
	}
	
	public void setIdAnnonce(Integer idAnnonce) {
		this.idAnnonce = idAnnonce;
	}
	
	public void setAnnee(Integer annee) {
		this.annee = annee;
	}
	
	
	public void setDescriptionAnnonce(String descriptionAnnonce) {
		this.descriptionAnnonce = descriptionAnnonce;
	}
	
	public void setNombrePlace(int nombrePlace) {
		this.nombrePlace = nombrePlace;
	}
	
	public void setNombrePorte(int nombrePorte) {
		this.nombrePorte = nombrePorte;
	}
	
	public void setPuissance(double puissance) {
		this.puissance = puissance;
	}
	
	public void setKilometrage(double kilometrage) {
		this.kilometrage = kilometrage;
	}
	
	public void setTarif(double tarif) {
		this.tarif = tarif;
	}
	
	public void setDateAnnonce(LocalDateTime dateAnnonce) {
		this.dateAnnonce = dateAnnonce;
	}
	
	public void setEtat(Integer etat) {
		this.etat = etat;
	}
	
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	public void setCarburant(Carburant carburant) {
		this.carburant = carburant;
	}
	
	public void setCategorieVoiture(CategorieVoiture categorieVoiture) {
		this.categorieVoiture = categorieVoiture;
	}
	
	public void setModeleVoiture(ModeleVoiture modeleVoiture) {
		this.modeleVoiture = modeleVoiture;
	}
	
	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
}
