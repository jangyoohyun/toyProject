package com.study.toyproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.study.toyproject.config.oauth.OAuth2DetailsService;
import com.study.toyproject.handler.CustomAuthFailHandler;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final CustomAuthFailHandler customAuthFailHandler;
	private final OAuth2DetailsService oAuth2DetailsService;

	@Bean
	BCryptPasswordEncoder encoded() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		
		http.authorizeRequests()
			.antMatchers("/", "/photo", "/board", "/auth").authenticated()
			.anyRequest().permitAll()
			.and()
			.formLogin()
			.loginPage("/auth/signInForm")
			.loginProcessingUrl("/auth/signIn")
			.failureHandler(customAuthFailHandler)
			.defaultSuccessUrl("/")
			.and()
			.oauth2Login() 
			.userInfoEndpoint()
			.userService(oAuth2DetailsService);

	}


	
}
