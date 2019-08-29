package org.sid.web;

import java.util.Collection; 
import java.util.List;

import org.sid.dao.CommentaireRepository;
import org.sid.dao.PublicationRepository;
import org.sid.dao.UserRepository;
import org.sid.entities.Commentaire;
import org.sid.entities.Publication;
import org.sid.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CommentaireController {

	@Autowired
	CommentaireRepository commentaireRepository;
	@Autowired
PublicationRepository publicationRepository ;
	@Autowired

	UserRepository userRepository;
	
	@RequestMapping(value="/commentaires",method=RequestMethod.GET)
	public List<Commentaire> getComs()
	{
		return commentaireRepository.findAll();
	}
	
	@RequestMapping(value="/commentaires/{id}",method=RequestMethod.GET)
    public Commentaire getComss(@PathVariable int id){
	
		
		
		return commentaireRepository.findOne(id);
		   
 

	}
	
	@RequestMapping(value="/commentaire/ajout/{idu}/{idp}",method=RequestMethod.POST)
	public Commentaire save(@RequestBody Commentaire c,@PathVariable int idu,@PathVariable int idp)
	{  User u=userRepository.findOne(idu);
	Publication p=publicationRepository.findOne(idp);
	Commentaire com=new Commentaire();
	
	com.setContenu(c.getContenu());
	com.setUser(u);
	com.setPub(p);
	p.getCommentaires().add(com);
	u.getCommentaires().add(com);
		return commentaireRepository.save(com);
	}
	
	@RequestMapping(value="/commentaire/{id}",method=RequestMethod.DELETE)
    public void deleteCommentaire(@PathVariable int id){

		commentaireRepository.delete(id);

	}
	@RequestMapping(value="/commentaire/update/{id}",method=RequestMethod.PUT)
	public Commentaire save(@PathVariable int id,	@RequestBody Commentaire p)
	{    p.setId_commentaire(id);
		return commentaireRepository.save(p);
	}
}
