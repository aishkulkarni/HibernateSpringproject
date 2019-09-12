package com.hbspring.repositoty;

import java.util.List;

import javax.transaction.Transaction;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hbspring.model.Employee;


@Repository
public class Employeerepo {
	@Autowired
	SessionFactory sf;
	
	@Transactional
	public  boolean saveEmployee(Employee emp) {
		
		Session ssn=sf.openSession();
		//Transaction tx=ssn.beginTransaction();
		
		ssn.save(emp);
		
		return false;
		
	}
	@Transactional
	public  Employee getEmployee(int empid)
	{
		
		Session ssn=sf.openSession();
		return ssn.get(Employee.class, empid);
	}
	@Transactional
	public List<Employee> getAllEmployee(){
		Session ssn=sf.openSession();
		Criteria ctr=ssn.createCriteria(Employee.class);
		return(ctr.list());
	}
	@Transactional
	public boolean deleteEmployee(Employee emp) {
		
		
		Session ssn=sf.openSession();
		ssn.beginTransaction();
		ssn.delete(emp);
		ssn.getTransaction().commit();
		
		
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
