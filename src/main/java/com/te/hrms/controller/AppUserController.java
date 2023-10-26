package com.te.hrms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.hrms.dto.AppUserDTO;
import com.te.hrms.dto.EmployeeDTO;
import com.te.hrms.entity.AppUser;
import com.te.hrms.response.SuccessResponse;
import com.te.hrms.security.JwtUtils;
import com.te.hrms.security.UserDetailsServiceImpl;
import com.te.hrms.service.EmployeeService;
import com.te.hrms.utils.AppUserUtils;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@RequestMapping(path = "/api/auth")
@RestController
public class AppUserController {
	private final EmployeeService employeeService;
	private final AuthenticationManager authenticationManager;
	private final JwtUtils jwtUtils;
	private final UserDetailsServiceImpl userDetailsServiceImpl;
	private final AppUserUtils appUserUtils;
	@PostMapping("/register")
	public ResponseEntity<SuccessResponse> register(@RequestBody EmployeeDTO employeeDTO) {
		AppUser appUser=employeeService.register(employeeDTO);
		return 
				new ResponseEntity<SuccessResponse>(SuccessResponse.builder().data(appUser).code(HttpStatus.ACCEPTED).build(), HttpStatus.ACCEPTED);
	}
	@PostMapping("/login")
	public void login(@RequestBody AppUserDTO appUserDTO) {
		AppUser user = appUserUtils.dtoToUser(appUserDTO);
		System.out.println(user);
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(appUserDTO.getUsername(),appUserDTO.getPassword());
		System.out.println(usernamePasswordAuthenticationToken);
		Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		System.out.println(authenticate+"=====================");
		UserDetails userDetail = userDetailsServiceImpl.loadUserByUsername(user.getUsername());
		jwtUtils.generateToken(userDetail.getUsername());
	}
}
