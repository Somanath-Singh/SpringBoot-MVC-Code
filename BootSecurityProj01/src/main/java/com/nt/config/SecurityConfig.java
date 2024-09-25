package com.nt.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
	
	//in memory authorize and authentication
	@Bean
	public UserDetailsService userDetailsService() {
		
		UserDetails user = User.withUsername("raja").password(passwordEncoder().encode("rani")).roles("CUSTOMER").build();
		UserDetails manager = User.withUsername("ramesh").password(passwordEncoder().encode("hyd")).roles("MANAGER").build();
		UserDetails manager2 = User.withUsername("anil").password(passwordEncoder().encode("vizag")).roles("MANAGER","CUSTOMER").build();
		UserDetails visitor = User.withUsername("mahes").password(passwordEncoder().encode("delhi")).roles("VISITOR").build();
		
		return new InMemoryUserDetailsManager(user,manager,manager2,visitor);
		
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
		
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{

        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(request -> request.requestMatchers("/").permitAll()
                        .requestMatchers("/offers").authenticated() //authenticated() means username and password required
                        .requestMatchers("/balance").hasAnyRole( "CUSTOMER","MANAGER")
                        .requestMatchers("/loanapprove").hasAnyRole("MANAGER")
                        .anyRequest().authenticated())
                //.httpBasic(withDefaults());
               .formLogin(withDefaults())
               .logout(logout -> logout.permitAll())
               .sessionManagement(session -> session.maximumSessions(2).maxSessionsPreventsLogin(true));//should be the last statement of the method chaining //minimum 2 times we login
		
		return http.build();
		
	}






}
