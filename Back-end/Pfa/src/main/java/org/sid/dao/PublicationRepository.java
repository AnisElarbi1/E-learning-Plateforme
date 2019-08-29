package org.sid.dao;

import java.util.List;

import org.sid.entities.Publication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PublicationRepository extends JpaRepository<Publication, Integer>{
	
	@Query("select c from Publication c where c.matiere.id_matiere =:x ")

	public List<Publication> getPubs(@Param("x")int id);
}
