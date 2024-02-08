/**
 * 
 */
package org.autotrader.model;

import jakarta.persistence.CascadeType;
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
@Table(name="photo")
public class Photo {
	
	@Id
	@Column(name="id_photo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idPhoto;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_annonce")
	Annonce annonce;
	
	@Column(name="url_photo")
	String urlPhoto;
	
	public Photo() {
	}
	
//	public Annonce getAnnonce() {
//		return annonce;
//	}
	
	public Integer getIdPhoto() {
		return idPhoto;
	}
	
	public String getUrlPhoto() {
		return urlPhoto;
	}
	
	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}
	
	public void setIdPhoto(Integer idPhoto) {
		this.idPhoto = idPhoto;
	}
	
	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}

}
