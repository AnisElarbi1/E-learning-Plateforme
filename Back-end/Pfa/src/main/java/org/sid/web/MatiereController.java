package org.sid.web;

import java.util.Collection;
import java.util.List;

import org.sid.dao.AbonnementRepository;
import org.sid.dao.MatiereRepository;
import org.sid.dao.PublicationRepository;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MatiereController {
    @Autowired
	AbonnementRepository abonnementRepository;
	@Autowired
	MatiereRepository matiereRepository ;
	
	@Autowired
	PublicationRepository publicationRepository;
	@Autowired

	UserRepository userRepository;
	@RequestMapping(value="/matieres",method=RequestMethod.GET)
	public List<Matiere> getMatieres()
	{
		return matiereRepository.findAll();
		
	}
	
	@RequestMapping(value="/matieres/{id}",method=RequestMethod.GET)
    public Matiere getMatiere(@PathVariable int id){

		return matiereRepository.findOne(id);

	}
	
	@RequestMapping(value="/matieres/{id}/users",method=RequestMethod.GET)
    public Collection<User> getUsers(@PathVariable int id){
            Matiere m = matiereRepository.findOne(id);
		return m.getUsers();

	}
	
	@RequestMapping(value="/matiere/ajout",method=RequestMethod.POST)
	public Matiere save(@RequestBody Matiere m)
	{
		return matiereRepository.save(m);
	}
	
	@RequestMapping(value="/matiere/supprimer/{id}",method=RequestMethod.DELETE)
    public void deleteMatiere(@PathVariable int id){

		matiereRepository.delete(id);

	}
	
	@RequestMapping(value="/matiere/update/{id}",method=RequestMethod.PUT)
	public Matiere save(@PathVariable int id,	@RequestBody Matiere m)
	{    m.setId_matiere(id);
		return matiereRepository.save(m);
	}

	
	@RequestMapping(value="/matiere/{id}",method=RequestMethod.GET)
    public Collection<Abonnement> getAbs(@PathVariable int id){
	
		
		
		 Matiere pb=matiereRepository.findOne(id);
		 return  pb.getAbs();
 

	}
	@RequestMapping(value="/matiere/save/{idu}",method=RequestMethod.POST)
	public Matiere ajoutMatiere(@PathVariable int idu,	@RequestBody Matiere m)
	{    User u = userRepository.findOne(idu);
	Matiere mat = new Matiere();
	  mat.setNomMatiere(m.getNomMatiere());
	  u.setMatiere_ens(mat);
		return matiereRepository.save(mat);
	}

	
	
	@RequestMapping(value="/matiere/chercher",method=RequestMethod.GET)

	public Page<Matiere> chercher(
			@RequestParam(name="mc",defaultValue="") String mc,
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="5") int size)
{
	return matiereRepository.chercherParNom("%"+mc+"%",new PageRequest(page, size));
	}
	@RequestMapping(value="/matieres/{id}/pubs",method=RequestMethod.GET)

	public List<Publication> getPubs(
			 @PathVariable int id){
		
		return publicationRepository.getPubs(id);
	}
	
}
