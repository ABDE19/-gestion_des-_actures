package com.example;

import com.example.configsecurity.servicesecurity.AccontService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@SpringBootApplication
public class Demo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
	@Bean
	CommandLineRunner commandLineRunner(JdbcUserDetailsManager jdbcUserDetailsManager){
		PasswordEncoder passwordEncoder=passwordEncoder();

		return args -> {
			UserDetails userDetails=jdbcUserDetailsManager.loadUserByUsername("ahmd");
			if (userDetails==null)
			jdbcUserDetailsManager.createUser(
					User.withUsername("ahmd").password(passwordEncoder.encode("1234")).authorities("user").build()

            );
			 userDetails=jdbcUserDetailsManager.loadUserByUsername("ahmdd");
			if (userDetails==null)
			jdbcUserDetailsManager.createUser(
					User.withUsername("ahmdd").password(passwordEncoder.encode("1234")).authorities("admin").build()

			);

		};


	}
	//@Bean
	CommandLineRunner commandLineRunnerUserDaitls(AccontService accontService) {
		return args -> {
			accontService.addNewRole("user");

			accontService.addNewUser("user3","1234","user","1234");
				accontService.addNewUser("user4","1234","user","1234");
				accontService.addNewUser("user5","1234","user","1234");


			accontService.addRolToUser("user3","user");
			accontService.addRolToUser("user4","admin");




		};
	}

	@Bean
	public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

}
