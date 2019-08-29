package org.sid.sec;

import java.util.ArrayList; 
import java.util.Collection;

import javax.management.relation.Role;

import org.sid.entities.AppRole;
import org.sid.entities.User;
import org.sid.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service 

public class UserDetailsServiceImpl implements UserDetailsService {
    
	@Autowired
	private AccountService accountService;
	 //private AccountService 
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
	User user=	accountService.loadUserByUsername(username);
		if(user==null) throw new UsernameNotFoundException("invalid user ");
		Collection<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
		
       for(AppRole r: user.getRoles())
	{  authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
//System.out.println(r.getRoleName());
	}
       return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities) ;
}
}
