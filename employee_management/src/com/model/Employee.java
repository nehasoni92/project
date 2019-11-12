package com.model;

public class Employee {
	
	private int dept_id;
	private String name;
	private String email;
	private String mobile;
	private String designation;
	 public Employee()
	 {
		 
	 }
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "Emplolyee [dept_id=" + dept_id + ", name=" + name + ", email=" + email + ", mobile=" + mobile
				+ ", designation=" + designation + "]";
	}
	 
	 

}
