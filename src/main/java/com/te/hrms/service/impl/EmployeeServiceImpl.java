package com.te.hrms.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.te.hrms.dto.EmployeeDTO;
import com.te.hrms.entity.AppUser;
import com.te.hrms.entity.Employee;
import com.te.hrms.entity.Role;
import com.te.hrms.entity.Skill;
import com.te.hrms.repository.AppUserRepository;
import com.te.hrms.repository.EmployeeRepository;
import com.te.hrms.service.EmployeeService;
import com.te.hrms.utils.EmployeeUtils;
import com.te.hrms.utils.RoleUtils;
import com.te.hrms.utils.SkillUtils;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService{
	private final EmployeeRepository employeeRepository;
	private final AppUserRepository appUserRepository;
	private final EmployeeUtils employeeUtils;
	private final RoleUtils roleUtils;
	private final SkillUtils skillUtils;
	private final PasswordEncoder passwordEncoder;
	@Override
	public AppUser register(EmployeeDTO employeeDTO) {
		
		Employee employee = employeeUtils.dtoToEmployee(employeeDTO);

		List<Skill> skills = employeeDTO.getSkills().stream().map(skil->skillUtils.dtoToSkill(skil)).collect(Collectors.toList());
		AppUser appUser=new AppUser();
		appUser.setUsername(employeeDTO.getEmployeeId());
		appUser.setPassword(passwordEncoder.encode(UUID.randomUUID().toString()));
		List<Role> roles = employeeDTO.getRoles().stream().map(rol->roleUtils.dtoToRole(rol)).collect(Collectors.toList());
		appUser.setRoles(roles);
		employee.setRoles(roles);
		employee.setSkills(skills);
		employeeRepository.save(employee);
		return appUserRepository.save(appUser);
	}
	@Override
	public EmployeeDTO getEmployee(String employeeId) {
		Employee emp = employeeRepository.findById(employeeId).orElseThrow(()->new UsernameNotFoundException("Employee Not Found"));
		return employeeUtils.empToDto(emp);
	}
	@Override
	public List<EmployeeDTO> getEmployees() {
		List<Employee> emps = employeeRepository.findAll();
		return emps.stream().map(emp->employeeUtils.empToDto(emp)).collect(Collectors.toList());
	}
	@Override
	public Boolean updateEmployee(String employeeId, EmployeeDTO employeeDTO) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->new UsernameNotFoundException("Employee Not Found"));
		employee.setFirstName(employeeDTO.getFirstName());
		employee.setLastName(employeeDTO.getLastName());
		employee.setContactNumber(employeeDTO.getContactNumber());
		employee.setDateOfJoining(employeeDTO.getDateOfJoining());
		employee.setDepartment(employeeDTO.getDepartment());
		employeeRepository.save(employee);
		return true;
	}
	@Override
	public Boolean deleteEmployee(String employeeId) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->new UsernameNotFoundException("Employee Not Found"));
		employeeRepository.delete(employee);
		return true;
	}

}
