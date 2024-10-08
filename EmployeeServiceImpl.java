package com.aashdit.pallishree.service;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aashdit.framework.core.util.UploadFile;
import com.aashdit.pallishree.dto.EmployeeDTO;
import com.aashdit.pallishree.entity.Employee;
import com.aashdit.pallishree.repository.EmployeeRepository;
import com.ibm.icu.text.SimpleDateFormat;


@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository; 
	
	@Override
	public void addEmployee(EmployeeDTO employeeDTO) {
		
		Employee employee = new Employee(); 
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Random rand = new Random();
		try {
			Date dob = sdf.parse(employeeDTO.getDob());
			Date joiningDate = sdf.parse(employeeDTO.getJoiningDate());
			Date lastDate = sdf.parse(employeeDTO.getLastDate()); 
			employee.setName(employeeDTO.getName()); 
			employee.setAge(employeeDTO.getAge()); 
			employee.setDob(dob);
			employee.setStatus(employeeDTO.getStatus()); 
			employee.setJoiningDate(joiningDate);
			employee.setLastDate(lastDate); 
			employee.setTenure(employeeDTO.getTenure()); 
			if(!employeeDTO.getResumeUpload().isEmpty()) {
				String fpath = UploadFile.upload(employeeDTO.getResumeUpload(),  "File Attachment", rand.toString(), "employees_resume");
				employee.setResumeUpload(fpath);
			}
			employee = employeeRepository.save(employee);
		} catch(Exception e) {
			System.out.println(e); 
		}
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll(); 
	}

	@Override
	public Employee findById(Long employeeId) {
		Optional<Employee> employee =  employeeRepository.findById(employeeId);
		return employee.orElseThrow();
	}
	
	@Override
	public void updateEmployee(EmployeeDTO employeeDTO, Long employeeId) {
		
		
	    Employee employee = employeeRepository.findById(employeeId).orElseThrow();
	    
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    try {
	        Date dob = sdf.parse(employeeDTO.getDob());
	        Date joiningDate = sdf.parse(employeeDTO.getJoiningDate());
	        Date lastDate = sdf.parse(employeeDTO.getLastDate());
	        employee.setName(employeeDTO.getName());
	        employee.setAge(employeeDTO.getAge());
	        employee.setDob(dob);
	        employee.setStatus(employeeDTO.getStatus());
	        employee.setJoiningDate(joiningDate);
	        employee.setLastDate(lastDate);
	        employee.setTenure(employeeDTO.getTenure());

	        if (!employeeDTO.getResumeUpload().isEmpty()) {
	            Random rand = new Random();
	            String fpath = UploadFile.upload(employeeDTO.getResumeUpload(), "File Attachment", rand.toString(), "employees_resume");
	            employee.setResumeUpload(fpath);
	        }

	        employeeRepository.save(employee);
	    } catch (Exception e) {
	    	System.out.println(e.getMessage()); 
	    }
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		 employeeRepository.deleteById(employeeId);
	}

}
