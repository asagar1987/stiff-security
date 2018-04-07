package com.stiff.security.entity.base;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the event database table.
 * 
 */
@Entity
@Table(name="event")
@NamedQuery(name="Event.findAll", query="SELECT e FROM Event e")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	private int createdby;

	@Temporal(TemporalType.TIMESTAMP)
	private Date creationdate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date endtime;

	@Temporal(TemporalType.TIMESTAMP)
	private Date starttime;

	@Column(length=200)
	private String subject;

	//bi-directional many-to-one association to EventType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="event_type_ID", nullable=false, insertable=false, updatable=false)
	private EventType eventType;

	//bi-directional many-to-many association to Client
	@ManyToMany(cascade={CascadeType.REFRESH})
	@JoinColumn(name="ID", nullable=false, insertable=false, updatable=false)
	private List<Client> invitedClients;

	//bi-directional many-to-many association to Employee
	@ManyToMany(cascade={CascadeType.REFRESH})
	@JoinColumn(name="ID", nullable=false, insertable=false, updatable=false)
	private List<Employee> invitedEmployees;

	public Event() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCreatedby() {
		return this.createdby;
	}

	public void setCreatedby(int createdby) {
		this.createdby = createdby;
	}

	public Date getCreationdate() {
		return this.creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public Date getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public EventType getEventType() {
		return this.eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public List<Client> getInvitedClients() {
		return this.invitedClients;
	}

	public void setInvitedClients(List<Client> invitedClients) {
		this.invitedClients = invitedClients;
	}

	public List<Employee> getInvitedEmployees() {
		return this.invitedEmployees;
	}

	public void setInvitedEmployees(List<Employee> invitedEmployees) {
		this.invitedEmployees = invitedEmployees;
	}

}