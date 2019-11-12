package com.model;

public class HOD {
	
	private String message;
	private String dept;
	 public HOD()
	 {
		 
	 }
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		dept = dept;
	}
	@Override
	public String toString() {
		return "HOD [message=" + message + ", Dept=" + dept + "]";
	}
	 
	 

}
