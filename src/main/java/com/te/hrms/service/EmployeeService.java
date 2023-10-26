package com.te.hrms.service;

import java.util.List;

import com.te.hrms.dto.EmployeeDTO;
import com.te.hrms.entity.AppUser;

public interface EmployeeService {

	public AppUser register(EmployeeDTO employeeDTO) ;

	public EmployeeDTO getEmployee(String employeeId);

	public List<EmployeeDTO> getEmployees();

	public Boolean updateEmployee(String employeeId, EmployeeDTO employeeDTO);

	public Boolean deleteEmployee(String employeeId);
		
		
	

}
