package org.sid.sec;

import java.io.IOException; 
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sid.entities.AppRole;
import org.sid.entities.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

private AuthenticationManager authenticationManager;

public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
	super();
	this.authenticationManager = authenticationManager;
}

@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException {
   try{
	   User user =new ObjectMapper().readValue(request.getInputStream(),User.class);
	   return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
	   
   }
   catch(IOException e){
	   e.printStackTrace();
	   throw new RuntimeException(e);
   }
  
}

@Override
	protected void successfulAuthentication(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
	
	org.springframework.security.core.userdetails.User user=(org.springframework.security.core.userdetails.User) authResult.getPrincipal();
	List<String> roles=new ArrayList<String>();

    for(GrantedAuthority a: authResult.getAuthorities())
   
 		roles.add(a.getAuthority());

String jwt=JWT.create()
.withIssuer(request.getRequestURI())
.withSubject(user.getUsername())
.withArrayClaim("roles",roles.toArray(new String[roles.size()]))
.withExpiresAt(new Date(System.currentTimeMillis()+SecurityParams.EXPIRATION))
.sign(Algorithm.HMAC256(SecurityParams.SECRET));
response.addHeader(SecurityParams.JWT_HEADER_NAME	,jwt);

}


}
