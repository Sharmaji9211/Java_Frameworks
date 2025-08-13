package com.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig 
{
	@Bean
	UserDetailsService getUserDetails(PasswordEncoder encoder)
	{
		
		System.out.println(encoder.encode("amit"));
		UserDetails user1=User.withUsername("amit123").password(encoder.encode("amit")).roles("ADMIN","USER").build();
		UserDetails user2=User.withUsername("manoj123").password(encoder.encode("manoj")).roles("USER","GUEST").build();
		UserDetails user3=User.withUsername("imran123").password(encoder.encode("imran")).roles("GUEST").build();
		UserDetailsService service=new InMemoryUserDetailsManager(user1,user2,user3);
		return service;
	}
	@Bean
	PasswordEncoder getPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}
