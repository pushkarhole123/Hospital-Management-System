package com.model;

public class Hospital {

	private String drName;
	private String dept;
	private double salary;

	
	public Hospital() {
		// TODO Auto-generated constructor stub
	}
	
	public Hospital(String drName, String dept, double salary) {
		this.drName=drName;
		this.dept=dept;
		this.salary=salary;
	}

	public String getDrName() {
		return drName;
	}

	public void setDrName(String drName) {
		this.drName = drName;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Hospital [drName=" + drName + ", dept=" + dept + ", salary=" + salary + "]";
	}

	
}
