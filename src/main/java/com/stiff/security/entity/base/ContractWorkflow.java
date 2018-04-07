package com.stiff.security.entity.base;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the contract_workflow database table.
 * 
 */
@Entity
@Table(name="contract_workflow")
@NamedQuery(name="ContractWorkflow.findAll", query="SELECT c FROM ContractWorkflow c")
public class ContractWorkflow implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false)
	private int actionuser;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date date;

	@Column(length=100)
	private String remarks;

	//bi-directional many-to-one association to Contact
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="contractid", nullable=false)
	private Contact contact;

	//bi-directional many-to-one association to ContractWorkflowState
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fromstatus", nullable=false)
	private ContractWorkflowState contractWorkflowStateFrom;

	//bi-directional many-to-one association to ContractWorkflowState
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tostatus", nullable=false)
	private ContractWorkflowState contractWorkflowStateTo;

	public ContractWorkflow() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getActionuser() {
		return this.actionuser;
	}

	public void setActionuser(int actionuser) {
		this.actionuser = actionuser;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Contact getContact() {
		return this.contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public ContractWorkflowState getContractWorkflowStateFrom() {
		return this.contractWorkflowStateFrom;
	}

	public void setContractWorkflowStateFrom(ContractWorkflowState contractWorkflowStateFrom) {
		this.contractWorkflowStateFrom = contractWorkflowStateFrom;
	}

	public ContractWorkflowState getContractWorkflowStateTo() {
		return this.contractWorkflowStateTo;
	}

	public void setContractWorkflowStateTo(ContractWorkflowState contractWorkflowStateTo) {
		this.contractWorkflowStateTo = contractWorkflowStateTo;
	}

}