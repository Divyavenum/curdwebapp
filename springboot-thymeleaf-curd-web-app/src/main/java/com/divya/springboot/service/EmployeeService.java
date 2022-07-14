package com.divya.springboot.service;

import java.util.List;

import com.divya.springboot.model.Employees;

public interface EmployeeService 
{
  public List<Employees> getAllEmployees();
  public void saveEmployee(Employees employees);
  public Employees getEmployeeById(long id);
  public void deleteEmployeeById(long id);
}
