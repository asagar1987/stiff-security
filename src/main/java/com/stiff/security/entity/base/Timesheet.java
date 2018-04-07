package com.stiff.security.entity.base;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the timesheet database table.
 * 
 */
@Entity
@Table(name="timesheet")
@NamedQuery(name="Timesheet.findAll", query="SELECT t FROM Timesheet t")
public class Timesheet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date date;

	@Column(nullable=false)
	private int loggedhours;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date submissiondate;

	//bi-directional many-to-one association to TimesheetStatus
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="timesheet_status_ID", nullable=false)
	private TimesheetStatus timesheetStatus;

	//bi-directional many-to-one association to Workshift
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="workshift_ID", nullable=false, insertable=false, updatable=false)
	private Workshift workshift;

	//bi-directional many-to-many association to Employee
	@ManyToMany(mappedBy="timesheets")
	private List<Employee> employees;

	public Timesheet() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getLoggedhours() {
		return this.loggedhours;
	}

	public void setLoggedhours(int loggedhours) {
		this.loggedhours = loggedhours;
	}

	public Date getSubmissiondate() {
		return this.submissiondate;
	}

	public void setSubmissiondate(Date submissiondate) {
		this.submissiondate = submissiondate;
	}

	public TimesheetStatus getTimesheetStatus() {
		return this.timesheetStatus;
	}

	public void setTimesheetStatus(TimesheetStatus timesheetStatus) {
		this.timesheetStatus = timesheetStatus;
	}

	public Workshift getWorkshift() {
		return this.workshift;
	}

	public void setWorkshift(Workshift workshift) {
		this.workshift = workshift;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}