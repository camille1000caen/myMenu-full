package sopra.myMenubackEnd.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sopra.myMenubackEnd.model.Genre;
import sopra.myMenubackEnd.model.PhysicalActivity;
import sopra.myMenubackEnd.model.ProduitSaison;
import sopra.myMenubackEnd.model.TypeAlimentation;
import sopra.myMenubackEnd.model.TypeObjectif;
import sopra.myMenubackEnd.model.TypeProduit;
import sopra.myMenubackEnd.model.TypeRepas;

@RestController
@RequestMapping("/rest")
@CrossOrigin("*")
public class CommonRestController {

	@GetMapping("/genre")
	public Genre[] getGenre() {
		return Genre.values();
	}
	
	@GetMapping("/physicalactivity")
	public PhysicalActivity[] getPhysicalActivity() {
		return PhysicalActivity.values();
	}
	
	@GetMapping("/produitsaison")
	public ProduitSaison[] getProduitSaison() {
		return ProduitSaison.values();
	}
	
	@GetMapping("/typealimentation")
	public TypeAlimentation[] getTypeAlimentation() {
		return TypeAlimentation.values();
	}
	
	@GetMapping("/typeobjectif")
	public TypeObjectif[] getTypeObjectif() {
		return TypeObjectif.values();
	}
	
	@GetMapping("/typeproduit")
	public TypeProduit[] getTypeProduit() {
		return TypeProduit.values();
	}
	
	@GetMapping("/typerepas")
	public TypeRepas[] getTypeRepas() {
		return TypeRepas.values();
	}
	
}