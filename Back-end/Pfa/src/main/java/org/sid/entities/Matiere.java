package org.sid.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
@Entity
//@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class,property="id_inconnu")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_matiere")

public class Matiere implements Serializable{
@Id @GeneratedValue
	
	private int id_matiere;
	private String nomMatiere;


@JsonIgnore
	@OneToMany(mappedBy="matiere",fetch=FetchType.LAZY)
	private Collection<Publication> pubs;

@JsonIgnore
	@OneToMany(mappedBy="matiere",fetch=FetchType.LAZY)
	private Collection<Abonnement> abs;
@JsonIgnore

	@ManyToMany
	private Collection<User> users;
	

	
	


	@OneToMany(cascade = CascadeType.ALL,
			 fetch=FetchType.LAZY,
	            mappedBy = "matiere_ens" )   
	 private List<User> enseignants ;
	
	


	public Matiere(String nomMatiere) {
		super();
		this.nomMatiere = nomMatiere;
	}



	public Matiere() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId_matiere() {
		return id_matiere;
	}
	public void setId_matiere(int id_matiere) {
		this.id_matiere = id_matiere;
	}
	public String getNomMatiere() {
		return nomMatiere;
	}
	public void setNomMatiere(String nomMatiere) {
		this.nomMatiere = nomMatiere;
	}

	public Collection<Publication> getPubs() {
		return pubs;
	}
	public void setPubs(Collection<Publication> pubs) {
		this.pubs = pubs;
	}
	public Collection<User> getUsers() {
		return users;
	}
	public void setUsers(Collection<User> users) {
		this.users = users;
	}
	
	public Collection<Abonnement> getAbs() {
		return abs;
	}
	public void setAbs(Collection<Abonnement> abs) {
		this.abs = abs;
	}



	public List<User> getEnseignants() {
		return enseignants;
	}



	public void setEnseignants(List<User> enseignants) {
		this.enseignants = enseignants;
	}


}
