package com.stiff.security.entity.base;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the conduct_type database table.
 * 
 */
@Entity
@Table(name="conduct_type")
@NamedQuery(name="ConductType.findAll", query="SELECT c FROM ConductType c")
public class ConductType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=20)
	private String color;

	@Column(length=45)
	private String description;

	@Column(nullable=false, length=45)
	private String name;

	//bi-directional many-to-one association to Conduct
	@OneToMany(mappedBy="conductType")
	private List<Conduct> conducts;

	public ConductType() {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Conduct> getConducts() {
		return this.conducts;
	}

	public void setConducts(List<Conduct> conducts) {
		this.conducts = conducts;
	}

	public Conduct addConduct(Conduct conduct) {
		getConducts().add(conduct);
		conduct.setConductType(this);

		return conduct;
	}

	public Conduct removeConduct(Conduct conduct) {
		getConducts().remove(conduct);
		conduct.setConductType(null);

		return conduct;
	}

}