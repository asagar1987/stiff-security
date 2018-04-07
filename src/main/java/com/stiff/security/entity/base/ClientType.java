package com.stiff.security.entity.base;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the client_type database table.
 * 
 */
@Entity
@Table(name="client_type")
@NamedQuery(name="ClientType.findAll", query="SELECT c FROM ClientType c")
public class ClientType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=90)
	private String clienttype;

	@Column(length=20)
	private String color;

	@Column(length=200)
	private String description;

	public ClientType() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClienttype() {
		return this.clienttype;
	}

	public void setClienttype(String clienttype) {
		this.clienttype = clienttype;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}