package com.hbspring.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hbspring.model.Employee;
import com.hbspring.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	@PostMapping("/add")
	public String addEmployee( @ModelAttribute Employee emp,Model m) {
		String  msg="success..";
		if(service.saveEmployee(emp))
			msg="failed..";
		m.addAttribute("msg",msg);
		//	return "success.jsp";
		return "view.jsp";
		
	}
	
	@GetMapping("/employee")
	public String getEmployee(@RequestParam("empid") int empid,Model m) {
		
		
		Employee emp=service.getEmployee(empid);
		m.addAttribute("emp",emp);
		return "viewemp.jsp";
		
	}
	@GetMapping("/employees")
	public String  getAllEmployees(Model m) {
		List<Employee> empList=service.getAllEmployees();
		m.addAttribute("empList",empList);
		return "viewall.jsp";
		}
	@PostMapping("/delete")
	public String deleteEmp(@RequestParam("empid") int empid,Model m)
	{
		String msg="Failed..";
		Employee emp= service.getEmployee(empid);
		if(service.deleteEmployee(emp))
			msg="successful";
		m.addAttribute("msg",msg);
		return "view.jsp";
		
		
	}
	

}
