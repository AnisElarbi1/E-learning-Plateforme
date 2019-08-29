package org.sid.entities;

import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@DiscriminatorValue("ens")

public class Enseignant extends User {
	
	
	
	  


	
private Matiere matierens ;

	
private Collection<Publication> pub ;
public Enseignant() {
	super();
}



public Enseignant(int id, String nom, String prenom, String email,
		String adresse, String username, String password, int tel,
		boolean actived) {
	super(id, nom, prenom, email, adresse, username, password, tel, actived);
	// TODO Auto-generated constructor stub
}




public Collection<Publication> getPub() {
	return pub;
}

public void setPub(Collection<Publication> pub) {
	this.pub = pub;
}
public Matiere getMatierens() {
	return matierens;
}

public void setMatierens(Matiere matierens) {
	this.matierens = matierens;
}












}
