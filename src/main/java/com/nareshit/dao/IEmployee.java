package com.nareshit.dao;

import java.util.List;

import com.nareshit.model.Employee;

public interface IEmployee {
   
	public void addEmployee(Employee employee);

	public void updateEmployee(Employee employee);

	public void deleteEmployee(Long eid);

	public List<Employee> getEmplyoeeById(Long eid);

	public List<Employee> getAllEmployees();
}
