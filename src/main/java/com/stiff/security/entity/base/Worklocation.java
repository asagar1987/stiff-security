package com.stiff.security.entity.base;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;



/**
 * The persistent class for the worklocation database table.
 * 
 */
@Entity
@Table(name = "worklocation")
@NamedQuery(name = "Worklocation.findAll", query = "SELECT w FROM Worklocation w")
public class Worklocation implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(nullable = false, length = 45)
	private String locationname;

	// bi-directional many-to-one association to Conduct
	@OneToMany(mappedBy = "worklocation")
	private List<Conduct> conducts;

	// bi-directional many-to-one association to Employee
	@OneToMany(mappedBy = "worklocation")
	private List<Employee> employees;

	// bi-directional many-to-one association to VacantPost
	@OneToMany(mappedBy = "worklocation")
	private List<VacantPost> vacantPosts;

	// bi-directional many-to-one association to Address
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_ID", nullable = false)
	private Address address;

	// bi-directional many-to-one association to WorklocationType
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "worklocation_type_ID", nullable = false)
	private WorklocationType worklocationType;

	// bi-directional many-to-many association to Contract
	@ManyToMany
	@JoinColumn(name = "ID", nullable = false, insertable = false, updatable = false)
	private List<Contract> contracts;

	public Worklocation()
	{
	}

	public int getId()
	{
		return this.id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getLocationname()
	{
		return this.locationname;
	}

	public void setLocationname(String locationname)
	{
		this.locationname = locationname;
	}

	public List<Conduct> getConducts()
	{
		return this.conducts;
	}

	public void setConducts(List<Conduct> conducts)
	{
		this.conducts = conducts;
	}

	public Conduct addConduct(Conduct conduct)
	{
		getConducts().add(conduct);
		conduct.setWorklocation(this);

		return conduct;
	}

	public Conduct removeConduct(Conduct conduct)
	{
		getConducts().remove(conduct);
		conduct.setWorklocation(null);

		return conduct;
	}

	public List<Employee> getEmployees()
	{
		return this.employees;
	}

	public void setEmployees(List<Employee> employees)
	{
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee)
	{
		getEmployees().add(employee);
		employee.setWorklocation(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee)
	{
		getEmployees().remove(employee);
		employee.setWorklocation(null);

		return employee;
	}

	public List<VacantPost> getVacantPosts()
	{
		return this.vacantPosts;
	}

	public void setVacantPosts(List<VacantPost> vacantPosts)
	{
		this.vacantPosts = vacantPosts;
	}

	public VacantPost addVacantPost(VacantPost vacantPost)
	{
		getVacantPosts().add(vacantPost);
		vacantPost.setWorklocation(this);

		return vacantPost;
	}

	public VacantPost removeVacantPost(VacantPost vacantPost)
	{
		getVacantPosts().remove(vacantPost);
		vacantPost.setWorklocation(null);

		return vacantPost;
	}

	public Address getAddress()
	{
		return this.address;
	}

	public void setAddress(Address address)
	{
		this.address = address;
	}

	public WorklocationType getWorklocationType()
	{
		return this.worklocationType;
	}

	public void setWorklocationType(WorklocationType worklocationType)
	{
		this.worklocationType = worklocationType;
	}

	public List<Contract> getContracts()
	{
		return this.contracts;
	}

	public void setContracts(List<Contract> contracts)
	{
		this.contracts = contracts;
	}

}