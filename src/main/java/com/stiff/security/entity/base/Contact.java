package com.stiff.security.entity.base;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the contact database table.
 * 
 */
@Entity
@Table(name="contact")
@NamedQuery(name="Contact.findAll", query="SELECT c FROM Contact c")
public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=100)
	private String contactnumber;

	@Column(nullable=false)
	private int preferred;

	//bi-directional many-to-one association to ContactType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="contact_type_ID", nullable=false)
	private ContactType contactType;

	//bi-directional many-to-one association to ContractWorkflow
	@OneToMany(mappedBy="contact")
	private List<ContractWorkflow> contractWorkflows;

	//bi-directional many-to-many association to Employee
	@ManyToMany(mappedBy="contacts")
	private List<Employee> employees;

	public Contact() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContactnumber() {
		return this.contactnumber;
	}

	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}

	public int getPreferred() {
		return this.preferred;
	}

	public void setPreferred(int preferred) {
		this.preferred = preferred;
	}

	public ContactType getContactType() {
		return this.contactType;
	}

	public void setContactType(ContactType contactType) {
		this.contactType = contactType;
	}

	public List<ContractWorkflow> getContractWorkflows() {
		return this.contractWorkflows;
	}

	public void setContractWorkflows(List<ContractWorkflow> contractWorkflows) {
		this.contractWorkflows = contractWorkflows;
	}

	public ContractWorkflow addContractWorkflow(ContractWorkflow contractWorkflow) {
		getContractWorkflows().add(contractWorkflow);
		contractWorkflow.setContact(this);

		return contractWorkflow;
	}

	public ContractWorkflow removeContractWorkflow(ContractWorkflow contractWorkflow) {
		getContractWorkflows().remove(contractWorkflow);
		contractWorkflow.setContact(null);

		return contractWorkflow;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}