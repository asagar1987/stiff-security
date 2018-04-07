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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the state database table.
 * 
 */
@Entity
@Table(name = "state")
@NamedQuery(name = "State.findAll", query = "SELECT s FROM State s")
public class State implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(nullable = false, length = 50)
	private String admincapital;

	@Column(nullable = false, length = 50)
	private String judiciarycapital;

	@Column(nullable = false, length = 50)
	private String legislativecapital;

	@Column(nullable = false, length = 45)
	private String statename;

	// bi-directional many-to-one association to Country
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country_ID", nullable = false, insertable = false, updatable = false)
	private Country country;

	public State()
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

	public String getAdmincapital()
	{
		return this.admincapital;
	}

	public void setAdmincapital(String admincapital)
	{
		this.admincapital = admincapital;
	}

	public String getJudiciarycapital()
	{
		return this.judiciarycapital;
	}

	public void setJudiciarycapital(String judiciarycapital)
	{
		this.judiciarycapital = judiciarycapital;
	}

	public String getLegislativecapital()
	{
		return this.legislativecapital;
	}

	public void setLegislativecapital(String legislativecapital)
	{
		this.legislativecapital = legislativecapital;
	}

	public String getStatename()
	{
		return this.statename;
	}

	public void setStatename(String statename)
	{
		this.statename = statename;
	}

	public Country getCountry()
	{
		return this.country;
	}

	public void setCountry(Country country)
	{
		this.country = country;
	}
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="state")
	private List<City> cities;

	public List<City> getCities()
	{
		return cities;
	}

	public void setCities(List<City> cities)
	{
		this.cities = cities;
	}
	

}