package com.cybage.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cybage.entity.Role;
import com.cybage.entity.User;
import com.cybage.repo.UserRepository;
import com.cybage.web.UserRegistrationDto;
@Service
public class UserServiceImpl implements UserService{
@Autowired
private BCryptPasswordEncoder passwordEncoder;
private UserRepository userRepository;
	public UserServiceImpl(UserRepository userRepository) {
	super();
	this.userRepository = userRepository;
}
	public User addUser (User user) {
		User result =userRepository.save(user);
		return result;
	}
	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user =new User(registrationDto.getFirstName(),
				registrationDto.getLastName(),registrationDto.getEmail(),
				passwordEncoder.encode (registrationDto.getPassword()),Arrays.asList(new Role("ROLE_USER")));
				return  userRepository.save(user);
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user =userRepository.findByEmail(username);
		if (user==null)
			{
			throw new UsernameNotFoundException("invalid username and password");
			}
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPasword(),mapRolesToAuthorities(user.getRoles()));
	}
private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
	return roles.stream().map(role-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	
}
}
