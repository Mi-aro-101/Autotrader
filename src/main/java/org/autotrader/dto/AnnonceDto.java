/**
 * 
 */
package org.autotrader.dto;

/**
 * @author miaro
 *
 */
public class AnnonceDto {
	
	Integer annee;
	String descriptionAnnonce;
	int nombrePlace;
	int nombrePorte;
	double puissance;
	double kilometrage;
	double tarif;
	// Utilisateur ato fa tsy haiko ,mila atao
	
	//////////////////////////////////////////
	Integer idCarburant;
	Integer idCategorieVoiture;
	Integer idModeleVoiture;
	
	public AnnonceDto() {
		// TODO Auto-generated constructor stub
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
	
	public Integer getIdCarburant() {
		return idCarburant;
	}
	
	public Integer getIdCategorieVoiture() {
		return idCategorieVoiture;
	}
	
	public Integer getIdModeleVoiture() {
		return idModeleVoiture;
	}
	
	public double getKilometrage() {
		return kilometrage;
	}
	
	public double getPuissance() {
		return puissance;
	}
	
	public double getTarif() {
		return tarif;
	}
	
	public void setAnnee(Integer annee) {
		this.annee = annee;
	}
	
	public void setDescriptionAnnonce(String descriptionAnnonce) {
		this.descriptionAnnonce = descriptionAnnonce;
	}
	
	public void setIdCarburant(Integer idCarburant) {
		this.idCarburant = idCarburant;
	}
	
	public void setIdCategorieVoiture(Integer idCategorieVoiture) {
		this.idCategorieVoiture = idCategorieVoiture;
	}
	
	public void setIdModeleVoiture(Integer idModeleVoiture) {
		this.idModeleVoiture = idModeleVoiture;
	}
	
	public void setKilometrage(double kilometrage) {
		this.kilometrage = kilometrage;
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
	
	public void setTarif(double tarif) {
		this.tarif = tarif;
	}

}
