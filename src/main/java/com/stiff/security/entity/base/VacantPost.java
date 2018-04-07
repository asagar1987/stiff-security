package com.stiff.security.entity.base;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the vacant_post database table.
 * 
 */
@Entity
@Table(name="vacant_post")
@NamedQuery(name="VacantPost.findAll", query="SELECT v FROM VacantPost v")
public class VacantPost implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date vacantdate;

	//bi-directional many-to-one association to Overtime
	@OneToMany(mappedBy="vacantPost")
	private List<Overtime> overtimes;

	//bi-directional many-to-one association to LeaveApplication
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="leave_application_ID", nullable=false)
	private LeaveApplication leaveApplication;

	//bi-directional many-to-one association to Worklocation
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="worklocation_ID", nullable=false)
	private Worklocation worklocation;

	//bi-directional many-to-one association to Workshift
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="workshift_ID", nullable=false)
	private Workshift workshift;

	//bi-directional many-to-many association to DailyReport
	@ManyToMany(mappedBy="vacantPosts")
	private List<DailyReport> dailyReports;

	public VacantPost() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getVacantdate() {
		return this.vacantdate;
	}

	public void setVacantdate(Date vacantdate) {
		this.vacantdate = vacantdate;
	}

	public List<Overtime> getOvertimes() {
		return this.overtimes;
	}

	public void setOvertimes(List<Overtime> overtimes) {
		this.overtimes = overtimes;
	}

	public Overtime addOvertime(Overtime overtime) {
		getOvertimes().add(overtime);
		overtime.setVacantPost(this);

		return overtime;
	}

	public Overtime removeOvertime(Overtime overtime) {
		getOvertimes().remove(overtime);
		overtime.setVacantPost(null);

		return overtime;
	}

	public LeaveApplication getLeaveApplication() {
		return this.leaveApplication;
	}

	public void setLeaveApplication(LeaveApplication leaveApplication) {
		this.leaveApplication = leaveApplication;
	}

	public Worklocation getWorklocation() {
		return this.worklocation;
	}

	public void setWorklocation(Worklocation worklocation) {
		this.worklocation = worklocation;
	}

	public Workshift getWorkshift() {
		return this.workshift;
	}

	public void setWorkshift(Workshift workshift) {
		this.workshift = workshift;
	}

	public List<DailyReport> getDailyReports() {
		return this.dailyReports;
	}

	public void setDailyReports(List<DailyReport> dailyReports) {
		this.dailyReports = dailyReports;
	}

}