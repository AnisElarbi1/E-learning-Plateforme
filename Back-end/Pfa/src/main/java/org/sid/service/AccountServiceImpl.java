package org.sid.service;

import javax.transaction.Transactional;

import org.sid.dao.AppRoleRepository;
import org.sid.dao.UserRepository;
import org.sid.entities.AppRole;
import org.sid.entities.Matiere;
import org.sid.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AppRoleRepository appRoleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	public User saveUser(String username, String password,String confirmedPassword) {
	
		User user=userRepository.findByUsername(username);
		if(user!=null) throw new RuntimeException("Utilsateur existe déja");
		if(!password.equals(confirmedPassword))throw new RuntimeException("Password non confirmé");
			User userr=new User();
			userr.setUsername(username);	
			userr.setPassword(bCryptPasswordEncoder.encode(password));
			userr.setActived(true);
			userRepository.save(userr);
			addRoleToUser(username, "USER");
		return userr;
	}

	public AppRole save(AppRole role) {
		// TODO Auto-generated method stub
		return appRoleRepository.save(role);
	}

	public User loadUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

	public void addRoleToUser(String username, String roleName) {
 
		User user=userRepository.findByUsername(username);
		AppRole role=appRoleRepository.findByRoleName(roleName);
		
		user.getRoles().add(role);
	}

	public User saveUserr(String username, String password,String confirmedPassword, Matiere m) {
		User user=userRepository.findByUsername(username);
		if(user!=null) throw new RuntimeException("Utilsateur existe déja");
		if(!password.equals(confirmedPassword))throw new RuntimeException("Password non confirmé");
			User userr=new User();
			userr.setUsername(username);	
			userr.setPassword(bCryptPasswordEncoder.encode(password));
			userr.setActived(true);
			userr.setMatiere_ens(m);
			userRepository.save(userr);
			addRoleToUser(username, "USER");
		return userr;
	}

}
