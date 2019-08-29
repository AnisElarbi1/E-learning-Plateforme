package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_abonnement")


public class Abonnement implements Serializable{
  @Id @GeneratedValue
	private int id_abonnement;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
  
	@ManyToOne
	@JoinColumn(name="matiere_id")
	private Matiere matiere;
	
	public Abonnement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Abonnement(User user, Matiere matiere) {
		super();
		this.user = user;
		this.matiere = matiere;
	}

	public int getId_abonnement() {
		return id_abonnement;
	}
	public void setId_abonnement(int id_abonnement) {
		this.id_abonnement = id_abonnement;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

}
