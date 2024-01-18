package com.example.configsecurity;

//import com.example.filter.JWTAuthFilter;
//import com.example.service.userservice.UserInfoService;
//import jakarta.servlet.Filter;
//import org.jetbrains.annotations.NotNull;
import com.example.configsecurity.servicesecurity.UserDaitlsServiceImpl;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration

@EnableWebSecurity
@EnableMethodSecurity
@AllArgsConstructor
public class SecurityConfig {


    private  PasswordEncoder passwordEncoder;

    private UserDaitlsServiceImpl userDaitlsServiceImpl;


    @Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }


    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
return  new InMemoryUserDetailsManager(
        User.withUsername("user").password(passwordEncoder.encode("12345")).authorities("user").build()
);
    }
@Bean
    public SecurityFilterChain securityFilterChain(@NotNull HttpSecurity httpSecurity) throws Exception {
    httpSecurity.formLogin(formLogin -> {formLogin.defaultSuccessUrl("/admin");});

    httpSecurity.authorizeHttpRequests(authorizeHttpRequests->{authorizeHttpRequests.requestMatchers("/admin/**").hasAuthority("admin");});
    httpSecurity.authorizeHttpRequests(authorizeHttpRequests->{authorizeHttpRequests.requestMatchers("/user/**").hasAuthority("user");});

    httpSecurity.authorizeHttpRequests(authorizeHttpRequests->{authorizeHttpRequests.anyRequest().authenticated();});
    httpSecurity.userDetailsService(userDaitlsServiceImpl);
    return httpSecurity.build();
    }




}
