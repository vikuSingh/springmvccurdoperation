package com.nareshit.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nareshit.dao.IEmployee;
import com.nareshit.dto.EmployeeDto;
import com.nareshit.model.Employee;
import com.nareshit.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private IEmployee iEmployee;

	@Override
	public void saveEmployee(EmployeeDto employeeDto) {
		Employee employee = new Employee();
		employee.setEname(employeeDto.getEname());
		employee.setMobileNum(employeeDto.getMobileNum());
		employee.setSal(employeeDto.getSal());
		iEmployee.addEmployee(employee);

	}

	@Override
	public void editEmployee(EmployeeDto employeeDto) {
		Employee employee = new Employee();
		employee.setEid(employeeDto.getEid());
		employee.setEname(employeeDto.getEname());
		employee.setMobileNum(employeeDto.getMobileNum());
		employee.setSal(employeeDto.getSal());
		iEmployee.updateEmployee(employee);

	}

	@Override
	public void removeEmployee(Long eid) {
		iEmployee.deleteEmployee(eid);
	}

	@Override
	public List<EmployeeDto> findEmplyoeeById(Long eid) {
		List<EmployeeDto> listEmployeeDtos = new ArrayList<EmployeeDto>();
		List<Employee> listEmployees = iEmployee.getEmplyoeeById(eid);
		listEmployees.forEach(employee -> {
			EmployeeDto employeeDto = new EmployeeDto();
			employeeDto.setEid(employee.getEid());
			employeeDto.setEname(employee.getEname());
			employeeDto.setMobileNum(employee.getMobileNum());
			employeeDto.setSal(employee.getSal());
			listEmployeeDtos.add(employeeDto);
		});
		return listEmployeeDtos;
	}

	@Override
	public List<EmployeeDto> findAllEmployees() {
		List<EmployeeDto> listEmployeeDtos = new ArrayList<EmployeeDto>();
		List<Employee> listEmployees = iEmployee.getAllEmployees();
		listEmployees.forEach(employee -> {
			EmployeeDto employeeDto = new EmployeeDto();
			employeeDto.setEid(employee.getEid());
			employeeDto.setEname(employee.getEname());
			employeeDto.setMobileNum(employee.getMobileNum());
			employeeDto.setSal(employee.getSal());
			listEmployeeDtos.add(employeeDto);
		});

		return listEmployeeDtos;
	}

}
