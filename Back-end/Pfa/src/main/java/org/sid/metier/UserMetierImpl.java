/*package org.sid.metier;

import javax.management.RuntimeErrorException;

import org.sid.dao.AbonnementRepository;
import org.sid.dao.CommentaireRepository;
import org.sid.dao.UserRepository;
import org.sid.entities.Abonnement;
import org.sid.entities.Commentaire;
import org.sid.entities.Matiere;
import org.sid.entities.Publication;
import org.sid.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserMetierImpl implements IUserMetier{
	@Autowired
private UserRepository userRepository;
	@Autowired
private AbonnementRepository abonnementRepository;
	
	@Autowired
	private CommentaireRepository commentaireRepository;
	public User consulterProfil(int id) {
		User u=userRepository.findOne(id);
		if(u==null)
			throw new RuntimeException("Utitlisateur introuvable");	
		return u;
	}
	public void ajouter(User user) {
User u=userRepository.save(user);		
	}
	public void supprimer(int id) {
User u=userRepository.findOne(id);
if(u==null)
	throw new RuntimeException("Utitlisateur introuvable");	
userRepository.delete(u);
	}
	public void edit(User user,String adresse,String nom,String prenom,int tel,String email) {
		
		if(adresse!=null)
		user.setAdresse(adresse);
		
		if(email!=null)

		user.setEmail(email);
		
		if(nom!=null)

		user.setNom(nom);
		
		if(prenom!=null)

		user.setPrenom(prenom);
		
		if(String.valueOf(tel)!=null)

		user.setTel(tel);
	}
	public void abonner(User user, Matiere matiere) {
Abonnement ab = new Abonnement(user.getId(), matiere.getId_matiere());
		abonnementRepository.save(ab);
		
	}
	public void commenter(User user, Publication pub,String contenu) {
Commentaire cm= new Commentaire(contenu, user, pub);
commentaireRepository.save(cm);
	}
	

}
*/