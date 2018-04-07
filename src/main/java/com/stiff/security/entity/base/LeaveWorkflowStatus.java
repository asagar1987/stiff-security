package com.stiff.security.entity.base;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the leave_workflow_status database table.
 * 
 */
@Entity
@Table(name="leave_workflow_status")
@NamedQuery(name="LeaveWorkflowStatus.findAll", query="SELECT l FROM LeaveWorkflowStatus l")
public class LeaveWorkflowStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=20)
	private String color;

	@Column(length=200)
	private String description;

	@Column(nullable=false, length=45)
	private String status;

	//bi-directional many-to-one association to LeaveWorkflow
	@OneToMany(mappedBy="leaveWorkflowStatus1")
	private List<LeaveWorkflow> leaveWorkflows1;

	//bi-directional many-to-one association to LeaveWorkflow
	@OneToMany(mappedBy="leaveWorkflowStatus2")
	private List<LeaveWorkflow> leaveWorkflows2;

	public LeaveWorkflowStatus() {
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<LeaveWorkflow> getLeaveWorkflows1() {
		return this.leaveWorkflows1;
	}

	public void setLeaveWorkflows1(List<LeaveWorkflow> leaveWorkflows1) {
		this.leaveWorkflows1 = leaveWorkflows1;
	}

	public LeaveWorkflow addLeaveWorkflows1(LeaveWorkflow leaveWorkflows1) {
		getLeaveWorkflows1().add(leaveWorkflows1);
		leaveWorkflows1.setLeaveWorkflowStatus1(this);

		return leaveWorkflows1;
	}

	public LeaveWorkflow removeLeaveWorkflows1(LeaveWorkflow leaveWorkflows1) {
		getLeaveWorkflows1().remove(leaveWorkflows1);
		leaveWorkflows1.setLeaveWorkflowStatus1(null);

		return leaveWorkflows1;
	}

	public List<LeaveWorkflow> getLeaveWorkflows2() {
		return this.leaveWorkflows2;
	}

	public void setLeaveWorkflows2(List<LeaveWorkflow> leaveWorkflows2) {
		this.leaveWorkflows2 = leaveWorkflows2;
	}

	public LeaveWorkflow addLeaveWorkflows2(LeaveWorkflow leaveWorkflows2) {
		getLeaveWorkflows2().add(leaveWorkflows2);
		leaveWorkflows2.setLeaveWorkflowStatus2(this);

		return leaveWorkflows2;
	}

	public LeaveWorkflow removeLeaveWorkflows2(LeaveWorkflow leaveWorkflows2) {
		getLeaveWorkflows2().remove(leaveWorkflows2);
		leaveWorkflows2.setLeaveWorkflowStatus2(null);

		return leaveWorkflows2;
	}

}