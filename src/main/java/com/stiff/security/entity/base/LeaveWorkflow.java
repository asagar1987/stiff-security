package com.stiff.security.entity.base;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the leave_workflow database table.
 * 
 */
@Entity
@Table(name="leave_workflow")
@NamedQuery(name="LeaveWorkflow.findAll", query="SELECT l FROM LeaveWorkflow l")
public class LeaveWorkflow implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date actiondate;

	@Column(length=150)
	private String remarks;

	//bi-directional many-to-one association to Employee
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="actionuser", nullable=false)
	private Employee employee;

	//bi-directional many-to-one association to LeaveApplication
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="leave_application_ID", nullable=false)
	private LeaveApplication leaveApplication;

	//bi-directional many-to-one association to LeaveWorkflowStatus
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fromstatus", nullable=false)
	private LeaveWorkflowStatus leaveWorkflowStatus1;

	//bi-directional many-to-one association to LeaveWorkflowStatus
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tostatus", nullable=false)
	private LeaveWorkflowStatus leaveWorkflowStatus2;

	public LeaveWorkflow() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getActiondate() {
		return this.actiondate;
	}

	public void setActiondate(Date actiondate) {
		this.actiondate = actiondate;
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

	public LeaveApplication getLeaveApplication() {
		return this.leaveApplication;
	}

	public void setLeaveApplication(LeaveApplication leaveApplication) {
		this.leaveApplication = leaveApplication;
	}

	public LeaveWorkflowStatus getLeaveWorkflowStatus1() {
		return this.leaveWorkflowStatus1;
	}

	public void setLeaveWorkflowStatus1(LeaveWorkflowStatus leaveWorkflowStatus1) {
		this.leaveWorkflowStatus1 = leaveWorkflowStatus1;
	}

	public LeaveWorkflowStatus getLeaveWorkflowStatus2() {
		return this.leaveWorkflowStatus2;
	}

	public void setLeaveWorkflowStatus2(LeaveWorkflowStatus leaveWorkflowStatus2) {
		this.leaveWorkflowStatus2 = leaveWorkflowStatus2;
	}

}