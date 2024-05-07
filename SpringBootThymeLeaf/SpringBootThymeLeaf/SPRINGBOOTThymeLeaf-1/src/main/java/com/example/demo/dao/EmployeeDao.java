package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
	
	//List<Employee> findByEmpName(String name);
	//List<Employee> findByEmpSalBetween(float lower,float higher);
	
	@Query("from Employee where empName=:name")
	List<Employee> getUsingEmpName(@Param("name") String name);
	
	@Query("FROM Employee WHERE empName LIKE '%' || :keyword || '%'")
	List<Employee> findByKeyword(String keyword);


}
