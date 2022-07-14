package com.divya.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divya.springboot.model.Employees;
import com.divya.springboot.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public List<Employees> getAllEmployees() {
		List<Employees> list=employeeRepository.findAll();//predefined method to get employee from DB
		return list;
	}
	@Override
	public void saveEmployee(Employees employees) {
		this.employeeRepository.save(employees);//it saves object data in DB

		
	}

    	@Override
	    public Employees getEmployeeById(long id) {
		Optional<Employees> optional=employeeRepository.findById(id);
		Employees employees=null;
		if(optional.isPresent())
		{
			employees=optional.get();
		}
		else
		{
			throw new RuntimeException("Employee not found for id :: " + id);
		}
		return employees;
	}
	@Override
	public void deleteEmployeeById(long id) {
		this.employeeRepository.deleteById(id);
		
	}

}
