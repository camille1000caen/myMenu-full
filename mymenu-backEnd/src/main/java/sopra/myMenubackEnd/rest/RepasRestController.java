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

import sopra.myMenubackEnd.model.Repas;
import sopra.myMenubackEnd.model.TypeRepas;
import sopra.myMenubackEnd.model.Views;
import sopra.myMenubackEnd.repository.IRepasRepository;

@RestController
@RequestMapping("/repas")
@CrossOrigin("*")
public class RepasRestController {

	@Autowired
	private IRepasRepository repasRepo;

	@GetMapping("")
	@JsonView(Views.ViewRepas.class)
	public List<Repas> findAll() {
		return repasRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewRepas.class)
	public Repas find(@PathVariable Long id) {

		Optional<Repas> optRepas = repasRepo.findById(id);

		if (optRepas.isPresent()) {
			return optRepas.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@GetMapping("/by-type-repas/{typeRepas}")
	@JsonView(Views.ViewRepas.class)
	public List<Repas> findAllRepasByTypeRepas(@PathVariable TypeRepas typeRepas) {

		return repasRepo.findAllRepasByTypeRepas(typeRepas);
	}
	
	@GetMapping("/{id}/detail-menu")
	@JsonView(Views.ViewRepasWithMenu.class)
	public Repas findRepasByIdWithMenu(@PathVariable Long id) {

		Optional<Repas> optRepas = repasRepo.findRepasByIdWithMenu(id);

		if (optRepas.isPresent()) {
			return optRepas.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@GetMapping("/by-menu/{idMenu}")
	@JsonView(Views.ViewRepas.class)
	public List<Repas> findAllByObjectif(@PathVariable Long idObjectif) {

		List<Repas> repas = repasRepo.findAllRepasByMenu(idObjectif);

		return repas;
	}
	
	@GetMapping("/with-menu")
	@JsonView(Views.ViewRepasWithMenu.class)
	public List<Repas> findAllRepasWithMenu() {

		List<Repas> repas = repasRepo.findAllRepasWithMenu();

		return repas;
	}

	@PostMapping("")
	@JsonView(Views.ViewRepas.class)
	public Repas create(@Valid @RequestBody Repas repas, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erreur validation");
		}

		repas = repasRepo.save(repas);

		return repas;
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	@JsonView(Views.ViewRepas.class)
	public Repas update(@RequestBody Repas repas, @PathVariable Long id) {
		if (!repasRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		repas = repasRepo.save(repas);

		return repas;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repasRepo.deleteById(id);
	}

}
