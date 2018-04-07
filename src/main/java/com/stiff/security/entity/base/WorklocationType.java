package com.stiff.security.entity.base;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the worklocation_type database table.
 * 
 */
@Entity
@Table(name="worklocation_type")
@NamedQuery(name="WorklocationType.findAll", query="SELECT w FROM WorklocationType w")
public class WorklocationType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=20)
	private String color;

	@Column(length=100)
	private String description;

	@Column(nullable=false, length=45)
	private String type;

	//bi-directional many-to-one association to Worklocation
	@OneToMany(mappedBy="worklocationType")
	private List<Worklocation> worklocations;

	public WorklocationType() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Worklocation> getWorklocations() {
		return this.worklocations;
	}

	public void setWorklocations(List<Worklocation> worklocations) {
		this.worklocations = worklocations;
	}

	public Worklocation addWorklocation(Worklocation worklocation) {
		getWorklocations().add(worklocation);
		worklocation.setWorklocationType(this);

		return worklocation;
	}

	public Worklocation removeWorklocation(Worklocation worklocation) {
		getWorklocations().remove(worklocation);
		worklocation.setWorklocationType(null);

		return worklocation;
	}

}