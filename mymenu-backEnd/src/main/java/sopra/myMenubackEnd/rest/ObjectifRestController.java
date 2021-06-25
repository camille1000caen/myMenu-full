package sopra.myMenubackEnd.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
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

import sopra.myMenubackEnd.model.Objectif;
import sopra.myMenubackEnd.model.TypeObjectif;
import sopra.myMenubackEnd.model.Views;
import sopra.myMenubackEnd.repository.IObjectifRepository;

@RestController
@RequestMapping("/objectif")
@CrossOrigin("*")
public class ObjectifRestController {

	@Autowired
	private IObjectifRepository objectifRepo;

	@GetMapping("")
	@JsonView(Views.ViewObjectif.class)
	public List<Objectif> findAll() {
		return objectifRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewObjectif.class)
	public Objectif find(@PathVariable Long id) {

		Optional<Objectif> optObjectif = objectifRepo.findById(id);

		if (optObjectif.isPresent()) {
			return optObjectif.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@GetMapping("/by-type-objectif/{typeObjectif}")
	@JsonView(Views.ViewObjectif.class)
	public List<Objectif> findAllObjectifByTypeObjectif(@PathVariable TypeObjectif typeObjectif) {

		return objectifRepo.findAllObjectifByTypeObjectif(typeObjectif);
	}
	
	@PostMapping("")
	@JsonView(Views.ViewObjectif.class)
	public Objectif create(@Valid @RequestBody Objectif objectif, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erreur validation");
		}

		objectif = objectifRepo.save(objectif);

		return objectif;
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	@JsonView(Views.ViewObjectif.class)
	public Objectif update(@RequestBody Objectif objectif, @PathVariable Long id) {
		if (!objectifRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		objectif = objectifRepo.save(objectif);

		return objectif;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		objectifRepo.deleteById(id);
	}

}
