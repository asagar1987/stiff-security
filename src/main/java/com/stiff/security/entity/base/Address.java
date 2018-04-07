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
@Table(name="address")
public class Address implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1531540966417577001L;

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

	public AddressType getAddressType()
	{
		return addressType;
	}

	public void setAddressType(AddressType addressType)
	{
		this.addressType = addressType;
	}

	public City getCity()
	{
		return city;
	}

	public void setCity(City city)
	{
		this.city = city;
	}
	
	public String getAddressLine1()
	{
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1)
	{
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2()
	{
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2)
	{
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3()
	{
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3)
	{
		this.addressLine3 = addressLine3;
	}

	

	@Override
	public String toString()
	{
		return "Address [id=" + id + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", addressLine3=" + addressLine3 + ", addressType=" + addressType + ", city=" + city + "]";
	}

	@Column(name="address1")
	private String addressLine1;
	
	@Column(name="address2")
	private String addressLine2;
	
	@Column(name="address3")
	private String addressLine3;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="address_type_ID")
	private AddressType addressType;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="city_ID")
	private City city;
	
}
