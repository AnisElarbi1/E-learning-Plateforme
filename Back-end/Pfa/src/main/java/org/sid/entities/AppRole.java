package org.sid.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AppRole {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String roleName;
	
	
	public AppRole() {
		super();
	}
	public AppRole(int id, String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}

