/**
 * 
 */
package org.autotrader.model;

import org.hibernate.annotations.Collate;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
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
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name="uuid", strategy = "uuid2")
	@Column(name="id_photo")
	String idPhoto;
	
	@Column(name="name")
	String name;
	
	@Column(name="contenttype")
	String contentType;
	
	@Column(name="size")
	Long size;
	
	@Lob
	byte[] data;
	
	@ManyToOne
	@JoinColumn(name="idannonce")
	Annonce annonce;
	
	public Photo() {
		
	}
	
	public String getIdPhoto() {
		return idPhoto;
	}
	
	public String getContentType() {
		return contentType;
	}
	
	public byte[] getData() {
		return data;
	}
	
	public String getName() {
		return name;
	}
	
	public Long getSize() {
		return size;
	}
	
	public Annonce getAnnonce() {
		return annonce;
	}
	
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	public void setData(byte[] data) {
		this.data = data;
	}
	
	public void setIdPhoto(String idPhoto) {
		this.idPhoto = idPhoto;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSize(Long size) {
		this.size = size;
	}
	
	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}
	
}
