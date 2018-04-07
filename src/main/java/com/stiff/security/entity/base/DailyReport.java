package com.stiff.security.entity.base;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the daily_report database table.
 * 
 */
@Entity
@Table(name="daily_report")
@NamedQuery(name="DailyReport.findAll", query="SELECT d FROM DailyReport d")
public class DailyReport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date reportdate;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date submissiondate;

	//bi-directional many-to-one association to Employee
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="employee_ID", nullable=false)
	private Employee employee;

	//bi-directional many-to-many association to VacantPost
	@ManyToMany
	@JoinColumn(name="ID", nullable=false, insertable=false, updatable=false)
	private List<VacantPost> vacantPosts;

	public DailyReport() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getReportdate() {
		return this.reportdate;
	}

	public void setReportdate(Date reportdate) {
		this.reportdate = reportdate;
	}

	public Date getSubmissiondate() {
		return this.submissiondate;
	}

	public void setSubmissiondate(Date submissiondate) {
		this.submissiondate = submissiondate;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<VacantPost> getVacantPosts() {
		return this.vacantPosts;
	}

	public void setVacantPosts(List<VacantPost> vacantPosts) {
		this.vacantPosts = vacantPosts;
	}

}