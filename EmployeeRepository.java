package com.aashdit.pallishree.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aashdit.pallishree.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}
