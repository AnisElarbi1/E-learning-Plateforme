package org.sid.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.sid.dao.AbonnementRepository;
import org.sid.dao.MatiereRepository;
import org.sid.dao.UserRepository;
import org.sid.entities.Abonnement;
import org.sid.entities.Commentaire;
import org.sid.entities.Matiere;
import org.sid.entities.Publication;
import org.sid.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AbonnementController {

	@Autowired
	AbonnementRepository abonnementRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	MatiereRepository matiereRepository;
	@RequestMapping(value="/abonnements/{idm}/{idu}",method=RequestMethod.POST)
	public Abonnement save(@PathVariable int idm,@PathVariable int idu)
	{   User u =userRepository.findOne(idu);
	    Matiere m = matiereRepository.findOne(idm);
	    m.getUsers().add(u);
	    u.getMatieres().add(m);
	    Abonnement ab= new Abonnement(u,m);
		return abonnementRepository.save(ab);
	}
	@RequestMapping(value="/abonnements/{idm}/{idu}",method=RequestMethod.DELETE)
	public void delete(@PathVariable int idm,@PathVariable int idu)
	{  User u =userRepository.findOne(idu);
    Matiere m = matiereRepository.findOne(idm);
    u.getMatieres().remove(m);
    m.getUsers().remove(u);
	    Abonnement ab= abonnementRepository.chercherParUserMatiere(idu,idm);
		 abonnementRepository.delete(ab);
	}
	
	@RequestMapping(value="/abonnements/chercher/{u}/{m}",method=RequestMethod.GET)

	public Abonnement chercher(@PathVariable int u,@PathVariable int m)
{
		
	return abonnementRepository.chercherParUserMatiere(u,m);
	}
	
	@RequestMapping(value="/abonnements/test/{idm}/{idu}",method=RequestMethod.GET)
	public boolean isAbon(@PathVariable int idm,@PathVariable int idu)
	{   
	   Matiere m = matiereRepository.findOne(idm);
		List<User> users=(List<User>) m.getUsers();
  for(int i=0;i<users.size();i++)
  {
	  if ((users.get(i).getId())== idu )
		  return true;
		  
  }
		return false;
	}
	
	@RequestMapping(value="/abonnements",method=RequestMethod.GET)
	public List<Abonnement> getAbs()
	{
		return abonnementRepository.findAll();
	}
	
	@RequestMapping(value="/abonnements/{id}",method=RequestMethod.GET)
    public Matiere getMatiere(@PathVariable int id){
	
		Abonnement ab=abonnementRepository.findOne(id);
		
		 return  ab.getMatiere();
 

	}
}
