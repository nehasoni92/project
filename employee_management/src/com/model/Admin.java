package com.model;

public class Admin {
	
	private String rules;
	private String hod;
	 public Admin()
	 {
	 }
	public String getRules() {
		return rules;
	}
	public void setRules(String rules) {
		this.rules = rules;
	}
	public String getHod() {
		return hod;
	}
	public void setHod(String hod) {
		this.hod = hod;
	}
	@Override
	public String toString() {
		return "Admin [rules=" + rules + ", hod=" + hod + "]";
	}
	 
	 

}
