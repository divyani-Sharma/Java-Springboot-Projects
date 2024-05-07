package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.bean.Employee;
import com.example.demo.service.IEmployeeService;

import com.example.demo.validate.EmployeeValidator;



@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	IEmployeeService ser;
	
	@Autowired
    private EmployeeValidator employeeValidator;
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(employeeValidator);
    }
	
	
	@GetMapping("/menu")
	public String getAllEmployee(Model model)
	{
		model.addAttribute("empList", ser.getAllEmployee());
		
		return "ShowAll";
		
	}
	
	@GetMapping("/showAddEmployeeForm")
	public String showAddForm(Model model)
	{
		Employee emp=new Employee();
		model.addAttribute("emp", emp);
		return "AddForm";
	}
	
	@PostMapping("/addEmp")
	public String addEmployee(@ModelAttribute Employee emp)
	{
		ser.addEmployee(emp);
		return "redirect:/menu";
	}
	
	@GetMapping("/showUpdateEmployeeForm/{empId}")
	public String showUpdateForm(@PathVariable(value = "empId") int empId,  Model model)
	{
		if (ser.getEmployee(empId) == null ) {
            throw new RuntimeException("Employee not found with id: " + empId);
        }
		
		Employee emp=ser.getEmployee(empId);
		model.addAttribute("emp", emp);
		return "UpdateForm";
	
	}
	
	@GetMapping("/showDeleteEmployeeForm/{empId}")
	public String showDeleteForm(@PathVariable(value = "empId") int empId)
	{
		if (ser.getEmployee(empId) == null ) {
            throw new RuntimeException("Employee not found with id: " + empId);
        }
		ser.deleteEmployee(empId);
		return "redirect:/menu";
	}
	
	@GetMapping("/search")
    public String searchEmployees(@RequestParam(required = false) String keyword, Model model) {
        List<Employee> employees = ser.findByKeyword(keyword);
        model.addAttribute("employees", employees);
        return "SearchForm";
    }
	
}
