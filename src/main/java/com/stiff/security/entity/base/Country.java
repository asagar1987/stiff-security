package com.stiff.security.entity.base;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the country database table.
 * 
 */
@Entity
@Table(name="country")
@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=45)
	private String countrycurrency;

	@Column(nullable=false, length=45)
	private String countryname;

	@Column(nullable=false, length=3)
	private String countrysymbol;

	@Column(length=10)
	private String currencysymbol;

	
	public Country() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountrycurrency() {
		return this.countrycurrency;
	}

	public void setCountrycurrency(String countrycurrency) {
		this.countrycurrency = countrycurrency;
	}

	public String getCountryname() {
		return this.countryname;
	}

	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}

	public String getCountrysymbol() {
		return this.countrysymbol;
	}

	public void setCountrysymbol(String countrysymbol) {
		this.countrysymbol = countrysymbol;
	}

	public String getCurrencysymbol() {
		return this.currencysymbol;
	}

	public void setCurrencysymbol(String currencysymbol) {
		this.currencysymbol = currencysymbol;
	}

	

}