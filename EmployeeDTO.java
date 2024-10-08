package com.aashdit.pallishree.dto;

import org.springframework.web.multipart.MultipartFile;

public class EmployeeDTO {
	
	private String name;
    private int age;
    private String dob;
    private String status;
    private String joiningDate;
    private String lastDate;
    private int tenure; 
    private MultipartFile resumeUpload;

    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}
	public String getLastDate() {
		return lastDate;
	}
	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public MultipartFile getResumeUpload() {
		return resumeUpload;
	}
	public void setResumeUpload(MultipartFile resumeUpload) {
		this.resumeUpload = resumeUpload;
	}
}
