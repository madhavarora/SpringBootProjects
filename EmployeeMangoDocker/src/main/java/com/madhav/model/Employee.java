package com.madhav.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="employees")
public class Employee {

	public Employee(String id, String email, String managerEmail, String fullname) {
		super();
		this.id = id;
		this.email = email;
		this.managerEmail = managerEmail;
		this.fullname = fullname;
	}
	
	@Id
	private String id;
	private String email;
	private String managerEmail;
	private String fullname;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getManagerEmail() {
		return managerEmail;
	}
	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
}
