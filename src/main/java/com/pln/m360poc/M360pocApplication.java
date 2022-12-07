package com.pln.m360poc;

import com.pln.m360poc.entity.Role;
import com.pln.m360poc.entity.User;
import com.pln.m360poc.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class M360pocApplication {

	public static void main(String[] args) {
		SpringApplication.run(M360pocApplication.class, args);
	}
	@Bean
	public CommandLineRunner setupDefaultUser(UserService service) {
		return args -> {
			service.save(new User(
					"pkm", //username
					"pkm", //password
					Arrays.asList(new Role("USER"), new Role("ACTUATOR")),//roles
					true//Active
			));
		};
	}

	@Bean
	public PasswordEncoder getPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}
}
