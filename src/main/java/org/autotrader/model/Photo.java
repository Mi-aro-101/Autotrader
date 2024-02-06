/**
 * 
 */
package org.autotrader.model;

import jakarta.persistence.Column;
/**
 * @author miaro
 *
 */
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name="photo")
public class Photo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_photo")
	Integer idPhoto;
	
	@ManyToOne
	@JoinColumn(name="id_annonce")
	@Getter @Setter
	Annonce annonce;
	
	@Column(name="url_photo")
	String urlPhoto;
	
	public Photo() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getIdPhoto() {
		return idPhoto;
	}
	
	public Annonce getAnnonce() {
		return annonce;
	}
	
	public String getUrlPhoto() {
		return urlPhoto;
	}
	
	public void setIdPhoto(Integer idPhoto) {
		this.idPhoto = idPhoto;
	}
	
	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}
	
	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}
	
}
