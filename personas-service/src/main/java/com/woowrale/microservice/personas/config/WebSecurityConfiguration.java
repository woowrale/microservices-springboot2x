package com.woowrale.microservice.personas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * The Class WebSecurityConfiguration.
 */
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	/** The access denied handler. */
	@Autowired
	private AccessDeniedHandler accessDeniedHandler;
	
	/** The user. */
	@Value("${security.user.name}")
	private String user;
	
	/** The password. */
	@Value("${security.user.password}")
	private String password;
	
	/** The role. */
	@Value("${security.user.role}")
	private String role;

	/* (non-Javadoc)
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		.antMatchers("/", "/about", "/console").permitAll()
		.and().formLogin().loginPage("/login").permitAll()
		.and().logout().permitAll()
		.and().exceptionHandling().accessDeniedHandler(accessDeniedHandler);

	}

	/**
	 * Configure global.
	 *
	 * @param auth the auth
	 * @throws Exception the exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser(user).password(password).roles(role);
	}
}
