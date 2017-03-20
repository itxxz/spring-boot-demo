package com.itxxz.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

public class CustomWebAuthenticationDetails extends WebAuthenticationDetails {
    /**
     * 
     */
    private static final long serialVersionUID = 6975601077710753878L;
    private final boolean flag;

    public CustomWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        String authCode = request.getParameter("authCode");
        String code = request.getSession().getAttribute("authCode").toString();
        
        if(code.equalsIgnoreCase(authCode)){
        	flag = true;
        }else{
        	flag = false;
        }
    }

    public boolean getFlag() {
        return flag;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        return sb.toString();
    }
}
