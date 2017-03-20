package com.itxxz.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.itxxz.entity.User;
import com.itxxz.service.UserService;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    /**
     * 自定义验证方式
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    	
    	/*CustomWebAuthenticationDetails details = (CustomWebAuthenticationDetails) authentication.getDetails(); 
    	if(!details.getFlag()){
    		throw new BadCredentialsException("验证码错误.");
    	}*/
    	
    	String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        User user = userService.findUserByAccount(username);
        
        if(user == null){
            throw new BadCredentialsException("用户不存在.");
        }
        
        if (!password.equals(user.getPassword())) {
            throw new BadCredentialsException("密码错误.");
        }
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        return new UsernamePasswordAuthenticationToken(user, password, authorities);
    }

    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }

}
