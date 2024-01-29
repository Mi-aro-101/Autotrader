/**
 * 
 */
package org.autotrader.model;

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
@Table(name="commission_vente")
public class CommissionVente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idcommission_vente")
	Integer idCommissionVente;
	
	@ManyToOne
	@JoinColumn(name="idvente")
	Vente vente;
	
	@Column(name="valeur_commission")
	double valeurCommission;
	
	@Column(name="statut")
	int statut;
	
	public CommissionVente() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getIdCommissionVente() {
		return idCommissionVente;
	}
	
	public void setIdCommissionVente(Integer idCommissionVente) {
		this.idCommissionVente = idCommissionVente;
	}
	
	public int getStatut() {
		return statut;
	}
	
	public void setStatut(int statut) {
		this.statut = statut;
	}
	
	public double getValeurCommission() {
		return valeurCommission;
	}
	
	public void setValeurCommission(double valeurCommission) {
		this.valeurCommission = valeurCommission;
	}
	
	public Vente getVente() {
		return vente;
	}
	
	public void setVente(Vente vente) {
		this.vente = vente;
	}
	
}
