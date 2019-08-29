package org.sid.web;

import java.util.Date;
import java.util.List; 

import org.sid.dao.MatiereRepository;
import org.sid.dao.PublicationRepository;
import org.sid.dao.UserRepository;
import org.sid.entities.Commentaire;
import org.sid.entities.Matiere;
import org.sid.entities.Publication;
import org.sid.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PublicationController {

	@Autowired
	private PublicationRepository publicationRepository;
	
	@Autowired
	private MatiereRepository matiereRepository ;
	
	@Autowired
	private UserRepository userRepository;
	@RequestMapping(value="/publications",method=RequestMethod.GET)
	public List<Publication> getPublications()
	{
		return publicationRepository.findAll();
	}
	
	
	@RequestMapping(value="/publications/{id}",method=RequestMethod.GET)
    public Publication getPublication(@PathVariable int id){

		return publicationRepository.findOne(id);

	}
	@RequestMapping(value="/publications/{id}/commentaires",method=RequestMethod.GET)
    public  List<Commentaire>  getComs(@PathVariable int id){
  
		 Publication p =publicationRepository.findOne(id);
		 List<Commentaire> coms = (List<Commentaire>) p.getCommentaires();
		 return coms;

	}
	@RequestMapping(value="/publication/ajout/{idm}/{idu}",method=RequestMethod.POST)
	public Publication save(@RequestBody Publication p,@PathVariable int idm,@PathVariable int idu)
	{    Publication pub =new Publication();
	Matiere m= matiereRepository.findOne(idm);
	User u = userRepository.findOne(idu);
	      pub.setContenu(p.getContenu());
	      pub.setType(p.getType());
	      pub.setDate(new Date());
	      pub.setUser(u);
	      pub.setMatiere(m);
	     
		return publicationRepository.save(pub);
	}
	@RequestMapping(value="/publications/{idm}/{idu}",method=RequestMethod.POST)
	
	public Publication addPubMat(@RequestBody Publication pp,@PathVariable int idm,@PathVariable int idu)
	{ Matiere m= matiereRepository.findOne(idm);
	User u = userRepository.findOne(idu);
	Publication p = new Publication(new Date(), pp.getContenu(),u,m);
		return publicationRepository.save(p);
	}
	@RequestMapping(value="/publications/{id}",method=RequestMethod.DELETE)
    public void deletePublication(@PathVariable int id){

		publicationRepository.delete(id);

	}
	
	@RequestMapping(value="/publications/{id}",method=RequestMethod.PATCH)
	public Publication save(@PathVariable int id,	@RequestBody Publication p)
	{  //  p.setId_pub(id);
		p.setDate(new Date());
		Publication pp = publicationRepository.findOne(id);
		p.setMatiere(pp.getMatiere());
		return publicationRepository.save(p);
	}
}
