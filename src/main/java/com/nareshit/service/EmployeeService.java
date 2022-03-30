package com.nareshit.service;

import java.util.List;

import com.nareshit.dto.EmployeeDto;

public interface EmployeeService {

	public void saveEmployee(EmployeeDto employeeDto);

	public void editEmployee(EmployeeDto employeeDto);

	public void removeEmployee(Long eid);

	public List<EmployeeDto> findEmplyoeeById(Long eid);

	public List<EmployeeDto> findAllEmployees();
}
