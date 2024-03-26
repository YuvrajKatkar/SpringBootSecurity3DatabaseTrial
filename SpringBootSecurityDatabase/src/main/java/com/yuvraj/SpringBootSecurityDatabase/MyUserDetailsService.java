package com.yuvraj.SpringBootSecurityDatabase;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private Repo repo;
	@Autowired
	private PasswordEncoder encoder;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<MyUser> user = repo.findByName(username);
		if(user.isPresent()) {
			UserDetails userDetails = User.builder()
			.username(user.get().getName())
			.password(encoder.encode(user.get().getPassword()))
			.roles(getRoles(user.get().getRole()))
			.build();
			return userDetails;
		}else {
			throw new UsernameNotFoundException(username);
		}
	}
	public String[] getRoles(String roles) {
		String[] list=roles.split(",");
		if(roles==null) return new String[] {"USER"};
		if(list.length>1) {
			return list;
		}else {
			return new String[] {roles};
		}
	}

}
