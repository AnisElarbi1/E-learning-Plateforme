package org.sid.dao;

import org.sid.entities.Abonnement; 
import org.sid.entities.Matiere;
import org.sid.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AbonnementRepository extends JpaRepository<Abonnement, Integer> {
	@Query("select c from Abonnement c where c.user.id = :x  and c.matiere.id_matiere = :y")
	public Abonnement chercherParUserMatiere(@Param("x")int u,@Param("y")int m);

}
