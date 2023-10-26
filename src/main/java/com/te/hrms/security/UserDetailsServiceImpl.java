package com.te.hrms.security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.te.hrms.entity.AppUser;
import com.te.hrms.repository.AppUserRepository;

import lombok.RequiredArgsConstructor;
@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{
	private final AppUserRepository appUserRepository;
	@Override
	public UserDetails loadUserByUsername(String username)  {
		AppUser user = appUserRepository.findById(username).orElseThrow(()->new UsernameNotFoundException("user not found"));
		System.out.println(user);
//		User user2 = new User(username, user.getPassword(), user.getRoles().stream().map(r->new SimpleGrantedAuthority(r.getRole())).collect(Collectors.toList()));
		User user2 = new User(username, user.getPassword(), List.of());

		return user2;
	}

}
