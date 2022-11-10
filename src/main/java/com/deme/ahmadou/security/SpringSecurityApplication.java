package com.deme.ahmadou.security;

import com.deme.ahmadou.security.models.Role;
import com.deme.ahmadou.security.models.User;
import com.deme.ahmadou.security.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null,"Bamba DEME","bamba","1234",new ArrayList<>()));
			userService.saveUser(new User(null,"Sourakhatou DIENE","sourah","1234",new ArrayList<>()));
			userService.saveUser(new User(null,"Diana DIABONG","diana","1234",new ArrayList<>()));
			userService.saveUser(new User(null,"Mame Cheikh Seck","mamecheikh","1234",new ArrayList<>()));

			userService.addRoleToUser("bamba","ROLE_USER");
			userService.addRoleToUser("bamba","ROLE_ADMIN");
			userService.addRoleToUser("bamba","ROLE_SUPER_ADMIN");
			userService.addRoleToUser("mamecheikh","ROLE_ADMIN");
			userService.addRoleToUser("diana","ROLE_MANAGER");
			userService.addRoleToUser("sourah","ROLE_USER");


		};
	}
}
