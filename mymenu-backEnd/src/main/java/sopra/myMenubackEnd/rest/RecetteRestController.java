package sopra.myMenubackEnd.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.myMenubackEnd.model.Recette;
import sopra.myMenubackEnd.model.TypeRepas;
import sopra.myMenubackEnd.model.Views;
import sopra.myMenubackEnd.repository.IRecetteRepository;



@RestController
@RequestMapping("/recette")
@CrossOrigin("*")
public class RecetteRestController {

	@Autowired
	private IRecetteRepository recetteRepo;
	
	@GetMapping("")
	@JsonView(Views.ViewRecette.class)
	public List<Recette>  findAll(){
		List<Recette> recettes = recetteRepo.findAll();
		
		return recettes;
	}
	
	@GetMapping("/detail")
	@JsonView(Views.ViewRecetteDetail.class)
	public List<Recette>  findAllRecetteWithPlat(){
		List<Recette> recettes = recetteRepo.findAllRecetteWithPlat();
		
		return recettes;
	}
	
	@GetMapping("/by-plat/{id}")
	@JsonView(Views.ViewRecette.class)
	public List<Recette>  findAllRecetteByPlat(@PathVariable Long id){
		List<Recette> recettes = recetteRepo.findAllRecetteByPlat(id);
		
		return recettes;
	}
	
	
	@GetMapping("/by-rising-note")
	@JsonView(Views.ViewRecette.class)
	public List<Recette> findByRisingNote() {

		return recetteRepo.findByRisingNote();
	}
	
	@GetMapping("/detail/by-rising-note")
	@JsonView(Views.ViewRecetteDetail.class)
	public List<Recette> findByRisingNoteWithPlat() {
		List<Recette> res=huitpremier(recetteRepo.findByRisingNoteWithPlat());
		return res;
	}
	
	@GetMapping("/detail/by-rising-note/by-type-repas/{typeRepas}")
	@JsonView(Views.ViewRecetteDetail.class)
	public List<Recette> findByRisingNoteWithPlatByTypeRepas(@PathVariable TypeRepas typeRepas) {
		List<Recette> res=recetteRepo.findByRisingNoteWithPlatByTypeRepas(typeRepas);
		return res;
	}
	
	public List<Recette> huitpremier(List<Recette>list) {
		List<Recette> res=new ArrayList<Recette>();
		for (int i=0;i<8;i++) {
			//res.add(list.get((int) Math.floor(Math.random()*list.size())));
			res.add(list.get(i));
		}
		return res;
	}
	
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewRecette.class)
	
	public Recette find(@PathVariable Long id) {
		
		Optional<Recette> optRecette = recetteRepo.findById(id);
		
		if(optRecette.isPresent()) {
			return optRecette.get();
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}	
	}
	
	@GetMapping("/detail/{id}")
	@JsonView(Views.ViewRecetteDetail.class)
	
	public Recette findByIdWithPlat(@PathVariable Long id) {
		
		Optional<Recette> optRecette = recetteRepo.findRecetteByIdWithPlat(id);
		
		if(optRecette.isPresent()) {
			return optRecette.get();
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	
	@PostMapping("")
	@JsonView(Views.ViewRecette.class)
	@PreAuthorize("hasRole('ADMIN')")
	public Recette create(@RequestBody Recette recette) {
		recette = recetteRepo.save(recette);

		return recette;
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	@JsonView(Views.ViewRecette.class)
	public Recette update(@RequestBody Recette recette, @PathVariable Long id) {
		if (!recetteRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		recette = recetteRepo.save(recette);

		return recette;
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void delete(@PathVariable Long id) {
		recetteRepo.deleteById(id);
	}
}


