package com.itxxz.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomAuthenticationProvider provider;
	@Autowired
    private AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> authenticationDetailsSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();// csrf:Cross-site request forgery跨站请求伪造
		http.authorizeRequests().antMatchers("/admin/**").hasAuthority("admin") // 登陆后之后拥有“ADMIN”权限才可以访问
				.and().formLogin().loginPage("/login").defaultSuccessUrl("/admin/main")
				.authenticationDetailsSource(authenticationDetailsSource)
				.failureUrl("/login?error").permitAll().and().logout().permitAll().logoutUrl("/logout")
				.logoutSuccessUrl("/loginSuccess");
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.eraseCredentials(false);
		auth.authenticationProvider(provider);
	}

}