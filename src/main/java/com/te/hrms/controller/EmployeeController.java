package com.te.hrms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.hrms.dto.EmployeeDTO;
import com.te.hrms.response.SuccessResponse;
import com.te.hrms.service.EmployeeService;

import lombok.RequiredArgsConstructor;
@RequestMapping(path = "/api")
@RequiredArgsConstructor
@RestController
public class EmployeeController {
	private final EmployeeService employeeService;
	@GetMapping(path = "/employees/{id}")
	public ResponseEntity<SuccessResponse> getEmployee(@PathVariable("id") String employeeId) {
		EmployeeDTO emp=employeeService.getEmployee(employeeId);
		return new ResponseEntity<SuccessResponse>(SuccessResponse.builder().data(emp).code(HttpStatus.FOUND).build(), HttpStatus.FOUND);
	}
	@GetMapping(path = "/employees")
	public ResponseEntity<SuccessResponse> getEmployees(){
		List<EmployeeDTO> employees=employeeService.getEmployees();
		 return new ResponseEntity<SuccessResponse>(SuccessResponse.builder().data(employees).code(HttpStatus.FOUND).build(), HttpStatus.FOUND);
	}
	@PutMapping(path = "/employees/{id}")
	public ResponseEntity<SuccessResponse> updateEmployee(@PathVariable("id") String employeeId,@RequestBody EmployeeDTO employeeDTO) {
		Boolean result=employeeService.updateEmployee(employeeId,employeeDTO);
		 return new ResponseEntity<SuccessResponse>(SuccessResponse.builder().message("UPDATED SUCCESSFULLY").data(result).code(HttpStatus.OK).build(), HttpStatus.OK);
	}
	@DeleteMapping(path = "/employees/{id}")
	public ResponseEntity<SuccessResponse> deleteEmployee(@PathVariable("id") String employeeId) {
		Boolean result=employeeService.deleteEmployee(employeeId);
		 return new ResponseEntity<SuccessResponse>(SuccessResponse.builder().message("DELETED SUCCESSFULLY").data(result).code(HttpStatus.NO_CONTENT).build(), HttpStatus.NO_CONTENT);
	}
}
