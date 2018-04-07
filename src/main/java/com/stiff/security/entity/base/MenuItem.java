package com.stiff.security.entity.base;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the menu_item database table.
 * 
 */
@Entity
@Table(name="menu_item")
@NamedQuery(name="MenuItem.findAll", query="SELECT m FROM MenuItem m")
public class MenuItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=45)
	private String displayname;

	private int displayorder;

	@Column(length=45)
	private String itemname;

	@Column(length=45)
	private String jsfunction;

	//bi-directional many-to-one association to Menu
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="menu_ID", nullable=false)
	private Menu menu;

	//bi-directional many-to-one association to PermissionType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="permission_type_ID", nullable=false)
	private PermissionType permissionType;

	public MenuItem() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDisplayname() {
		return this.displayname;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	public int getDisplayorder() {
		return this.displayorder;
	}

	public void setDisplayorder(int displayorder) {
		this.displayorder = displayorder;
	}

	public String getItemname() {
		return this.itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getJsfunction() {
		return this.jsfunction;
	}

	public void setJsfunction(String jsfunction) {
		this.jsfunction = jsfunction;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public PermissionType getPermissionType() {
		return this.permissionType;
	}

	public void setPermissionType(PermissionType permissionType) {
		this.permissionType = permissionType;
	}

}