/**
 * 
 */
package org.autotrader.model;

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
@Table(name="commission")
public class Commission {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idcommission")
	Integer idCommission;
	
	@Column(name="min_tarif")
	double minTarif;
	
	@Column(name="max_tarif")
	double maxTarif;
	
	@Column(name="purcentage")
	int pourcentage;
	
	public Commission() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getIdCommission() {
		return idCommission;
	}
	
	public void setIdCommission(Integer idCommission) {
		this.idCommission = idCommission;
	}
	
	public double getMaxTarif() {
		return maxTarif;
	}
	
	public void setMaxTarif(double maxTarif) {
		this.maxTarif = maxTarif;
	}
	
	public double getMinTarif() {
		return minTarif;
	}
	
	public void setMinTarif(double minTarif) {
		this.minTarif = minTarif;
	}
	
	public int getPourcentage() {
		return pourcentage;
	}
	
	public void setPourcentage(int pourcentage) {
		this.pourcentage = pourcentage;
	}
	
}

