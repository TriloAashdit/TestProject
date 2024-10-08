package com.aashdit.pallishree.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aashdit.framework.core.util.ViewDocuments;
import com.aashdit.pallishree.dto.EmployeeDTO;
import com.aashdit.pallishree.entity.Employee; 
import com.aashdit.pallishree.service.EmployeeService;


@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/addemployee")
	public String getEmployeePage() {
		return "site.employee.add";
	}

	@PostMapping("/addemployee") 
	public String addEmployeePage(RedirectAttributes attributes, EmployeeDTO employeeDTO) {
		try {
			employeeService.addEmployee(employeeDTO);
			attributes.addFlashAttribute("success_msg","Employee Added !!");

		} catch (Exception e) {
			attributes.addFlashAttribute("error_msg", "Something went wrong");
			System.out.println("Error Occured in Employee Controller"); 
		}
		
		 return  "redirect:/listemployee";
	}
	
	@GetMapping("/editemployee/{employeeId}")
	public String editEmployeePage(@PathVariable Long employeeId, Model model) {
		model.addAttribute("employeeDetails", employeeService.findById(employeeId)); 
		return "site.employee.edit"; 
	}
	
	@PostMapping("/editemployee")
	public String editEmployee(RedirectAttributes attributes, EmployeeDTO employeeDTO, @RequestParam("id") Long employeeId) {
	    //System.out.println(employeeDTO.getDob() + " : " + employeeId); 
		
		try {
			employeeService.updateEmployee(employeeDTO, employeeId);
			attributes.addFlashAttribute("success_msg","Employee Updated !!");

		} catch (Exception e) {
			attributes.addFlashAttribute("error_msg", "Something went wrong");
			System.out.println("Error Occured in Employee Controller"); 
		}
	    return "redirect:/listemployee";
	}
	
	@PostMapping("/deleteemployee/{employeeId}")
	public String deleteEmployee(RedirectAttributes attributes, @PathVariable Long employeeId) {
		
		
		try {
			employeeService.deleteEmployee(employeeId);
			attributes.addFlashAttribute("success_msg","Employee Deleted !!");

		} catch (Exception e) {
			attributes.addFlashAttribute("error_msg", "Something went wrong");
			System.out.println("Error Occured in Employee Controller"); 
		} 
	    return "redirect:/listemployee";
	}
	
	@GetMapping("/listemployee")
	public String listEmployee(Model model) {
		List<Employee>employees = employeeService.findAll(); 
		model.addAttribute("employees", employees); 
		return "site.employee.list";  
	}
	
	@PostMapping("/viewEmployeeResume")
	public void viewResume(@RequestParam("id")Long employeeId, HttpServletRequest request, HttpServletResponse response) {
		 try {
			 Employee employee = employeeService.findById(employeeId);
				ViewDocuments.viewUploadedDocument(employee.getResumeUpload(), request, response); 
		 }catch (Exception e) {
			System.out.println(e); 
		}
	 }
}
