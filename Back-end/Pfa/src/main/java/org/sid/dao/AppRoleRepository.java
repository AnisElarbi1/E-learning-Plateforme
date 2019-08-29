package org.sid.dao;

import org.sid.entities.AppRole; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource

public interface AppRoleRepository extends JpaRepository<AppRole, Integer>{
	public AppRole findByRoleName(String roleName);

}
