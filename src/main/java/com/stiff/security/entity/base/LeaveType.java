package com.stiff.security.entity.base;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the leave_type database table.
 * 
 */
@Entity
@Table(name="leave_type")
@NamedQuery(name="LeaveType.findAll", query="SELECT l FROM LeaveType l")
public class LeaveType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=20)
	private String color;

	@Column(length=200)
	private String description;

	public LeaveType() {
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
	
	
}