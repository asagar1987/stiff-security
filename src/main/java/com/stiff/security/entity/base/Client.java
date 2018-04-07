package com.stiff.security.entity.base;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the clients database table.
 * 
 */
@Entity
@Table(name="clients")
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=90)
	private String name;

	//bi-directional many-to-one association to Conduct
	@OneToMany(mappedBy="client")
	private List<Conduct> conducts;

	//bi-directional many-to-many association to Address
	@ManyToMany
	@JoinColumn(name="ID", nullable=false, insertable=false, updatable=false)
	private List<Address> addresses;

	//bi-directional many-to-many association to Event
	@ManyToMany(mappedBy="invitedClients")
	private List<Event> events;

	public Client() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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
		conduct.setClient(this);

		return conduct;
	}

	public Conduct removeConduct(Conduct conduct) {
		getConducts().remove(conduct);
		conduct.setClient(null);

		return conduct;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

}