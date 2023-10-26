package com.te.hrms.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@ToString
public class EmployeeDTO {
	
	private String employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String contactNumber;
	private LocalDate dateOfJoining;
	private String department;
	private String designation;
	
	private List<SkillDTO> skills;
	
	private List<RoleDTO> roles;
}
