package com.example.demo.service;

import java.util.List;

import com.example.demo.bean.Employee;

public interface IEmployeeService {

	List<Employee> getAllEmployee();

	Employee getEmployee(int empID);

	Employee addEmployee(Employee emp);

	Employee updateEmployee(int empID, Employee emp);

	void deleteEmployee(int empID);

	List<Employee> getEmployeeByName(String name);

	List<Employee> findByKeyword(String keyword);

}