package com.divya.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.divya.springboot.model.Employees;
@Repository
public interface EmployeeRepository extends JpaRepository<Employees,Long>
{

}
