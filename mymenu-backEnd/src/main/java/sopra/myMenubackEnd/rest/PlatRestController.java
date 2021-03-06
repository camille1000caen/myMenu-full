package sopra.myMenubackEnd.rest;

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

import sopra.myMenubackEnd.model.Plat;
import sopra.myMenubackEnd.model.Repas;
import sopra.myMenubackEnd.model.TypeRepas;
import sopra.myMenubackEnd.model.Views;
import sopra.myMenubackEnd.repository.IPlatRepository;
@RestController
	@RequestMapping("/plat")
	@CrossOrigin("*")
public class PlatRestController {
	

		@Autowired
		private IPlatRepository platRepo;
		
		@GetMapping("")
		@JsonView(Views.ViewPlat.class)
		public List<Plat>  findAll(){
			List<Plat> plats = platRepo.findAll();
			
			return plats;
		}
		@GetMapping("/by-repas/{id}")
		@JsonView(Views.ViewPlat.class)
		public List<Plat> findAllByRepas(@PathVariable Long id) {
				
			return platRepo.findAllByRepas(id);

		}
		
		@GetMapping("/by-typerepas/{typerepas}")
		@JsonView(Views.ViewPlat.class)
		public List<Plat> findAllWithRepasByTypeRepas(@PathVariable TypeRepas typeRepas) {
				
			return platRepo.findAllWithRepasByTypeRepas(typeRepas);

		}
		@GetMapping("/{id}")
		@JsonView(Views.ViewPlat.class)
		
		public Plat find(@PathVariable Long id) {
			
			Optional<Plat> optPlat = platRepo.findById(id);
			
			if(optPlat.isPresent()) {
				return optPlat.get();
			}else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
			}
			}
			
		
		@GetMapping("/detailrepas")
		@JsonView(Views.ViewPlatDetail.class)
		public List<Plat> findAllWithRepas() {
				
			return platRepo.findAllWithRepas();
		}
		
		@PostMapping("")
		//@PreAuthorize("hasRole('ADMIN')")
		@JsonView(Views.ViewPlat.class)
		public Plat create(@RequestBody Plat plat) {
			plat = platRepo.save(plat);

			return plat;
		}

		@PutMapping("/{id}")
		//@PreAuthorize("hasRole('ADMIN')")
		@JsonView(Views.ViewPlat.class)
		public Plat update(@RequestBody Plat plat, @PathVariable Long id) {
			if (!platRepo.existsById(id)) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
			}

			plat = platRepo.save(plat);

			return plat;
		}

		@DeleteMapping("/{id}")
		//@PreAuthorize("hasRole('ADMIN')")
		public void delete(@PathVariable Long id) {
			platRepo.deleteById(id);
		}
	}

		
		
		
		
		
		


