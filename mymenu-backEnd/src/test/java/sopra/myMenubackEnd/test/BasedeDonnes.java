package sopra.myMenubackEnd.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.myMenubackEnd.model.Ingredient;
import sopra.myMenubackEnd.model.Plat;
import sopra.myMenubackEnd.model.Recette;
import sopra.myMenubackEnd.model.Repas;
import sopra.myMenubackEnd.model.TypeAlimentation;
import sopra.myMenubackEnd.model.TypeRepas;
import sopra.myMenubackEnd.repository.IIngredientRepository;
import sopra.myMenubackEnd.repository.IPlatRepository;
import sopra.myMenubackEnd.repository.IRecetteRepository;
import sopra.myMenubackEnd.repository.IRepasRepository;

@SpringBootTest
public class BasedeDonnes {
	
	@Autowired
	private IIngredientRepository ingredientRepo;
	@Autowired
	private IPlatRepository platRepo;
	@Autowired
	private IRecetteRepository recetteRepo;
	@Autowired
	private IRepasRepository repasRepo;
	
//plat1 avec recettes1 et tous ses ingédients
	@Test
	public void BaseDeDonnees(){
	Recette recette1=new Recette();
//	recette1.setEtapes("Faire fondre le beurre dans une poele Melanger les oeufs le lait et le sucre Tremper la brioche dans ce melange et les faire revenir dans le beurre Faire chauffer doucement la creme et ajouter le caramel Laisser epaissir Dresser la tranche de brioche dans une assiette avec une boule de glace et la sauce au caramel");
	recette1.setEtapes("Faire");
	
	recette1.setNom("Brioche perdue au caramel");
	recette1.setNombrePers(4);
	recette1.setNote(4.7F);
	recette1.setTypeAlimentation(TypeAlimentation.NONE);
	recette1=recetteRepo.save(recette1);
	
	
	Ingredient ingredient11=new Ingredient("lait",500);//ingredient1 recette1
	ingredient11=ingredientRepo.save(ingredient11);
	Ingredient ingredient12=new Ingredient("sucre",60);//ingredient2 recette1
	ingredient12=ingredientRepo.save(ingredient12);
	Ingredient ingredient13=new Ingredient("brioche",100);
	ingredient13=ingredientRepo.save(ingredient13);
	Ingredient ingredient14=new Ingredient("oeuf",70);
	ingredient14=ingredientRepo.save(ingredient14);
	Ingredient ingredient15=new Ingredient("glace caramel au beurre salé",100);
	ingredient15=ingredientRepo.save(ingredient15);
	Ingredient ingredient16=new Ingredient("crème épaisse",190);
	ingredient16=ingredientRepo.save(ingredient16);
	Ingredient ingredient17=new Ingredient("caramel",50);
	ingredient17=ingredientRepo.save(ingredient17);
	Ingredient ingredient18=new Ingredient("beurre",25);
	ingredient18=ingredientRepo.save(ingredient18);
	List<Ingredient> ingredients1=new ArrayList<Ingredient>();
	ingredients1.add(ingredient11);
	ingredients1.add(ingredient12);
	ingredients1.add(ingredient13);
	ingredients1.add(ingredient14);
	ingredients1.add(ingredient15);
	ingredients1.add(ingredient16);
	ingredients1.add(ingredient17);
	ingredients1.add(ingredient18);
	recette1.setIngredients(ingredients1);
	recette1=recetteRepo.save(recette1);
	
	Repas repas1=new Repas();
	repas1.setTypeRepas(TypeRepas.PETIT_DEJ);
	repas1=repasRepo.save(repas1);
	
	Plat plat1=new Plat();
	plat1.setNombrePersonne(4);
	plat1.setRecette(recette1);
	plat1.setRepas(repas1);
	plat1 = platRepo.save(plat1);
	}
}
