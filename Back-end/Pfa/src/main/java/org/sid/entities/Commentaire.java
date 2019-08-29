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
//@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class,property="id_commentaire")

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_commentaire")
public class Commentaire implements Serializable{
	@Id @GeneratedValue
private int id_commentaire;
private String contenu;
@ManyToOne
@JoinColumn(name="user_id")
private User user;
@JsonIgnore
@ManyToOne
@JoinColumn(name="pub_id")
private Publication pub;

public Commentaire(String contenu, User user, Publication pub) {
	super();
	this.contenu = contenu;
	this.user = user;
	this.pub = pub;
}
public Commentaire() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId_commentaire() {
	return id_commentaire;
}
public void setId_commentaire(int id_commentaire) {
	this.id_commentaire = id_commentaire;
}
public String getContenu() {
	return contenu;
}
public void setContenu(String contenu) {
	this.contenu = contenu;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Publication getPub() {
	return pub;
}
public void setPub(Publication pub) {
	this.pub = pub;
}


}
