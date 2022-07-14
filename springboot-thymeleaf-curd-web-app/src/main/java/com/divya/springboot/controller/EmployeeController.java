package com.divya.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.divya.springboot.model.Employees;
import com.divya.springboot.service.EmployeeService;


@Controller
public class EmployeeController 
{
	//display list of employees
	@Autowired
	private EmployeeService employeeService;
	@GetMapping("/")
	public  String viewHomePage(Model model)
	{
		model.addAttribute("listEmployees",employeeService.getAllEmployees());
		return "index";
		
	}
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model)
	{
		Employees employees=new Employees();
		model.addAttribute("employees", employees);
		return "new_employee";
	}
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employees") Employees employees)
	{
		//save employee to database
		employeeService.saveEmployee(employees);
		return "redirect:/";
		
	}
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value="id") long id,Model model)
	{
		//getting employee from the service
		Employees employees=employeeService.getEmployeeById(id);
		
		//set employee as a model attribute to pre-populate the form
		model.addAttribute("employees",employees);
		return "update_employee";
		
	}
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable (value="id") long id)
	{
		//call delete employee method
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/";
		
	}
	
}
