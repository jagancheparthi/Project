package com.te.hrms.utils;

import org.springframework.stereotype.Component;

import com.te.hrms.dto.EmployeeDTO;
import com.te.hrms.entity.Employee;
@Component
public class EmployeeUtils {
	public Employee dtoToEmployee(EmployeeDTO employeeDTO) {
		return Employee.builder()
						.employeeId(employeeDTO.getEmployeeId())
						.firstName(employeeDTO.getFirstName())
						.lastName(employeeDTO.getLastName())
						.email(employeeDTO.getEmail())
						.contactNumber(employeeDTO.getContactNumber())
						.dateOfJoining(employeeDTO.getDateOfJoining())
						.department(employeeDTO.getDepartment())
						.designation(employeeDTO.getDesignation())
						.build();
	}
	public EmployeeDTO empToDto(Employee employee) {
		return EmployeeDTO.builder()
							.firstName(employee.getFirstName())
							.lastName(employee.getLastName())
							.contactNumber(employee.getContactNumber())
							.build();
	}
}
