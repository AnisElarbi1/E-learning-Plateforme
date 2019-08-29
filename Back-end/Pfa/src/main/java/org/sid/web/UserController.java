package org.sid.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.management.relation.Role;

import org.sid.dao.AppRoleRepository;
import org.sid.dao.MatiereRepository;
import org.sid.dao.UserRepository;
import org.sid.entities.Abonnement;
import org.sid.entities.AppRole;
import org.sid.entities.Commentaire;
import org.sid.entities.Matiere;
import org.sid.entities.Publication;
import org.sid.entities.User;
import org.sid.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
	
	@Autowired
private UserRepository userRepository;	
	@Autowired
	private AppRoleRepository appRoleRepository;
	@Autowired
	private AccountService accountService;
	@Autowired
	private MatiereRepository matiereRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	@RequestMapping(value="/user/enseignants",method=RequestMethod.GET)
	public List<User> getEns(){
		List<User> users= userRepository.findAll();
		List<User> ens=new ArrayList<User>();
		List<AppRole> roles=new ArrayList<AppRole>();

		for(int i=0; i<users.size(); i++) 
            {
			roles=(List<AppRole>)users.get(i).getRoles();
            for(int j=0; j<roles.size(); j++)
			{if(roles.get(j).getRoleName().equals("ENSEIGNANT"))
			ens.add(users.get(i));
			}
            }
		return ens;
	}
	@RequestMapping(value="/user/etudiants",method=RequestMethod.GET)
	public List<User> getEtud(){
		List<User> users= userRepository.findAll();
		List<User> etud=new ArrayList<User>();
		List<AppRole> roles=new ArrayList<AppRole>();
 int s=0;
		for(int i=0; i<users.size(); i++) 
            {
			roles=(List<AppRole>)users.get(i).getRoles();
			s=0;
            for(int j=0; j<roles.size(); j++)
			{if((roles.get(j).getRoleName().equals("ENSEIGNANT"))||(roles.get(j).getRoleName().equals("ADMIN")))
			s++;
			 }
            if(s==0)
    			etud.add(users.get(i));
            }
		return etud;
	}
	@RequestMapping(value="/user/{id}/matieres",method=RequestMethod.GET)
	public List<Matiere> getMatieres(@PathVariable int id){
   List<Matiere> mats = new ArrayList<Matiere>();
		User u=userRepository.findOne(id);
		mats=(List<Matiere>) u.getMatieres();
		
		if(mats.size()>0)
			System.out.println(mats.size());
		return mats;

		
	}
	
	@RequestMapping(value="/user/{id}/matiere",method=RequestMethod.GET)
	public Matiere getMatiere(@PathVariable int id){
		User u=userRepository.findOne(id);
		return u.getMatiere_ens();

		
	}
	
	@RequestMapping(value="/userens/{idm}",method=RequestMethod.POST)
	public User ajoutEns(User user,@PathVariable int idm){
		User u=new User();
		Matiere m =matiereRepository.findOne(idm);
		u.setNom(user.getNom());
		u.setPrenom(user.getPrenom());
		u.setUsername(user.getUsername());
		u.setAdresse(user.getAdresse());
		u.setTel(user.getTel());
		u.setEmail(user.getEmail());
		u.setMatiere_ens(m);
		u.setActived(true);
		
		
		u.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		  accountService.addRoleToUser(u.getUsername(),"USER");
		return userRepository.save(u);

		
	}
	
	
	@RequestMapping(value="/user/{id}/matieresn",method=RequestMethod.GET)
	public List<Matiere> getMatieresn(@PathVariable int id){
   List<Matiere> mats = new ArrayList<Matiere>();
   List<Matiere> matsn = new ArrayList<Matiere>();
   List<Matiere> ret = new ArrayList<Matiere>();

int s=0;
		User u=userRepository.findOne(id);
		mats=(List<Matiere>) u.getMatieres();
		matsn=matiereRepository.findAll();
		for(int i=0;i<matsn.size();i++){
			 s=0;
			for(int j=0;j<mats.size();j++){
				if(matsn.get(i)==mats.get(j))
					s++;
			}
			if (s==0)
				ret.add(matsn.get(i));
				
		}
		return ret;

		
	}
	
	
	
	
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET)
    public User getUser(@PathVariable int id){

		return userRepository.findOne(id);

	}
	

	@RequestMapping(value="/register",method=RequestMethod.POST)
	public User register(@RequestBody UserForm userForm)
	{
		return accountService.saveUser(userForm.getUsername(), userForm.getPassword(), userForm.getConfirmedPassword());
	}
	
	
	@RequestMapping(value="/user/{id}",method=RequestMethod.DELETE)
    public void deleteUser(@PathVariable int id){

		userRepository.delete(id);

	}
	
	@RequestMapping(value="/user/update/{id}",method=RequestMethod.PUT)
	public User save(@PathVariable int id,	@RequestBody User p)
	{    p.setId(id);
		return userRepository.save(p);
	}
	
	@RequestMapping(value="/user/abs/{id}",method=RequestMethod.GET)
    public Collection<Abonnement> getAbs(@PathVariable int id){
	
		
		
		 User u=userRepository.findOne(id);
		 return  u.getAbs();
 

	}
	
	@RequestMapping(value="/roles",method=RequestMethod.GET)
	public List<AppRole> getRoles(){
		return appRoleRepository.findAll();
	}
	@RequestMapping(value="/profil",method=RequestMethod.GET)

	public User findprofil(@RequestParam(name="username",defaultValue="") String username)
{
	return userRepository.findprofil("%"+username+"%");
	}
	@RequestMapping(value="/user/etudiantsb/{id}",method=RequestMethod.PATCH)

	public void onBlock(@PathVariable int id){
		User u = userRepository.findOne(id);
		u.setActived(false);
		userRepository.save(u);
		
		
	}
	@RequestMapping(value="/user/etudiantsd/{id}",method=RequestMethod.PATCH)

	public void onDeblock(@PathVariable int id){
		User u = userRepository.findOne(id);
		u.setActived(true);
		userRepository.save(u);
		
		
	}
	/*@RequestMapping(value="/updateprofil",method=RequestMethod.PUT)
	public void updateProfil(@RequestParam(name="nom",defaultValue="")String nom,@RequestParam(name="prenom",defaultValue="")String prenom,@RequestParam(name="email",defaultValue="")String email,@RequestParam(name="adresse",defaultValue="")String adresse,@RequestParam(name="tel",defaultValue="")int tel,@RequestParam(name="username",defaultValue="")String username){
		userRepository.updateProfil("%"+nom+"%", "%"+prenom+"%", "%"+email+"%", "%"+adresse+"%", tel, "%"+username+"%");
	}*/
	@RequestMapping(value="/profilupdate/{username}",method=RequestMethod.PUT)

	public User updateProfil(@PathVariable String username,	@RequestBody User u){
		User p = userRepository.findprofil("%"+username+"%");
		p.setNom(u.getNom());
		p.setPrenom(u.getPrenom());
		p.setAdresse(u.getAdresse());
		p.setEmail(u.getEmail());
		p.setTel(u.getTel());
		p.setMatiere_ens(u.getMatiere_ens());

		return userRepository.save(p);
	}
	@RequestMapping(value="/user/ajout",method=RequestMethod.POST)
	public User save(@RequestBody User p)
	{
		/*UserForm u = new UserForm(p.getUsername(),p.getPassword(),p.getPassword());
		register(u);
		 userRepository.save(p);*/
		p.setPassword(bCryptPasswordEncoder.encode(p.getPassword()));
			
		  userRepository.save(p);
		  accountService.addRoleToUser(p.getUsername(),"USER");
		  return p;
	}

}

class UserForm {
	private String username;
	private String password;
	private String confirmedPassword;
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
	public String getConfirmedPassword() {
		return confirmedPassword;
	}
	public void setConfirmedPassword(String confirmedPassword) {
		this.confirmedPassword = confirmedPassword;
	}
	
}
