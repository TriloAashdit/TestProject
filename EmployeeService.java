package com.aashdit.pallishree.service;

import java.util.List;

import com.aashdit.pallishree.dto.EmployeeDTO;
import com.aashdit.pallishree.entity.Employee;



public interface EmployeeService {

	void addEmployee(EmployeeDTO employeeDTO);
	
	List<Employee> findAll();

	Employee findById(Long employeeId);
	
	void updateEmployee(EmployeeDTO employeeDTO, Long employeeId);

	void deleteEmployee(Long employeeId); 
}
