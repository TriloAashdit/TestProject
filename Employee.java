package com.aashdit.pallishree.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "t_mst_employee", schema = "public")
public class Employee implements Serializable {
	

	private static final long serialVersionUID = -3848950578641379287L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	Long id; 
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
    private int age;
	
	@Column(name = "dob")
    private Date dob;
	
	@Column(name = "status")
    private String status;
	
	@Column(name = "joining_date")
    private Date joiningDate;
	
	@Column(name = "last_date")
    private Date lastDate;
	
	@Column(name = "tenure")
    private int tenure;
	
	@Column(name = "resume_path")
    private String resumeUpload;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public String getResumeUpload() {
		return resumeUpload;
	}

	public void setResumeUpload(String resumeUpload) {
		this.resumeUpload = resumeUpload;
	}
}
