package com.stiff.security.entity.base;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@Table(name="role")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=60)
	private String rolename;

	//bi-directional many-to-one association to Designation
	@OneToMany(mappedBy="role")
	private List<Designation> designations;

	//bi-directional one-to-one association to Designation
	@OneToOne(mappedBy="defaultRole", fetch=FetchType.LAZY)
	private Designation designation;

	//bi-directional many-to-many association to Menu
	@ManyToMany
	@JoinTable(name="role_has_menu",
			joinColumns = {
					@JoinColumn(name = "role_ID", nullable = false, updatable = false) },
					inverseJoinColumns = { @JoinColumn(name = "menu_ID",
							nullable = false, updatable = false) })
	//@JoinColumn(name="ID", nullable=false, insertable=false, updatable=false)
	private List<Menu> menus;

	public Role() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public List<Designation> getDesignations() {
		return this.designations;
	}

	public void setDesignations(List<Designation> designations) {
		this.designations = designations;
	}

	public Designation addDesignation(Designation designation) {
		getDesignations().add(designation);
		designation.setRole(this);

		return designation;
	}

	public Designation removeDesignation(Designation designation) {
		getDesignations().remove(designation);
		designation.setRole(null);

		return designation;
	}

	public Designation getDesignation() {
		return this.designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public List<Menu> getMenus() {
		return this.menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

}