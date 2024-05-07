package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Employee;
import com.example.demo.dao.EmployeeDao;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	EmployeeDao dao;
	
	@Override
	public List<Employee> getAllEmployee()
	{
		return dao.findAll();
	}
	@Override
	public List<Employee> getEmployeeByName(String name)
	{
		
		return dao.getUsingEmpName(name);
		
	}
	
	@Override
	public Employee getEmployee(int empID)
	{
		
		return dao.getById(empID);
		
	}
	
	@Override
	public Employee addEmployee(Employee emp)
	{
		return dao.save(emp);
	}
	
	@Override
	public Employee updateEmployee(int empID,Employee emp)
	{
		return dao.save(emp);
	}
	
	@Override
	public void deleteEmployee(int empID)
	{
		dao.deleteById(empID);
	}
	
	
	@Override
	public List<Employee> findByKeyword(String keyword) {
		List<Employee> employees;
        if (keyword == null || keyword.isEmpty()) {
            employees = dao.findAll();
        } else {
            employees = dao.findByKeyword(keyword);
        }
        sortEmployeesByName(employees);
        return employees;
	}
	
	private void sortEmployeesByName(List<Employee> employees) {
        Collections.sort(employees,(e1,e2) -> e1.getEmpName().compareTo(e2.getEmpName()));
    }
	
	

}
