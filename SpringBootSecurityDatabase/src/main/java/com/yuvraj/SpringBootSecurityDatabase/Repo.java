package com.yuvraj.SpringBootSecurityDatabase;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface Repo extends JpaRepository<MyUser, Integer>{
	Optional<MyUser>  findByName(String name);
}
