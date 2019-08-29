package org.sid.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",discriminatorType=DiscriminatorType.STRING,length=3)
@DiscriminatorValue("usr")
@JsonIdentityInfo(generator = PropertyGenerator.class, property = "id")

public class User implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
	@Column(unique=true)
	private String username;
	private String password;
	private int tel;
	private boolean actived;

	@ManyToOne
	@JoinColumn(name="matiere_id")
	private Matiere matiere_ens;
	
	@JsonIgnore
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
	private Collection<Abonnement> abs;
	

	@ManyToMany
	private List<Matiere> matieres;
	@JsonIgnore

	@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
	private Collection<Commentaire> commentaires;
	@ManyToMany(fetch=FetchType.EAGER)
	private Collection<AppRole> roles= new ArrayList<AppRole>();
	
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
	
	private Collection<Publication> pub ;
	public User() {
		super();
	}


	





	public User(int id, String nom, String prenom, String email,
			String adresse, String username, String password, int tel,
			boolean actived) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.username = username;
		this.password = password;
		this.tel = tel;
		this.actived = actived;
	}








	public Collection<Abonnement> getAbs() {
		return abs;
	}

	public void setAbs(Collection<Abonnement> abs) {
		this.abs = abs;
	}

	public List<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}

	public Collection<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(Collection<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}




	public boolean isActived() {
		return actived;
	}








	public void setActived(boolean actived) {
		this.actived = actived;
	}








	public Collection<AppRole> getRoles() {
		return roles;
	}








	public void setRoles(Collection<AppRole> roles) {
		this.roles = roles;
	}








	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




public Collection<Publication> getPub() {
		return pub;
	}
public void setPub(Collection<Publication> pub) {
		this.pub = pub;
	}








public Matiere getMatiere_ens() {
	return matiere_ens;
}








public void setMatiere_ens(Matiere matiere_ens) {
	this.matiere_ens = matiere_ens;
}
 

	
	
	





}
