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

import sopra.myMenubackEnd.model.Menu;
import sopra.myMenubackEnd.model.Views;
import sopra.myMenubackEnd.repository.IMenuRepository;

@RestController
@RequestMapping("/menu")
@CrossOrigin("*")
public class MenuRestController {

		@Autowired
		private IMenuRepository menuRepo;

		@GetMapping("")
		@JsonView(Views.ViewMenu.class)
		public List<Menu> findAll() {
			return menuRepo.findAll();
		}
		
		@GetMapping("/{id}")
		@JsonView(Views.ViewMenu.class)
		public Menu find(@PathVariable Long id) {

			Optional<Menu> optMenu = menuRepo.findById(id);

			if (optMenu.isPresent()) {
				return optMenu.get();
			} else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
			}
		}
		
		@GetMapping("/{id}/detail-planning")
		@JsonView(Views.ViewMenuWithPlanning.class)
		public Menu findByIdWithPlanning(@PathVariable Long id) {

			Optional<Menu> optMenu = menuRepo.findMenuByIdWithPlanning(id);

			if (optMenu.isPresent()) {
				return optMenu.get();
			} else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
			}
		}
		
		@GetMapping("/by-planning/{idPlanning}")
		@JsonView(Views.ViewMenu.class)
		public List<Menu> findAllByPlanning(@PathVariable Long idObjectif) {

			List<Menu> menus = menuRepo.findAllMenusByPlanning(idObjectif);

			return menus;
		}
		
					
		@GetMapping("/with-planning")
		@JsonView(Views.ViewMenuWithPlanning.class)
		public List<Menu> findAllWithPlanning() {

			List<Menu> menus = menuRepo.findAllMenusWithPlanning();

			return menus;
		}
		
		@PostMapping("")
		//@PreAuthorize("hasRole('ADMIN')")
		@JsonView(Views.ViewListeCourse.class)
		public Menu create(@Valid @RequestBody Menu menu, BindingResult result) {
			if (result.hasErrors()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erreur validation");
			}

			menu = menuRepo.save(menu);

			return menu;
		}
		
		@PutMapping("/{id}")
		//@PreAuthorize("hasRole('ADMIN')")
		@JsonView(Views.ViewMenu.class)
		public Menu update(@RequestBody Menu menu, @PathVariable Long id) {
			if (!menuRepo.existsById(id)) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
			}

			menu = menuRepo.save(menu);

			return menu;
		}
		
		@DeleteMapping("/{id}")
		//@PreAuthorize("hasRole('ADMIN')")
		public void delete(@PathVariable Long id) {
			menuRepo.deleteById(id);
		}
		
	}

