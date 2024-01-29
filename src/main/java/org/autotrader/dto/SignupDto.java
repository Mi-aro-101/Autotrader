/**
 * 
 */
package org.autotrader.dto;

/**
 * @author miaro
 *
 */
public class SignupDto {

	String email;
	String password;
	String nom;
	String prenom;
	String contact;
	String adresse;
	
	public SignupDto() {}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	
	public String getAdresse() {
		return adresse;
	}
	
	public String getContact() {
		return contact;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setEmail(String email)throws Exception {
		this.email = email;
	}
	
	public void setPassword(String password)throws Exception {
		this.password = password;
	}
	
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
