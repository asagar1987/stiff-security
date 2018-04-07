/**
 * 
 */
package com.stiff.security.entity.base;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author asaga3
 *
 */
@Entity
@Table(name="address_type")
public class AddressType implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3698875745183471871L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private int id;
	
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getAddressTypeName()
	{
		return addressTypeName;
	}

	public void setAddressTypeName(String addressTypeName)
	{
		this.addressTypeName = addressTypeName;
	}

	@Column(nullable = false, length = 45, name="addresstype")
	private String addressTypeName;

	@Override
	public String toString()
	{
		return "AddressType [id=" + id + ", addressTypeName=" + addressTypeName + "]";
	}
	
	

}
