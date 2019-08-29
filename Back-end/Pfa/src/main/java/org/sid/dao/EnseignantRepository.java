package org.sid.dao;

import java.util.List;

import org.sid.entities.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EnseignantRepository extends JpaRepository<Enseignant, Integer> {

	@Query("select c from Enseignant c ")

	public List<Enseignant> ge();
}
