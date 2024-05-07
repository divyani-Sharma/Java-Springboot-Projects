package com.example.demo.bean;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Employee {
	
	@Id
	private int empId;
	@NotBlank(message = "Name is required")
	private String empName;
	@NotBlank(message = "Employee Mail is required")
	private String mail;
	
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	public Employee(int empId, String empName, String mail) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.mail = mail;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", mail=" + mail + "]";
	}
	
	

}
