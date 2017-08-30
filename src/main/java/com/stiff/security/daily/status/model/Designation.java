package com.stiff.security.daily.status.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Entity
@Table(name="designations")
@Component
public class Designation implements Serializable
{

	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	@Column(name="designationid")
	private long designationId;
	@Column(name="designationname")
	private String designationName;
	@OneToMany(mappedBy="designation", fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	private Set<Employee> employees;
	@OneToMany(mappedBy="designation", fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	private Set<FieldOfficer> fieldOfficers;
	
	
	
	public Set<FieldOfficer> getFieldOfficers()
	{
		return fieldOfficers;
	}
	public void setFieldOfficers(Set<FieldOfficer> fieldOfficers)
	{
		this.fieldOfficers = fieldOfficers;
	}
	public long getDesignationId()
	{
		return designationId;
	}
	public void setDesignationId(long designationId)
	{
		this.designationId = designationId;
	}
	public String getDesignationName()
	{
		return designationName;
	}
	public void setDesignationName(String designationName)
	{
		this.designationName = designationName;
	}
	public Set<Employee> getEmployees()
	{
		return employees;
	}
	public void setEmployees(Set<Employee> employees)
	{
		this.employees = employees;
	}
		
	@Override
	public String toString()
	{
		return "Designation [designationId=" + designationId + ", designationName=" + designationName + "]";
	}
	
	public Designation(String designationName)
	{
		this.designationName=designationName;
		
	}
	public Designation()
	{
		
	}
}
