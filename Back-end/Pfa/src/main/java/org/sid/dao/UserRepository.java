package org.sid.dao;

 
 import java.util.List;

import org.sid.entities.Matiere;
import org.sid.entities.User;  
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin("*")
@RepositoryRestResource
public interface UserRepository extends JpaRepository<User,Integer> { 
	
	public User findByUsername(String username);
	
	@Query("select u from User u where u.username like :x ")
	public User findprofil(@Param("x")String username);
	
	
	
	/*@Query("UPDATE user u SET u.nom = :nom, u.prenom = :prenom, u.email = :email, u.adresse = :adresse,u.tel = :tel WHERE u.username like :username")
	public void updateProfil(@Param("nom")String nom,@Param("prenom")String prenom,@Param("email")String email,@Param("adresse")String adresse,@Param("tel")int tel,@Param("username")String username);
	*/
}