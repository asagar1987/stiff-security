package com.stiff.security.entity.base;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the overtimes database table.
 * 
 */
@Entity
@Table(name="overtimes")
@NamedQuery(name="Overtime.findAll", query="SELECT o FROM Overtime o")
public class Overtime implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=45)
	private String overtimedate;

	@Column(length=150)
	private String remarks;

	//bi-directional many-to-one association to Employee
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="employee_ID")
	private Employee employee;

	//bi-directional many-to-one association to VacantPost
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="vacant_post_ID", nullable=false)
	private VacantPost vacantPost;

	public Overtime() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOvertimedate() {
		return this.overtimedate;
	}

	public void setOvertimedate(String overtimedate) {
		this.overtimedate = overtimedate;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public VacantPost getVacantPost() {
		return this.vacantPost;
	}

	public void setVacantPost(VacantPost vacantPost) {
		this.vacantPost = vacantPost;
	}

}