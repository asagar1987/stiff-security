/**
 * 
 */
package com.stiff.security.entity.base;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author asaga3
 *
 */
@Entity
@Table(name="city")

public class City implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1102206423199541165L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;
	
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getCityName()
	{
		return cityName;
	}

	public void setCityName(String cityName)
	{
		this.cityName = cityName;
	}

	public State getState()
	{
		return state;
	}

	public void setState(State state)
	{
		this.state = state;
	}

	@Column(name="city_name")
	private String cityName;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="state_ID", nullable=false, insertable=false, updatable=false)
	private State state;

	@Override
	public String toString()
	{
		return "City [id=" + id + ", cityName=" + cityName + ", state=" + state + "]";
	}
	
	public City()
	{
		
	}
}
