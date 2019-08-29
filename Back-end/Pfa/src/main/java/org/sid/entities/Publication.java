package org.sid.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import net.minidev.json.annotate.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_pub")

public class Publication implements Serializable{
@Id @GeneratedValue
	private int id_pub;
	private Date date;
	private String contenu;
	private String nom;
	private String type;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToMany(mappedBy="pub",fetch=FetchType.LAZY)
	private Collection<Commentaire> commentaires;
	 //@JsonIgnore

	@ManyToOne
	@JoinColumn(name="matiere_id")
	private Matiere matiere;
	
	public Publication() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Publication(Date date, String contenu, User user,Matiere matiere) {
		super();
		this.date = date;
		this.contenu = contenu;
		this.user = user;
		this.matiere=matiere;
	}
	public Publication(Date date, String contenu,Matiere matiere) {
		super();
		this.date = date;
		this.contenu = contenu;
		this.matiere=matiere;
		

	}
	public int getId_pub() {
		return id_pub;
	}
	public void setId_pub(int id_pub) {
		this.id_pub = id_pub;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}



	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	public Collection<Commentaire> getCommentaires() {
		return commentaires;
	}
	public void setCommentaires(Collection<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
