package com.te.hrms.utils;

import org.springframework.stereotype.Component;

import com.te.hrms.dto.AppUserDTO;
import com.te.hrms.entity.AppUser;
@Component
public class AppUserUtils {
	public AppUser dtoToUser(AppUserDTO dto) {
		return AppUser.builder()
						.username(dto.getUsername())
						.password(dto.getPassword())
						.build();
	}
}
