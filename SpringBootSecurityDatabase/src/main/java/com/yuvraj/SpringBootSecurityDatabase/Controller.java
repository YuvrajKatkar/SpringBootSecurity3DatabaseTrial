package com.yuvraj.SpringBootSecurityDatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@Autowired
	private Repo repo;
//	@Autowired
//	private PasswordEncoder encoder;
	
	@GetMapping("/openForAll")
	public String getMethodName() {
		return "OPEN For ALL";
	}
	@GetMapping("/user/userAPI")
	public String getMethodName1() {
		return "USER API";
	}
	@GetMapping("/admin/adminAPI")
	public String getMethodName2() {
		return "ADMIN API";
	}
	@PostMapping("/save/user")
	public MyUser saveMyUser(@RequestBody MyUser myUser) {
//		myUser.setPassword(encoder.encode(myUser.getPassword()));
		return repo.save(myUser);
	}
	
}
