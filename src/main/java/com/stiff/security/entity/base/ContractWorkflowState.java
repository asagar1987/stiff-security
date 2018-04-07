package com.stiff.security.entity.base;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the contract_workflow_state database table.
 * 
 */
@Entity
@Table(name="contract_workflow_state")
@NamedQuery(name="ContractWorkflowState.findAll", query="SELECT c FROM ContractWorkflowState c")
public class ContractWorkflowState implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=20)
	private String color;

	@Column(length=100)
	private String description;

	@Column(nullable=false, length=45)
	private String statename;

	//bi-directional many-to-one association to ContractWorkflow
	@OneToMany(mappedBy="contractWorkflowStateFrom")
	private List<ContractWorkflow> contractWorkflowsFrom;

	//bi-directional many-to-one association to ContractWorkflow
	@OneToMany(mappedBy="contractWorkflowStateTo")
	private List<ContractWorkflow> contractWorkflowsTo;

	public ContractWorkflowState() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatename() {
		return this.statename;
	}

	public void setStatename(String statename) {
		this.statename = statename;
	}

	public List<ContractWorkflow> getContractWorkflowsFrom() {
		return this.contractWorkflowsFrom;
	}

	public void setContractWorkflowsFrom(List<ContractWorkflow> contractWorkflowsFrom) {
		this.contractWorkflowsFrom = contractWorkflowsFrom;
	}

	public ContractWorkflow addContractWorkflowsFrom(ContractWorkflow contractWorkflowsFrom) {
		getContractWorkflowsFrom().add(contractWorkflowsFrom);
		contractWorkflowsFrom.setContractWorkflowStateFrom(this);

		return contractWorkflowsFrom;
	}

	public ContractWorkflow removeContractWorkflowsFrom(ContractWorkflow contractWorkflowsFrom) {
		getContractWorkflowsFrom().remove(contractWorkflowsFrom);
		contractWorkflowsFrom.setContractWorkflowStateFrom(null);

		return contractWorkflowsFrom;
	}

	public List<ContractWorkflow> getContractWorkflowsTo() {
		return this.contractWorkflowsTo;
	}

	public void setContractWorkflowsTo(List<ContractWorkflow> contractWorkflowsTo) {
		this.contractWorkflowsTo = contractWorkflowsTo;
	}

	public ContractWorkflow addContractWorkflowsTo(ContractWorkflow contractWorkflowsTo) {
		getContractWorkflowsTo().add(contractWorkflowsTo);
		contractWorkflowsTo.setContractWorkflowStateTo(this);

		return contractWorkflowsTo;
	}

	public ContractWorkflow removeContractWorkflowsTo(ContractWorkflow contractWorkflowsTo) {
		getContractWorkflowsTo().remove(contractWorkflowsTo);
		contractWorkflowsTo.setContractWorkflowStateTo(null);

		return contractWorkflowsTo;
	}

}