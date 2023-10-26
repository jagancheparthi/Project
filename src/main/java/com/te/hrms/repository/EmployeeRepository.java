package com.te.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.hrms.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String>{

}
