package com.te.hrms.utils;

import org.springframework.stereotype.Component;

import com.te.hrms.dto.RoleDTO;
import com.te.hrms.entity.Role;
@Component
public class RoleUtils {
	public Role dtoToRole(RoleDTO dto) {
		return Role.builder().role(dto.getRole()).build();
	}
}
