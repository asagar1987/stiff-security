package com.stiff.security.daily.status.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Entity
@Table(name="fieldofficer")
@Component
public class FieldOfficer implements Serializable
{

	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	@Column(name="fieldofficerid")
	private long fieldOfficerId;
	@Column(name="fieldOfficerName")
	private String fieldOfficerName;
	@Column(name="shift")
	private String shift;
	@ManyToOne
	@JoinColumn(name="designationid")
	private Designation designation;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="fieldOfficer", cascade=CascadeType.PERSIST)
	private Set<Site> site;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	
	@Column(name="active")
	private boolean active;
	public boolean isActive()
	{
		return active;
	}
	public void setActive(boolean active)
	{
		this.active = active;
	}
	public long getFieldOfficerId()
	{
		return fieldOfficerId;
	}
	public void setFieldOfficerId(long fieldOfficerId)
	{
		this.fieldOfficerId = fieldOfficerId;
	}
	public String getFieldOfficerName()
	{
		return fieldOfficerName;
	}
	public void setFieldOfficerName(String fieldOfficerName)
	{
		this.fieldOfficerName = fieldOfficerName;
	}
	public String getShift()
	{
		return shift;
	}
	public void setShift(String shift)
	{
		this.shift = shift;
	}
	public Designation getDesignation()
	{
		return designation;
	}
	public void setDesignation(Designation designation)
	{
		this.designation = designation;
	}
	public Set<Site> getSite()
	{
		return site;
	}
	public void setSite(Set<Site> site)
	{
		this.site = site;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	
	public FieldOfficer()
	{
		this.setSite(new HashSet());
	}
	
	
		
}
