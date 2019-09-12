package com.hbspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbspring.model.Employee;
import com.hbspring.repositoty.Employeerepo;

@Service
public class EmployeeService {
	
	@Autowired
	Employeerepo repo;
	
	public boolean saveEmployee(Employee emp) 
	{
		return repo.saveEmployee(emp);
	}
	
	public Employee getEmployee(int empid)
	{
		return repo.getEmployee(empid);
		
	}
	public boolean  deleteEmployee(Employee emp) 
	{
		return repo.deleteEmployee(emp);
		
	}
	public List<Employee> getAllEmployees()
	{
		return repo.getAllEmployee();
	}

}
