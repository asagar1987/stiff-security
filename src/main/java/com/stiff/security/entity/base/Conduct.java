package com.stiff.security.entity.base;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the conducts database table.
 * 
 */
@Entity
@Table(name="conducts")
@NamedQuery(name="Conduct.findAll", query="SELECT c FROM Conduct c")
public class Conduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date conductdate;

	@Column(length=200)
	private String remarks;

	//bi-directional many-to-one association to Client
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="clients_ID", nullable=false)
	private Client client;

	//bi-directional many-to-one association to ConductType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="conduct_type_ID", nullable=false)
	private ConductType conductType;

	//bi-directional many-to-one association to Employee
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="employee_ID", nullable=false)
	private Employee employee;

	//bi-directional many-to-one association to Worklocation
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="worklocation_ID", nullable=false)
	private Worklocation worklocation;

	public Conduct() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getConductdate() {
		return this.conductdate;
	}

	public void setConductdate(Date conductdate) {
		this.conductdate = conductdate;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public ConductType getConductType() {
		return this.conductType;
	}

	public void setConductType(ConductType conductType) {
		this.conductType = conductType;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Worklocation getWorklocation() {
		return this.worklocation;
	}

	public void setWorklocation(Worklocation worklocation) {
		this.worklocation = worklocation;
	}

}