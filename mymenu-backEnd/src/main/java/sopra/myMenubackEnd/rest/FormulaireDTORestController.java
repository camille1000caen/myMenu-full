package sopra.myMenubackEnd.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;
import com.sun.el.stream.Optional;

import sopra.myMenubackEnd.model.Objectif;
import sopra.myMenubackEnd.model.Planning;
import sopra.myMenubackEnd.model.PreferenceAlimentaire;
import sopra.myMenubackEnd.model.Utilisateur;
import sopra.myMenubackEnd.model.Views;
import sopra.myMenubackEnd.repository.IObjectifRepository;
import sopra.myMenubackEnd.repository.IPlanningRepository;
import sopra.myMenubackEnd.repository.IPreferenceAlimentaireRepository;
import sopra.myMenubackEnd.repository.IUtilisateurRepository;
import sopra.myMenubackEnd.service.FormulaireDTO;

@RestController
@RequestMapping("/formulaireDTO")
@CrossOrigin("*")
public class FormulaireDTORestController {
	@Autowired
	private IUtilisateurRepository utilrepo;
	@Autowired
	private IObjectifRepository objrepo;
	@Autowired
	private IPlanningRepository planningrepo;
	@Autowired
	private IPreferenceAlimentaireRepository prefAlimrepo;
	
	@GetMapping("/{id}")
	public FormulaireDTO find(@PathVariable Long id) {
		Utilisateur user = utilrepo.findById(id).get();
		
		FormulaireDTO formDTO =new FormulaireDTO();
		
		formDTO.setDateNaissance(user.getDateNaissance());
		formDTO.setGenre(user.getGenre());
		formDTO.setImc(user.getImc());
		formDTO.setNom(user.getNom());
		formDTO.setPrenom(user.getPrenom());
		formDTO.setPhysicalActivity(user.getPhysicalActivity());
		formDTO.setPoids(user.getPoids());
		formDTO.setTaille(user.getTaille());
		formDTO.setEmail(user.getEmail());
		formDTO.setTelephone(user.getTelephone());
		formDTO.setPassword(user.getPassword());
		formDTO.setUsername(user.getUsername());
		
		return formDTO;
			
	}
	@PostMapping("")
	@JsonView(Views.ViewUtilisateur.class)
	public Utilisateur create(@RequestBody FormulaireDTO formulaireDTO) {
		// algo formDTO => utilisateur, etc ...
		Utilisateur user=new Utilisateur();
		Objectif objectif=new Objectif();
		Planning planning=new Planning();
		PreferenceAlimentaire prefAlim=new PreferenceAlimentaire();
		
		user.setDateNaissance(formulaireDTO.getDateNaissance());
		user.setGenre(formulaireDTO.getGenre());
		user.setImc(formulaireDTO.getImc());
		user.setNom(formulaireDTO.getNom());
		user.setPrenom(formulaireDTO.getPrenom());
		user.setPhysicalActivity(formulaireDTO.getPhysicalActivity());
		user.setPoids(formulaireDTO.getPoids());
		user.setTaille(formulaireDTO.getTaille());
		user.setEmail(formulaireDTO.getEmail());
		user.setTelephone(formulaireDTO.getTelephone());
		user.setPassword(formulaireDTO.getPassword());
		user.setEnable(true);
		user.setUsername(formulaireDTO.getUsername());
		
		prefAlim.setTypeAlimentation(formulaireDTO.getTypeAlimentation());
		prefAlim.setUtilisateur(user);
		
		objectif.setTypeObjectif(formulaireDTO.getTypeObjectif());
		
		planning.setObjectif(objectif);
		
		planning.setUtilisateur(user);
		
		user=utilrepo.save(user);
		prefAlim=prefAlimrepo.save(prefAlim);
		objectif=objrepo.save(objectif);
		planning=planningrepo.save(planning);
		return user;
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewUtilisateur.class)
	//@PreAuthorize("hasRole('ADMIN')")
	public Utilisateur update(@RequestBody FormulaireDTO formulaireDTO, @PathVariable Long id) {
		if (!utilrepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		Utilisateur user=new Utilisateur();
		Objectif objectif=new Objectif();
		Planning planning=new Planning();
		PreferenceAlimentaire prefAlim=new PreferenceAlimentaire();
		
		user.setDateNaissance(formulaireDTO.getDateNaissance());
		user.setGenre(formulaireDTO.getGenre());
		user.setImc(formulaireDTO.getImc());
		user.setNom(formulaireDTO.getNom());
		user.setPrenom(formulaireDTO.getPrenom());
		user.setPhysicalActivity(formulaireDTO.getPhysicalActivity());
		user.setPoids(formulaireDTO.getPoids());
		user.setTaille(formulaireDTO.getTaille());
		user.setEmail(formulaireDTO.getEmail());
		user.setTelephone(formulaireDTO.getTelephone());
		user.setPassword(formulaireDTO.getPassword());
		user.setEnable(true);
		user.setUsername(formulaireDTO.getUsername());
		
		prefAlim.setTypeAlimentation(formulaireDTO.getTypeAlimentation());
		prefAlim.setUtilisateur(user);
		
		objectif.setTypeObjectif(formulaireDTO.getTypeObjectif());
		
		planning.setObjectif(objectif);
		
		planning.setUtilisateur(user);
		
		user=utilrepo.save(user);
		prefAlim=prefAlimrepo.save(prefAlim);
		objectif=objrepo.save(objectif);
		planning=planningrepo.save(planning);
		return user;
	}


}
