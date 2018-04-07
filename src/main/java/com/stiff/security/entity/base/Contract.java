package com.stiff.security.entity.base;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the contract database table.
 * 
 */
@Entity
@Table(name="contract")
@NamedQuery(name="Contract.findAll", query="SELECT c FROM Contract c")
public class Contract implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date contractenddate;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date contractstartdate;

	//bi-directional many-to-many association to Worklocation
	@ManyToMany(mappedBy="contracts")
	private List<Worklocation> worklocations;

	public Contract() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getContractenddate() {
		return this.contractenddate;
	}

	public void setContractenddate(Date contractenddate) {
		this.contractenddate = contractenddate;
	}

	public Date getContractstartdate() {
		return this.contractstartdate;
	}

	public void setContractstartdate(Date contractstartdate) {
		this.contractstartdate = contractstartdate;
	}

	public List<Worklocation> getWorklocations() {
		return this.worklocations;
	}

	public void setWorklocations(List<Worklocation> worklocations) {
		this.worklocations = worklocations;
	}

}