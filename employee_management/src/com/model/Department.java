package com.model;

public class Department {
	
	
	private int dept_id;
	private String dept;
	 public Department()
	 {	 
		 
		 
	 }	 
	
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Department [dept_id=" + dept_id + ", dept=" + dept + "]";
	}
	 
	 

}
