package com.pn.model.Customer;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "RatePotential")
public class RatePotential {

	@Id
	@Column(name = "ratePotentialId", nullable = false) 
	private Integer  ratePotentialId;
	@Column(name = "Description", nullable = false, length=20) 
	private String  description;
	
	@OneToMany(mappedBy="ratePotential", fetch=FetchType.EAGER)
	private List<CustomerPotential> RatePotential;

	public void setRatePotentialId(int ratePotentialId) {
		this.ratePotentialId = ratePotentialId;
	}

	public int getRatePotentialId() {
		return ratePotentialId;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setRatePotential(List<CustomerPotential> ratePotential) {
		RatePotential = ratePotential;
	}

	public List<CustomerPotential> getRatePotential() {
		return RatePotential;
	}
}
