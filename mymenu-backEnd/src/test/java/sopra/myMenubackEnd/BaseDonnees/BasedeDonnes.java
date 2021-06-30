package sopra.myMenubackEnd.BaseDonnees;

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
	
	
/********************************************************************************************************************	
*************************************Petit Dej **********************************************************************	1
********************************************************************************************************************/	
	
//plat1 avec recettes1 et tous ses ingédients
	@Test
	public void BriochePerdueCaramel(){
	Recette recette1=new Recette();
	recette1.setEtapes("ÉTAPE 1\r\n"
			+ "Faire fondre le beurre dans une poêle.\r\n"
			+ "\r\n"
			+ "ÉTAPE 2\r\n"
			+ "Mélanger les oeufs, le lait et le sucre. Tremper la brioche dans ce mélange et les faire revenir dans le beurre.\r\n"
			+ "\r\n"
			+ "ÉTAPE 3\r\n"
			+ "Faire chauffer doucement la crème et ajouter le caramel. Laisser épaissir.\r\n"
			+ "\r\n"
			+ "ÉTAPE 4\r\n"
			+ "Dresser la tranche de brioche dans une assiette avec une boule de glace et la sauce au caramel.");
	recette1.setNom("Brioche perdue au caramel");
	recette1.setNombrePers(4);
	recette1.setNote(4.7F);
//	List<TypeAlimentation> typesAlim=new ArrayList<TypeAlimentation>();
//	typesAlim.add(TypeAlimentation.NONE);
//	typesAlim.add(TypeAlimentation.VEGAN);
//	typesAlim.add(TypeAlimentation.HALAL);
//	typesAlim.add(TypeAlimentation.VEGETARIEN);
//	recette1.setTypeAlimentation(typesAlim);
	recette1.setTypeAlimentation(TypeAlimentation.VEGETARIEN);
	recette1=recetteRepo.save(recette1);
	List<Recette> listRecettes1 = new ArrayList<Recette>();
	listRecettes1.add(recette1);	
	recette1.setPhoto("../../assets/images/briochePerdueCaramel.jpg");
	recette1=recetteRepo.save(recette1);
	
	Ingredient ingredient1=new Ingredient("lait",500);//ingredient1 recette1
	ingredient1.setRecettes(listRecettes1);
	ingredient1=ingredientRepo.save(ingredient1);
	Ingredient ingredient2=new Ingredient("sucre",60);//ingredient2 recette1
	ingredient2.setRecettes(listRecettes1);
	ingredient2=ingredientRepo.save(ingredient2);
	Ingredient ingredient3=new Ingredient("brioche",100);
	ingredient3.setRecettes(listRecettes1);
	ingredient3=ingredientRepo.save(ingredient3);
	Ingredient ingredient4=new Ingredient("oeuf",70);
	ingredient4.setRecettes(listRecettes1);
	ingredient4=ingredientRepo.save(ingredient4);
	Ingredient ingredient5=new Ingredient("glace caramel au beurre salé",100);
	ingredient5.setRecettes(listRecettes1);
	ingredient5=ingredientRepo.save(ingredient5);
	Ingredient ingredient6=new Ingredient("crème épaisse",190);
	ingredient6.setRecettes(listRecettes1);
	ingredient6=ingredientRepo.save(ingredient6);
	Ingredient ingredient7=new Ingredient("caramel",50);
	ingredient7.setRecettes(listRecettes1);
	ingredient7=ingredientRepo.save(ingredient7);
	Ingredient ingredient8=new Ingredient("beurre",25);
	ingredient8.setRecettes(listRecettes1);
	ingredient8=ingredientRepo.save(ingredient8);
	Ingredient ingredient9=new Ingredient("beurre",25);
	ingredient9.setRecettes(listRecettes1);
	ingredient9=ingredientRepo.save(ingredient9);
	
	
	
	List<Ingredient> ingredients1=new ArrayList<Ingredient>();
	ingredients1.add(ingredient1);
	
	ingredients1.add(ingredient2);
	ingredient2.setRecettes(listRecettes1);
	ingredients1.add(ingredient3);
	ingredient3.setRecettes(listRecettes1);
	ingredients1.add(ingredient4);
	ingredient4.setRecettes(listRecettes1);
	ingredients1.add(ingredient5);
	ingredient5.setRecettes(listRecettes1);
	ingredients1.add(ingredient6);
	ingredient6.setRecettes(listRecettes1);
	ingredients1.add(ingredient7);
	ingredient7.setRecettes(listRecettes1);
	ingredients1.add(ingredient8);
	ingredient8.setRecettes(listRecettes1);
	ingredients1.add(ingredient9);
	ingredient9.setRecettes(listRecettes1);
	recette1.setIngredients(ingredients1);
	recette1=recetteRepo.save(recette1);
	
	Repas repas1=new Repas();
	repas1.setTypeRepas(TypeRepas.PETIT_DEJ);
	repas1=repasRepo.save(repas1);
	
	Plat plat1=new Plat();
	plat1.setNombrePersonne(6);
	//plat1.setRecettes(listRecettes1);
	recette1.setPlat(plat1);
	plat1.setRepas(repas1);
	plat1 = platRepo.save(plat1);
	recette1=recetteRepo.save(recette1);
	}
	
	/********************************************************************************************************************	
	********************************************************************************************************************	2
	********************************************************************************************************************/	
	
	@Test
	public void BiscuitCereal(){
	Recette recette1=new Recette();
	recette1.setEtapes("ÉTAPE 1\r\n"
			+ "Dans une jatte, pétrissez tous les ingrédients ensemble jusqu'à obtenir une boule de pâte.\r\n"
			+ "\r\n"
			+ "ÉTAPE 2\r\n"
			+ "Si vous souhaitez faire différents biscuits avec cette même pâte, ne mettez pas les ingrédients optionnels.\r\n"
			+ "\r\n"
			+ "ÉTAPE 3\r\n"
			+ "Enveloppez la pâte dans du film transparent et mettre au frigo pour une dizaine de minutes au moins.\r\n"
			+ "\r\n"
			+ "ÉTAPE 4\r\n"
			+ "Préchauffez votre four à 200°C et placez du papier sulfurisé sur une plaque de cuisson.\r\n"
			+ "\r\n"
			+ "ÉTAPE 5\r\n"
			+ "Sortez la pâte du frigo et, si vous le souhaitez, séparez la pâte en plusieurs parts pour y ajouter les ingrédients optionnels.\r\n"
			+ "\r\n"
			+ "ÉTAPE 6\r\n"
			+ "Formez de petites boules de pâtes que vous écraserez dans la paume avant de placer sur la plaque.\r\n"
			+ "\r\n"
			+ "ÉTAPE 7\r\n"
			+ "Placez au four pour environ 10 minutes, selon votre four. Restez à proximité des biscuits. Ils doivent être à peine dorés pour restez moelleux ou bien dorés pour être un peu plus croquants.");
	recette1.setNom("Biscuits aux céréales");
	recette1.setNombrePers(6);
	recette1.setNote(4.6F);

	recette1.setTypeAlimentation(TypeAlimentation.NONE);
	recette1=recetteRepo.save(recette1);
	List<Recette> listRecettes1 = new ArrayList<Recette>();
	listRecettes1.add(recette1);	
	recette1.setPhoto("../../assets/images/biscuit_cereals.jpg");
	recette1=recetteRepo.save(recette1);
	
	
	
	Ingredient ingredient1=new Ingredient("farine",150);//ingredient1 recette1
	ingredient1.setRecettes(listRecettes1);
	ingredient1=ingredientRepo.save(ingredient1);
	Ingredient ingredient2=new Ingredient("sucre",50);//ingredient2 recette1
	ingredient2.setRecettes(listRecettes1);
	ingredient2=ingredientRepo.save(ingredient2);
	Ingredient ingredient3=new Ingredient("miel",50);
	ingredient3.setRecettes(listRecettes1);
	ingredient3=ingredientRepo.save(ingredient3);
	Ingredient ingredient4=new Ingredient("sachet sucre vanille",10);
	ingredient4.setRecettes(listRecettes1);
	ingredient4=ingredientRepo.save(ingredient4);
	Ingredient ingredient5=new Ingredient("flocons d'avoine",80);
	ingredient5.setRecettes(listRecettes1);
	ingredient5=ingredientRepo.save(ingredient5);
	Ingredient ingredient6=new Ingredient("amande",100);
	ingredient6.setRecettes(listRecettes1);
	ingredient6=ingredientRepo.save(ingredient6);
	Ingredient ingredient7=new Ingredient("farine complete",150);
	ingredient7.setRecettes(listRecettes1);
	ingredient7=ingredientRepo.save(ingredient7);
	Ingredient ingredient8=new Ingredient("oeuf",1);
	ingredient8.setRecettes(listRecettes1);
	ingredient8=ingredientRepo.save(ingredient8);
	Ingredient ingredient9=new Ingredient("beurre",100);
	ingredient9.setRecettes(listRecettes1);
	ingredient9=ingredientRepo.save(ingredient9);
	Ingredient ingredient10=new Ingredient("yaourt",100);
	ingredient10.setRecettes(listRecettes1);
	ingredient10=ingredientRepo.save(ingredient10);
	Ingredient ingredient11=new Ingredient("vanille",20);
	ingredient11.setRecettes(listRecettes1);
	ingredient11=ingredientRepo.save(ingredient11);
			
	
	List<Ingredient> ingredients1=new ArrayList<Ingredient>();
	ingredients1.add(ingredient1);
	
	ingredients1.add(ingredient2);
	ingredient2.setRecettes(listRecettes1);
	ingredients1.add(ingredient3);
	ingredient3.setRecettes(listRecettes1);
	ingredients1.add(ingredient4);
	ingredient4.setRecettes(listRecettes1);
	ingredients1.add(ingredient5);
	ingredient5.setRecettes(listRecettes1);
	ingredients1.add(ingredient6);
	ingredient6.setRecettes(listRecettes1);
	ingredients1.add(ingredient7);
	ingredient7.setRecettes(listRecettes1);
	ingredients1.add(ingredient8);
	ingredient8.setRecettes(listRecettes1);
	ingredients1.add(ingredient9);
	ingredient9.setRecettes(listRecettes1);
	ingredients1.add(ingredient10);
	ingredient10.setRecettes(listRecettes1);
	ingredients1.add(ingredient11);
	ingredient11.setRecettes(listRecettes1);
	
	recette1.setIngredients(ingredients1);
	recette1=recetteRepo.save(recette1);
	
	Repas repas1=new Repas();
	repas1.setTypeRepas(TypeRepas.PETIT_DEJ);
	repas1=repasRepo.save(repas1);
	
	Plat plat1=new Plat();
	plat1.setNombrePersonne(6);
	//plat1.setRecettes(listRecettes1);
	recette1.setPlat(plat1);
	plat1.setRepas(repas1);
	plat1 = platRepo.save(plat1);
	recette1=recetteRepo.save(recette1);
	}
	
	/********************************************************************************************************************	
	********************************************************************************************************************	3
	********************************************************************************************************************/
	@Test
	public void EnglishBreakfast(){
	Recette recette1=new Recette();
	recette1.setEtapes("Etapes\r\n"
			+ "ÉTAPE 1\r\n"
			+ "- Couper les champignons en tranches et les faire revenir dans une poêle avec un peu de beurre, à feu moyen. Saler, poivrer.\r\n"
			+ "\r\n"
			+ "ÉTAPE 2\r\n"
			+ "- Pendant ce temps, faire cuire le bacon dans une grande poêle, et mettre le pain à toaster.\r\n"
			+ "\r\n"
			+ "ÉTAPE 3\r\n"
			+ "- Rajouter dans la poêle les oeufs (au plat), saler, poivrer.\r\n"
			+ "\r\n"
			+ "ÉTAPE 4\r\n"
			+ "Réchauffer les haricots au micro-ondes (2 min, en remuant à mi-temps) et beurrer les tranches de pain que l'on coupera en diagonale.\r\n"
			+ "\r\n"
			+ "ÉTAPE 5\r\n"
			+ "- Disposer tous les ingrédients dans une grande assiette: c'est prêt!");
	recette1.setNom("English Breakfast");
	recette1.setNombrePers(2);
	recette1.setNote(5F);
//	List<TypeAlimentation> typesAlim=new ArrayList<TypeAlimentation>();
//	typesAlim.add(TypeAlimentation.NONE);
//	typesAlim.add(TypeAlimentation.VEGAN);
//	typesAlim.add(TypeAlimentation.HALAL);
//	typesAlim.add(TypeAlimentation.VEGETARIEN);
//	recette1.setTypeAlimentation(typesAlim);
	recette1.setTypeAlimentation(TypeAlimentation.NONE);
	recette1=recetteRepo.save(recette1);
	List<Recette> listRecettes1 = new ArrayList<Recette>();
	listRecettes1.add(recette1);	
	recette1.setPhoto("../../assets/images/english_breakfast.jpg");
	recette1=recetteRepo.save(recette1);
	
	Ingredient ingredient1=new Ingredient("pain",120);//ingredient1 recette1
	ingredient1.setRecettes(listRecettes1);
	ingredient1=ingredientRepo.save(ingredient1);
	Ingredient ingredient2=new Ingredient("champignons",300);//ingredient2 recette1
	ingredient2.setRecettes(listRecettes1);
	ingredient2=ingredientRepo.save(ingredient2);
	Ingredient ingredient3=new Ingredient("bacon",100);
	ingredient3.setRecettes(listRecettes1);
	ingredient3=ingredientRepo.save(ingredient3);
	Ingredient ingredient4=new Ingredient("oeuf",4);
	ingredient4.setRecettes(listRecettes1);
	ingredient4=ingredientRepo.save(ingredient4);
	Ingredient ingredient5=new Ingredient("haricots",200);
	ingredient5.setRecettes(listRecettes1);
	ingredient5=ingredientRepo.save(ingredient5);
	Ingredient ingredient6=new Ingredient("beurre",50);
	ingredient6.setRecettes(listRecettes1);
	ingredient6=ingredientRepo.save(ingredient6);
		
	
	List<Ingredient> ingredients1=new ArrayList<Ingredient>();
	ingredients1.add(ingredient1);
	
	ingredients1.add(ingredient2);
	ingredient2.setRecettes(listRecettes1);
	ingredients1.add(ingredient3);
	ingredient3.setRecettes(listRecettes1);
	ingredients1.add(ingredient4);
	ingredient4.setRecettes(listRecettes1);
	ingredients1.add(ingredient5);
	ingredient5.setRecettes(listRecettes1);
	ingredients1.add(ingredient6);
	ingredient6.setRecettes(listRecettes1);
	
	recette1.setIngredients(ingredients1);
	recette1=recetteRepo.save(recette1);
	
	Repas repas1=new Repas();
	repas1.setTypeRepas(TypeRepas.PETIT_DEJ);
	repas1=repasRepo.save(repas1);
	
	Plat plat1=new Plat();
	plat1.setNombrePersonne(6);
	//plat1.setRecettes(listRecettes1);
	recette1.setPlat(plat1);
	plat1.setRepas(repas1);
	plat1 = platRepo.save(plat1);
	recette1=recetteRepo.save(recette1);
	}
	
	/********************************************************************************************************************	
	********************************************************************************************************************	4
	*******************************************************************************************************************/
	@Test
	public void CrumbleFruitSec(){
	Recette recette1=new Recette();
	recette1.setEtapes("ÉTAPE 1\r\n"
			+ "Préchauffez le four à 170°C (thermostat 5-6).\r\n"
			+ "\r\n"
			+ "ÉTAPE 2\r\n"
			+ "Préparez le crumble en mélangeant l'oeuf, le sucre, la farine, le beurre mou\r et le sel. Le tout doit s'émietter.\r\n"
			+ "\r\n"
			+ "ÉTAPE 3\r\n"
			+ "Etalez sur une plaque tapissée de papier sulfurisé par petites miettes ou \r amas plus ou moins gros (ajoutez un peu de farine si c'est trop pâteux).\r\n"
			+ "\r\n"
			+ "ÉTAPE 4\r\n"
			+ "Enfournez pendant 13 minutes en surveillant la cuisson : le crumble doit \r être bien doré et croustillant sur le dessus.\r\n"
			+ "\r\n"
			+ "ÉTAPE 5\r\n"
			+ "Mélangez tous les autres ingrédients et ajoutez le crumble cuit en miettes, \r une fois bien refroidi (pour que le chocolat ne fonde pas).\r\n"
			+ "\r\n"
			+ "ÉTAPE 6\r\n"
			+ "A servir au petit-déjeuner avec du lait.");
	recette1.setNom("Crumble fruit sec");
	recette1.setNombrePers(6);
	recette1.setNote(5F);
//	List<TypeAlimentation> typesAlim=new ArrayList<TypeAlimentation>();
//	typesAlim.add(TypeAlimentation.NONE);
//	typesAlim.add(TypeAlimentation.VEGAN);
//	typesAlim.add(TypeAlimentation.HALAL);
//	typesAlim.add(TypeAlimentation.VEGETARIEN);
//	recette1.setTypeAlimentation(typesAlim);
	recette1.setTypeAlimentation(TypeAlimentation.NONE);
	recette1=recetteRepo.save(recette1);
	List<Recette> listRecettes1 = new ArrayList<Recette>();
	listRecettes1.add(recette1);	
	recette1.setPhoto("../../assets/images/crumble_fruit_sec.jpg");
	recette1=recetteRepo.save(recette1);
	
	Ingredient ingredient1=new Ingredient("farine",200);//ingredient1 recette1
	ingredient1.setRecettes(listRecettes1);
	ingredient1=ingredientRepo.save(ingredient1);
	Ingredient ingredient2=new Ingredient("sucre",100);//ingredient2 recette1
	ingredient2.setRecettes(listRecettes1);
	ingredient2=ingredientRepo.save(ingredient2);
	Ingredient ingredient3=new Ingredient("chocolat",50);
	ingredient3.setRecettes(listRecettes1);
	ingredient3=ingredientRepo.save(ingredient3);
	Ingredient ingredient4=new Ingredient("raisin sec",100);
	ingredient4.setRecettes(listRecettes1);
	ingredient4=ingredientRepo.save(ingredient4);
	Ingredient ingredient5=new Ingredient("cannelle",10);
	ingredient5.setRecettes(listRecettes1);
	ingredient5=ingredientRepo.save(ingredient5);
	Ingredient ingredient6=new Ingredient("beurre",75);
	ingredient6.setRecettes(listRecettes1);
	ingredient6=ingredientRepo.save(ingredient6);
	Ingredient ingredient7=new Ingredient("sel",5);
	ingredient7.setRecettes(listRecettes1);
	ingredient7=ingredientRepo.save(ingredient7);
	Ingredient ingredient8=new Ingredient("oeuf",1);
	ingredient8.setRecettes(listRecettes1);
	ingredient8=ingredientRepo.save(ingredient8);
	Ingredient ingredient9=new Ingredient("avoine",60);
	ingredient9.setRecettes(listRecettes1);
	ingredient9=ingredientRepo.save(ingredient9);
	Ingredient ingredient10=new Ingredient("cranberries",100);
	ingredient10.setRecettes(listRecettes1);
	ingredient10=ingredientRepo.save(ingredient10);
		
	
	List<Ingredient> ingredients1=new ArrayList<Ingredient>();
	ingredients1.add(ingredient1);
	
	ingredients1.add(ingredient2);
	ingredient2.setRecettes(listRecettes1);
	ingredients1.add(ingredient3);
	ingredient3.setRecettes(listRecettes1);
	ingredients1.add(ingredient4);
	ingredient4.setRecettes(listRecettes1);
	ingredients1.add(ingredient5);
	ingredient5.setRecettes(listRecettes1);
	ingredients1.add(ingredient6);
	ingredient6.setRecettes(listRecettes1);
	
	recette1.setIngredients(ingredients1);
	recette1=recetteRepo.save(recette1);
	
	Repas repas1=new Repas();
	repas1.setTypeRepas(TypeRepas.PETIT_DEJ);
	repas1=repasRepo.save(repas1);
	
	Plat plat1=new Plat();
	plat1.setNombrePersonne(6);
	//plat1.setRecettes(listRecettes1);
	recette1.setPlat(plat1);
	plat1.setRepas(repas1);
	plat1 = platRepo.save(plat1);
	recette1=recetteRepo.save(recette1);
	}
	
	/********************************************************************************************************************	
	********************************************************************************************************************	5
	********************************************************************************************************************/
	
	@Test
	public void Pancake(){
	Recette recette1=new Recette();
	recette1.setEtapes("ÉTAPE 1\r\n"
			+ "Faire fondre le beurre, dans une casserole à feu doux ou dans un bol au \r micro-ondes.\r\n"
			+ "\r\n"
			+ "ÉTAPE 2\r\n"
			+ "Mettre la farine, la levure et le sucre dans un saladier. Mélanger et \r creuser un puits.\r\n"
			+ "\r\n"
			+ "ÉTAPE 3\r\n"
			+ "Ajouter ensuite les oeufs entiers et fouetter l'ensemble.\r\n"
			+ "\r\n"
			+ "ÉTAPE 4\r\n"
			+ "Incorporer le beurre fondu, fouetter puis délayer progressivement le \r mélange avec le lait afin d'éviter les grumeaux.\r\n"
			+ "\r\n"
			+ "ÉTAPE 5\r\n"
			+ "Laisser reposer la pâte au minimum 1 heure au réfrigérateur.\r\n"
			+ "\r\n"
			+ "ÉTAPE 6\r\n"
			+ "Dans une poêle chaude et légèrement huilée, faire cuire comme des crêpes, mais en les faisant plus petites. Réserver au chaud et déguster.");
	recette1.setNom("Pancake");
	recette1.setNombrePers(4);
	recette1.setNote(4.8F);
//	List<TypeAlimentation> typesAlim=new ArrayList<TypeAlimentation>();
//	typesAlim.add(TypeAlimentation.NONE);
//	typesAlim.add(TypeAlimentation.VEGAN);
//	typesAlim.add(TypeAlimentation.HALAL);
//	typesAlim.add(TypeAlimentation.VEGETARIEN);
//	recette1.setTypeAlimentation(typesAlim);
	recette1.setTypeAlimentation(TypeAlimentation.NONE);
	recette1=recetteRepo.save(recette1);
	List<Recette> listRecettes1 = new ArrayList<Recette>();
	listRecettes1.add(recette1);	
	recette1.setPhoto("../../assets/images/pancakes.jpg");
	recette1=recetteRepo.save(recette1);
	
	Ingredient ingredient1=new Ingredient("farine",200);//ingredient1 recette1
	ingredient1.setRecettes(listRecettes1);
	ingredient1=ingredientRepo.save(ingredient1);
	Ingredient ingredient2=new Ingredient("sucre",100);//ingredient2 recette1
	ingredient2.setRecettes(listRecettes1);
	ingredient2=ingredientRepo.save(ingredient2);
	Ingredient ingredient3=new Ingredient("chocolat",50);
	ingredient3.setRecettes(listRecettes1);
	ingredient3=ingredientRepo.save(ingredient3);
	Ingredient ingredient4=new Ingredient("raisin sec",100);
	ingredient4.setRecettes(listRecettes1);
	ingredient4=ingredientRepo.save(ingredient4);
	Ingredient ingredient5=new Ingredient("cannelle",10);
	ingredient5.setRecettes(listRecettes1);
	ingredient5=ingredientRepo.save(ingredient5);
	Ingredient ingredient6=new Ingredient("beurre",75);
	ingredient6.setRecettes(listRecettes1);
	ingredient6=ingredientRepo.save(ingredient6);
	Ingredient ingredient7=new Ingredient("sel",5);
	ingredient7.setRecettes(listRecettes1);
	ingredient7=ingredientRepo.save(ingredient7);
	Ingredient ingredient8=new Ingredient("oeuf",1);
	ingredient8.setRecettes(listRecettes1);
	ingredient8=ingredientRepo.save(ingredient8);
	Ingredient ingredient9=new Ingredient("avoine",60);
	ingredient9.setRecettes(listRecettes1);
	ingredient9=ingredientRepo.save(ingredient9);
	Ingredient ingredient10=new Ingredient("cranberries",100);
	ingredient10.setRecettes(listRecettes1);
	ingredient10=ingredientRepo.save(ingredient10);
		
	
	List<Ingredient> ingredients1=new ArrayList<Ingredient>();
	ingredients1.add(ingredient1);
	
	ingredients1.add(ingredient2);
	ingredient2.setRecettes(listRecettes1);
	ingredients1.add(ingredient3);
	ingredient3.setRecettes(listRecettes1);
	ingredients1.add(ingredient4);
	ingredient4.setRecettes(listRecettes1);
	ingredients1.add(ingredient5);
	ingredient5.setRecettes(listRecettes1);
	ingredients1.add(ingredient6);
	ingredient6.setRecettes(listRecettes1);
	
	recette1.setIngredients(ingredients1);
	recette1=recetteRepo.save(recette1);
	
	Repas repas1=new Repas();
	repas1.setTypeRepas(TypeRepas.PETIT_DEJ);
	repas1=repasRepo.save(repas1);
	
	Plat plat1=new Plat();
	plat1.setNombrePersonne(6);
	//plat1.setRecettes(listRecettes1);
	recette1.setPlat(plat1);
	plat1.setRepas(repas1);
	plat1 = platRepo.save(plat1);
	recette1=recetteRepo.save(recette1);
	}
	/********************************************************************************************************************	
	********************************************************************************************************************	6
	********************************************************************************************************************/
	@Test
	public void Smoothie(){
	Recette recette1=new Recette();
	recette1.setEtapes("ÉTAPE 1\r\n"
			+ "mettre dans un mixer les bananes coupées en morceaux et la chair des kiwis.\r\n"
			+ "ÉTAPE 2\r\n"
			+ "Presser les oranges et rajouter le jus dans le mixer.\r\n"
			+ "ÉTAPE 3\r\n"
			+ "Rajouter le lait de soja (il peut être nature ou vanillé).");
	recette1.setNom("Smoothie");
	recette1.setNombrePers(2);
	recette1.setNote(4.7F);
//	List<TypeAlimentation> typesAlim=new ArrayList<TypeAlimentation>();
//	typesAlim.add(TypeAlimentation.NONE);
//	typesAlim.add(TypeAlimentation.VEGAN);
//	typesAlim.add(TypeAlimentation.HALAL);
//	typesAlim.add(TypeAlimentation.VEGETARIEN);
//	recette1.setTypeAlimentation(typesAlim);
	recette1.setTypeAlimentation(TypeAlimentation.NONE);
	recette1=recetteRepo.save(recette1);
	List<Recette> listRecettes1 = new ArrayList<Recette>();
	listRecettes1.add(recette1);	
	recette1.setPhoto("../../assets/images/smoothie.jpg");
	recette1=recetteRepo.save(recette1);
	
	Ingredient ingredient1=new Ingredient("lait de soja",200);//ingredient1 recette1
	ingredient1.setRecettes(listRecettes1);
	ingredient1=ingredientRepo.save(ingredient1);
	Ingredient ingredient2=new Ingredient("banane",200);//ingredient2 recette1
	ingredient2.setRecettes(listRecettes1);
	ingredient2=ingredientRepo.save(ingredient2);
	Ingredient ingredient3=new Ingredient("orange",200);
	ingredient3.setRecettes(listRecettes1);
	ingredient3=ingredientRepo.save(ingredient3);
	Ingredient ingredient4=new Ingredient("kiwi",100);
	ingredient4.setRecettes(listRecettes1);
	ingredient4=ingredientRepo.save(ingredient4);
	
	
	List<Ingredient> ingredients1=new ArrayList<Ingredient>();
	ingredients1.add(ingredient1);
	
	ingredients1.add(ingredient2);
	ingredient2.setRecettes(listRecettes1);
	ingredients1.add(ingredient3);
	ingredient3.setRecettes(listRecettes1);
	ingredients1.add(ingredient4);
	ingredient4.setRecettes(listRecettes1);
	
	recette1.setIngredients(ingredients1);
	recette1=recetteRepo.save(recette1);
	
	Repas repas1=new Repas();
	repas1.setTypeRepas(TypeRepas.PETIT_DEJ);
	repas1=repasRepo.save(repas1);
	
	Plat plat1=new Plat();
	plat1.setNombrePersonne(6);
	//plat1.setRecettes(listRecettes1);
	recette1.setPlat(plat1);
	plat1.setRepas(repas1);
	plat1 = platRepo.save(plat1);
	recette1=recetteRepo.save(recette1);
	}
	
	/********************************************************************************************************************	
	********************************************************************************************************************	7
	********************************************************************************************************************/
	@Test
	public void Crepes(){
	Recette recette1=new Recette();
	recette1.setEtapes("ÉTAPE 1\r\n"
			+ "Mettre la farine dans une terrine et former un puits.\r\n"
			+ "ÉTAPE 2\r\n"
			+ "Y déposer les oeufs entiers, le sucre, l'huile et le beurre.\r\n"
			+ "ÉTAPE 3\r\n"
			+ "Mélanger délicatement avec un fouet en ajoutant au fur et à mesure le lait.\r La pâte ainsi obtenue doit avoir une consistance d'un liquide légèrement épais."
			+ "ÉTAPE 4\r\n"
			+ "Parfumer de rhum.\r\n"
			+ "ÉTAPE 5\r\n"
			+ "Faire chauffer une poêle antiadhésive et la huiler très légèrement.\r Y verser une louche de pâte, la répartir dans la poêle puis attendre qu'elle soit cuite d'un côté avant de la retourner.\r Cuire ainsi toutes les crêpes à feu doux.\r\n"
			);
	recette1.setNom("Crêpes");
	recette1.setNombrePers(2);
	recette1.setNote(4.8F);
//	List<TypeAlimentation> typesAlim=new ArrayList<TypeAlimentation>();
//	typesAlim.add(TypeAlimentation.NONE);
//	typesAlim.add(TypeAlimentation.VEGAN);
//	typesAlim.add(TypeAlimentation.HALAL);
//	typesAlim.add(TypeAlimentation.VEGETARIEN);
//	recette1.setTypeAlimentation(typesAlim);
	recette1.setTypeAlimentation(TypeAlimentation.NONE);
	recette1=recetteRepo.save(recette1);
	List<Recette> listRecettes1 = new ArrayList<Recette>();
	listRecettes1.add(recette1);	
	recette1.setPhoto("../../assets/images/crepes.jpg");
	recette1=recetteRepo.save(recette1);
	
	Ingredient ingredient1=new Ingredient("Farine",300);//ingredient1 recette1
	ingredient1.setRecettes(listRecettes1);
	ingredient1=ingredientRepo.save(ingredient1);
	Ingredient ingredient2=new Ingredient("Oeufs",3);//ingredient2 recette1
	ingredient2.setRecettes(listRecettes1);
	ingredient2=ingredientRepo.save(ingredient2);
	Ingredient ingredient3=new Ingredient("Beurre",50);
	ingredient3.setRecettes(listRecettes1);
	ingredient3=ingredientRepo.save(ingredient3);
	Ingredient ingredient4=new Ingredient("lait",60);
	ingredient4.setRecettes(listRecettes1);
	ingredient4=ingredientRepo.save(ingredient4);
	
	
	List<Ingredient> ingredients1=new ArrayList<Ingredient>();
	ingredients1.add(ingredient1);
	
	ingredients1.add(ingredient2);
	ingredient2.setRecettes(listRecettes1);
	ingredients1.add(ingredient3);
	ingredient3.setRecettes(listRecettes1);
	ingredients1.add(ingredient4);
	ingredient4.setRecettes(listRecettes1);
	
	recette1.setIngredients(ingredients1);
	recette1=recetteRepo.save(recette1);
	
	Repas repas1=new Repas();
	repas1.setTypeRepas(TypeRepas.PETIT_DEJ);
	repas1=repasRepo.save(repas1);
	
	Plat plat1=new Plat();
	plat1.setNombrePersonne(2);
	//plat1.setRecettes(listRecettes1);
	recette1.setPlat(plat1);
	plat1.setRepas(repas1);
	plat1 = platRepo.save(plat1);
	recette1=recetteRepo.save(recette1);
	}
	
	/********************************************************************************************************************	
	********************************************************************************************************************	8
	********************************************************************************************************************/
	@Test
	public void Gaufre(){
	Recette recette1=new Recette();
	recette1.setEtapes("ÉTAPE 1\r\n"
			+ "Séparer les blancs d'oeuf des jaunes, mettre les blancs dans un récipient à part.\r\n"
			+ "ÉTAPE 2\r\n"
			+ "Dans un deuxième récipient, mélanger tous les autres ingrédients en une pâte bien lisse.\r\n"
			+ "ÉTAPE 3\r\n"
			+ "Monter les blancs d'oeuf en neige bien ferme, les ajouter délicatement à la pâte en soulevant la masse (former des 8 avec une cuillère en bois)."
			+ "ÉTAPE 4\r\n"
			+ "Verser une louche de pâte dans l'appareil chauffé et laisser cuire ainsi de suite jusqu'à épuisement du stock !\r\n"
			+ "ÉTAPE 5\r\n"
			+ "Déguster les gaufres bien chaudes !\r\n"
			);
	
	recette1.setNom("Gaufres");
	recette1.setNombrePers(2);
	recette1.setNote(4.9F);
//	List<TypeAlimentation> typesAlim=new ArrayList<TypeAlimentation>();
//	typesAlim.add(TypeAlimentation.NONE);
//	typesAlim.add(TypeAlimentation.VEGAN);
//	typesAlim.add(TypeAlimentation.HALAL);
//	typesAlim.add(TypeAlimentation.VEGETARIEN);
//	recette1.setTypeAlimentation(typesAlim);
	recette1.setTypeAlimentation(TypeAlimentation.NONE);
	recette1=recetteRepo.save(recette1);
	List<Recette> listRecettes1 = new ArrayList<Recette>();
	listRecettes1.add(recette1);	
	recette1.setPhoto("../../assets/images/gaufres.jpg");
	recette1=recetteRepo.save(recette1);
	
	Ingredient ingredient1=new Ingredient("Farine",500);//ingredient1 recette1
	ingredient1.setRecettes(listRecettes1);
	ingredient1=ingredientRepo.save(ingredient1);
	Ingredient ingredient2=new Ingredient("Oeufs",4);//ingredient2 recette1
	ingredient2.setRecettes(listRecettes1);
	ingredient2=ingredientRepo.save(ingredient2);
	Ingredient ingredient3=new Ingredient("Beurre",150);
	ingredient3.setRecettes(listRecettes1);
	ingredient3=ingredientRepo.save(ingredient3);
	Ingredient ingredient4=new Ingredient("lait",60);
	ingredient4.setRecettes(listRecettes1);
	ingredient4=ingredientRepo.save(ingredient4);
	
	
	List<Ingredient> ingredients1=new ArrayList<Ingredient>();
	ingredients1.add(ingredient1);
	
	ingredients1.add(ingredient2);
	ingredient2.setRecettes(listRecettes1);
	ingredients1.add(ingredient3);
	ingredient3.setRecettes(listRecettes1);
	ingredients1.add(ingredient4);
	ingredient4.setRecettes(listRecettes1);
	
	recette1.setIngredients(ingredients1);
	recette1=recetteRepo.save(recette1);
	
	Repas repas1=new Repas();
	repas1.setTypeRepas(TypeRepas.PETIT_DEJ);
	repas1=repasRepo.save(repas1);
	
	Plat plat1=new Plat();
	plat1.setNombrePersonne(4);
	//plat1.setRecettes(listRecettes1);
	recette1.setPlat(plat1);
	plat1.setRepas(repas1);
	plat1 = platRepo.save(plat1);
	recette1=recetteRepo.save(recette1);
	}
	
	/********************************************************************************************************************	
	*******************************************Dej **********************************************************************
	********************************************************************************************************************/	
	
	//plat1 avec recettes1 et tous ses ingédients
		@Test
		public void Tartiflette(){
		Recette recette1=new Recette();
		recette1.setEtapes("ÉTAPE 1\r\n"
				+ "Eplucher les pommes de terre, les couper en dés, bien les rincer et les essuyer dans un torchon propre.\r\n"
				+ "\r\n"
				+ "ÉTAPE 2\r\n"
				+ "Faire chauffer l'huile dans une poêle, y faire fondre les oignons.\r\n"
				+ "\r\n"
				+ "ÉTAPE 3\r\n"
				+ "Lorsque les oignons sont fondus, ajouter les pommes de terre et les faire dorer de tous les côtés.\r\n"
				+ "\r\n"
				+ "ÉTAPE 4\r\n"
				+ "Lorsqu'elles sont dorées, ajouter les lardons et finir de cuire.\r\n"
				+ "\r\n"
				+ "ÉTAPE 5\r\n"
				+ "D'autre part, gratter la croûte du reblochon et le couper en deux (ou en quatre).\r\n"
				+ "\r\n"
				+ "ÉTAPE 6\r\n"
				+ "Préchauffer le four à 200°C (thermostat 6-7) et préparer un plat à gratin en frottant le fond et les bords avec la gousse d'ail épluchée.\r\n"
				+ "\r\n"
				+ "ÉTAPE 7\r\n"
				+ "Dans le plat à gratin, étaler une couche de pommes de terre aux lardons, disposer dessus la moitié du reblochon, puis de nouveau des pommes de terre. Terminer avec le reste du reblochon (croûte vers les pommes de terre).\r\n"
				+ "\r\n"
				+ "ÉTAPE 8\r\n"
				+ "Enfourner pour environ 20 minutes de cuisson. ");
		recette1.setNom("Tartiflette");
		recette1.setNombrePers(4);
		recette1.setNote(4.6F);
//		List<TypeAlimentation> typesAlim=new ArrayList<TypeAlimentation>();
//		typesAlim.add(TypeAlimentation.NONE);
//		recette1.setTypeAlimentation(typesAlim);

		recette1.setTypeAlimentation(TypeAlimentation.NONE);
		recette1=recetteRepo.save(recette1);
		List<Recette> listRecettes1 = new ArrayList<Recette>();
		listRecettes1.add(recette1);
		recette1.setPhoto("../../assets/images/tartiflette.jpg");
		recette1=recetteRepo.save(recette1);
		
		Ingredient ingredient1=new Ingredient("pommes de terre",1000);//ingredient1 recette1
		ingredient1.setRecettes(listRecettes1);
		ingredient1=ingredientRepo.save(ingredient1);
		Ingredient ingredient2=new Ingredient("lardons fumés",200);//ingredient2 recette1
		ingredient2.setRecettes(listRecettes1);
		ingredient2=ingredientRepo.save(ingredient2);
		Ingredient ingredient3=new Ingredient("huile",20);
		ingredient3.setRecettes(listRecettes1);
		ingredient3=ingredientRepo.save(ingredient3);
		Ingredient ingredient4=new Ingredient("ail",10);
		ingredient4.setRecettes(listRecettes1);
		ingredient4=ingredientRepo.save(ingredient4);
		Ingredient ingredient5=new Ingredient("sel",2);
		ingredient5.setRecettes(listRecettes1);
		ingredient5=ingredientRepo.save(ingredient5);
		Ingredient ingredient6=new Ingredient("poivre",3);
		ingredient6.setRecettes(listRecettes1);
		ingredient6=ingredientRepo.save(ingredient6);
		Ingredient ingredient7=new Ingredient("oignons émincés",200);
		ingredient7.setRecettes(listRecettes1);
		ingredient7=ingredientRepo.save(ingredient7);
		Ingredient ingredient8=new Ingredient("reblochon",500);
		ingredient8.setRecettes(listRecettes1);
		ingredient8=ingredientRepo.save(ingredient8);
		
		
		
		List<Ingredient> ingredients1=new ArrayList<Ingredient>();
		ingredients1.add(ingredient1);
		
		ingredients1.add(ingredient2);
		ingredient2.setRecettes(listRecettes1);
		ingredients1.add(ingredient3);
		ingredient3.setRecettes(listRecettes1);
		ingredients1.add(ingredient4);
		ingredient4.setRecettes(listRecettes1);
		ingredients1.add(ingredient5);
		ingredient5.setRecettes(listRecettes1);
		ingredients1.add(ingredient6);
		ingredient6.setRecettes(listRecettes1);
		ingredients1.add(ingredient7);
		ingredient7.setRecettes(listRecettes1);
		ingredients1.add(ingredient8);
		ingredient8.setRecettes(listRecettes1);
		recette1.setIngredients(ingredients1);
		recette1=recetteRepo.save(recette1);
		
		Repas repas1=new Repas();
		repas1.setTypeRepas(TypeRepas.DINNER);
		repas1=repasRepo.save(repas1);
		
		Plat plat1=new Plat();
		plat1.setNombrePersonne(6);
		//plat1.setRecettes(listRecettes1);
		recette1.setPlat(plat1);
		plat1.setRepas(repas1);
		plat1 = platRepo.save(plat1);
		recette1=recetteRepo.save(recette1);
		}
		
		
		
/********************************************************************************************************************		
*****************************************DINER**********************************************************************
********************************************************************************************************************/	
		
		@Test
		public void PotAuFeu(){
		Recette recette1=new Recette();
		recette1.setEtapes("ÉTAPE 1\r\n"
				+ "Ficelez les morceaux de viande pour qu'ils se maintiennent en forme pendant la cuisson et, s'il y en a, coupez la queue de boeuf en tronçons.\r\n"
				+ "\r\n"
				+ "ÉTAPE 2\r\n"
				+ "Épluchez les carottes, les poireaux et la branche de céleri, puis lavez-les.\r\n"
				+ "\r\n"
				+ "ÉTAPE 3\r\n"
				+ "Piquez un oignon avec les clous de girofle et faites dorer le second, à sec, au four : il colorera le bouillon (pour colorer le bouillon, ajouter 1/2 cuillerée à café d’arôme Patrelle).\r\n"
				+ "\r\n"
				+ "ÉTAPE 4\r\n"
				+ "Mettez dans un faitout tous les morceaux de viande et l’os à moelle, préalablement enveloppé dans une mousseline pour éviter que la moelle ne se répande. Mouillez avec 5 litres d'eau froide.\r\n"
				+ "\r\n"
				+ "ÉTAPE 5\r\n"
				+ "Salez au gros sel. Portez à ébullition et laissez bouillir, en ayant soin d'écumer souvent, jusqu'à ce qu'il ne se forme plus d'écume.\r\n"
				+ "\r\n"
				+ "ÉTAPE 6\r\n"
				+ "Ajoutez-y les oignons, les carottes, les poireaux (liés en botte), le céleri branche, l’ail et le bouquet garni, préalablement ficelé. Ajoutez 12 grains de poivre.\r\n"
				+ "\r\n"
				+ "ÉTAPE 7\r\n"
				+ "Portez de nouveau à ébullition, puis laissez cuire, à couvert (la vapeur doit pouvoir s'échapper sur le côté), sur feu très doux, pendant au moins 4 heures.\r\n"
				+ "\r\n"
				+ "ÉTAPE 8\r\n"
				+ "Dégraisser en cours de cuisson avec une petite louche.\r\n"
				+ "\r\n"
				+ "ÉTAPE 9\r\n"
				+ "Le bouillon du pot-au-feu se consomme chaud ou tiède, en précédant les viandes et les légumes ou seul. Il peut aussi être la base de divers potages.\r\n"
				+ "\r\n"
				+ "ÉTAPE 10\r\n"
				+ "Quant aux morceaux de viande et aux légumes, retirez-les du bouillon et dressez-les dans un plat chaud. Servez-les aussitôt, avec des cornichons, du gros sel et de la moutarde forte.");
		recette1.setNom("Pot-au-feu");
		recette1.setNombrePers(4);
		recette1.setNote(4.7F);
//		List<TypeAlimentation> typesAlim=new ArrayList<TypeAlimentation>();
//		typesAlim.add(TypeAlimentation.NONE);
//		typesAlim.add(TypeAlimentation.HALAL);
//		recette1.setTypeAlimentation(typesAlim);
		recette1.setTypeAlimentation(TypeAlimentation.HALAL);
		recette1=recetteRepo.save(recette1);
		List<Recette> listRecettes1 = new ArrayList<Recette>();
		listRecettes1.add(recette1);	
		recette1.setPhoto("../../assets/images/potAuFeu.jpg");
		recette1=recetteRepo.save(recette1);
		
		Ingredient ingredient1=new Ingredient("poireau",400);//ingredient1 recette1
		ingredient1.setRecettes(listRecettes1);
		ingredient1=ingredientRepo.save(ingredient1);
		Ingredient ingredient2=new Ingredient("carotte",200);//ingredient2 recette1
		ingredient2.setRecettes(listRecettes1);
		ingredient2=ingredientRepo.save(ingredient2);
		Ingredient ingredient3=new Ingredient("céleri branche",50);
		ingredient3.setRecettes(listRecettes1);
		ingredient3=ingredientRepo.save(ingredient3);
		Ingredient ingredient4=new Ingredient("ail",10);
		ingredient4.setRecettes(listRecettes1);
		ingredient4=ingredientRepo.save(ingredient4);
		Ingredient ingredient5=new Ingredient("bouquet garni",15);
		ingredient5.setRecettes(listRecettes1);
		ingredient5=ingredientRepo.save(ingredient5);
		Ingredient ingredient6=new Ingredient("clou de girofle",2);
		ingredient6.setRecettes(listRecettes1);
		ingredient6=ingredientRepo.save(ingredient6);
		Ingredient ingredient7=new Ingredient("gros sel",5);
		ingredient7.setRecettes(listRecettes1);
		ingredient7=ingredientRepo.save(ingredient7);
		Ingredient ingredient8=new Ingredient("poivre",5);
		ingredient8.setRecettes(listRecettes1);
		ingredient8=ingredientRepo.save(ingredient8);
		Ingredient ingredient9=new Ingredient("boeuf",1000);
		ingredient9.setRecettes(listRecettes1);
		ingredient9=ingredientRepo.save(ingredient9);
		Ingredient ingredient10=new Ingredient("os à moelle",300);
		ingredient10.setRecettes(listRecettes1);
		ingredient10=ingredientRepo.save(ingredient10);
		Ingredient ingredient11=new Ingredient("oignon",100);
		ingredient10.setRecettes(listRecettes1);
		ingredient10=ingredientRepo.save(ingredient10);
		
		
		
		List<Ingredient> ingredients1=new ArrayList<Ingredient>();
		ingredients1.add(ingredient1);
		
		ingredients1.add(ingredient2);
		ingredient2.setRecettes(listRecettes1);
		ingredients1.add(ingredient3);
		ingredient3.setRecettes(listRecettes1);
		ingredients1.add(ingredient4);
		ingredient4.setRecettes(listRecettes1);
		ingredients1.add(ingredient5);
		ingredient5.setRecettes(listRecettes1);
		ingredients1.add(ingredient6);
		ingredient6.setRecettes(listRecettes1);
		ingredients1.add(ingredient7);
		ingredient7.setRecettes(listRecettes1);
		ingredients1.add(ingredient8);
		ingredient8.setRecettes(listRecettes1);
		ingredients1.add(ingredient9);
		ingredient9.setRecettes(listRecettes1);
		ingredients1.add(ingredient10);
		ingredient10.setRecettes(listRecettes1);
		ingredients1.add(ingredient11);
		ingredient11.setRecettes(listRecettes1);
		recette1.setIngredients(ingredients1);
		recette1=recetteRepo.save(recette1);
		
		Repas repas1=new Repas();
		repas1.setTypeRepas(TypeRepas.DEJ);
		repas1=repasRepo.save(repas1);
		
		Plat plat1=new Plat();
		plat1.setNombrePersonne(6);
		//plat1.setRecettes(listRecettes1);
		recette1.setPlat(plat1);
		plat1.setRepas(repas1);
		plat1 = platRepo.save(plat1);
		recette1=recetteRepo.save(recette1);
		}
		
/********************************************************************************************************************	
********************************************************************************************************************	
********************************************************************************************************************/	
		
		
		@Test
		public void EnchiladdasHalal(){
		Recette recette1=new Recette();
		recette1.setEtapes("Préparation de la sauce béchamel\r\n"
				+ " ÉTAPE 1\r\n"
				+ "Faites fondre le beurre, ajoutez la farine, mélangez avec un fouet, puis versez le lait en continuant à mélanger pour éviter la formation de grumeaux.\r\n"
				+ "ÉTAPE 2\r\n"
				+ "Salez et poivrez, ajoutez une pincée de noix de muscade râpée, amenez le tout à ébullition et laissez cuire quelques minutes en mélangeant jusqu'à obtenir une sauce. Retirez du feu dès que ça commence à s'épaissir.\r\n"
                + "ÉTAPE 3\r\n"
				+ "Préparation de la farce\r\n"
				+ "Faites revenir l'oignon et l'ail dans une sauteuse avec l'huile. Quand l'oignon devient translucide, ajoutez les lardons de Poulet fumés Isla Délice.\r\n"
				+ "ÉTAPE 4\r\n"
				+ "Ajoutez le concentré de tomate, la purée de piment et la pulpe de tomate. Salez et poivrez.\r\n"
				+ "ÉTAPE 5\r\n"
				+ "Portez à ébullition, baissez le feu et laissez mijoter 10 minutes. Saupoudrez de persil et mélangez.\r\n"
				+ "ÉTAPE 6\r\n"
				+ "Préparation des enchiladas\r\n"
				+ "Préchauffez le four à 200°C. \r\n"
				+ "Garnissez chaque tortilla de la farce aux lardons.\r\n"
				+ "ÉTAPE 7\r\n"
				+ "Saupoudrez de fromage.\r\n"
				+ "ÉTAPE 8\r\n"
				+ "Enroulez les tortillas autour de la farce.\r\n"
				+ "ÉTAPE 9\r\n"
				+ "Placez-les dans un plat rectangulaire badigeonné de sauce béchamel.\r\n"
				+ "ÉTAPE 10\r\n"
				+ "Nappez le tout de sauce béchamel.\r\n"
				+ "ÉTAPE 11\r\n"
				+ "Saupoudrez du reste de fromage. \r\n"
				+ "Faites cuire 15 minutes au four, jusqu'à faire dorer un peu le fromage. Servez chaud avec une salade verte.");
		recette1.setNom("Enchiladas aux lardons de poulet Halal");
		recette1.setNombrePers(4);
		recette1.setNote(5F);
//		List<TypeAlimentation> typesAlim=new ArrayList<TypeAlimentation>();
//		typesAlim.add(TypeAlimentation.NONE);
//		typesAlim.add(TypeAlimentation.HALAL);
//		recette1.setTypeAlimentation(typesAlim);
		recette1.setTypeAlimentation(TypeAlimentation.HALAL);
		recette1=recetteRepo.save(recette1);
		List<Recette> listRecettes1 = new ArrayList<Recette>();
		listRecettes1.add(recette1);	
		recette1.setPhoto("../../assets/images/enchiladasHalal.jpg");
		recette1=recetteRepo.save(recette1);
		
		Ingredient ingredient1=new Ingredient("lait",400);//ingredient1 recette1
		ingredient1.setRecettes(listRecettes1);
		ingredient1=ingredientRepo.save(ingredient1);
		Ingredient ingredient2=new Ingredient("beurre",20);//ingredient2 recette1
		ingredient2.setRecettes(listRecettes1);
		ingredient2=ingredientRepo.save(ingredient2);
		Ingredient ingredient3=new Ingredient("farine",20);
		ingredient3.setRecettes(listRecettes1);
		ingredient3=ingredientRepo.save(ingredient3);
		Ingredient ingredient4=new Ingredient("noix de muscade",3);
		ingredient4.setRecettes(listRecettes1);
		ingredient4=ingredientRepo.save(ingredient4);
		Ingredient ingredient5=new Ingredient("sel",2);
		ingredient5.setRecettes(listRecettes1);
		ingredient5=ingredientRepo.save(ingredient5);
		Ingredient ingredient6=new Ingredient("poivre",3);
		ingredient6.setRecettes(listRecettes1);
		ingredient6=ingredientRepo.save(ingredient6);
		Ingredient ingredient7=new Ingredient("tortillas",200);
		ingredient7.setRecettes(listRecettes1);
		ingredient7=ingredientRepo.save(ingredient7);
		Ingredient ingredient8=new Ingredient("pulpe de tomates en conserve",150);
		ingredient8.setRecettes(listRecettes1);
		ingredient8=ingredientRepo.save(ingredient8);
		Ingredient ingredient9=new Ingredient("harissa",2);
		ingredient9.setRecettes(listRecettes1);
		ingredient9=ingredientRepo.save(ingredient9);
		Ingredient ingredient10=new Ingredient("ail",10);
		ingredient10.setRecettes(listRecettes1);
		ingredient10=ingredientRepo.save(ingredient10);
		Ingredient ingredient11=new Ingredient("huile d'olive",20);
		ingredient11.setRecettes(listRecettes1);
		ingredient11=ingredientRepo.save(ingredient11);
		Ingredient ingredient12=new Ingredient("concentré de tomates",20);
		ingredient12.setRecettes(listRecettes1);
		ingredient12=ingredientRepo.save(ingredient12);
		Ingredient ingredient13=new Ingredient("oignon",50);
		ingredient13.setRecettes(listRecettes1);
		ingredient13=ingredientRepo.save(ingredient13);
		Ingredient ingredient14=new Ingredient("gruyère rapé",150);
		ingredient14.setRecettes(listRecettes1);
		ingredient14=ingredientRepo.save(ingredient14);
		Ingredient ingredient15=new Ingredient("persil haché",20);
		ingredient15.setRecettes(listRecettes1);
		ingredient15=ingredientRepo.save(ingredient15);
		
		
		
		List<Ingredient> ingredients1=new ArrayList<Ingredient>();
		ingredients1.add(ingredient1);
		
		ingredients1.add(ingredient2);
		ingredient2.setRecettes(listRecettes1);
		ingredients1.add(ingredient3);
		ingredient3.setRecettes(listRecettes1);
		ingredients1.add(ingredient4);
		ingredient4.setRecettes(listRecettes1);
		ingredients1.add(ingredient5);
		ingredient5.setRecettes(listRecettes1);
		ingredients1.add(ingredient6);
		ingredient6.setRecettes(listRecettes1);
		ingredients1.add(ingredient7);
		ingredient7.setRecettes(listRecettes1);
		ingredients1.add(ingredient8);
		ingredient8.setRecettes(listRecettes1);
		ingredients1.add(ingredient9);
		ingredient9.setRecettes(listRecettes1);
		ingredients1.add(ingredient10);
		ingredient10.setRecettes(listRecettes1);
		ingredients1.add(ingredient11);
		ingredient11.setRecettes(listRecettes1);
		ingredients1.add(ingredient12);
		ingredient12.setRecettes(listRecettes1);
		ingredients1.add(ingredient13);
		ingredient13.setRecettes(listRecettes1);
		ingredients1.add(ingredient14);
		ingredient14.setRecettes(listRecettes1);
		ingredients1.add(ingredient15);
		ingredient15.setRecettes(listRecettes1);
		recette1.setIngredients(ingredients1);
		recette1=recetteRepo.save(recette1);
		
		Repas repas1=new Repas();
		repas1.setTypeRepas(TypeRepas.DEJ);
		repas1=repasRepo.save(repas1);
		
		Plat plat1=new Plat();
		plat1.setNombrePersonne(6);
		//plat1.setRecettes(listRecettes1);
		recette1.setPlat(plat1);
		plat1.setRepas(repas1);
		plat1 = platRepo.save(plat1);
		recette1=recetteRepo.save(recette1);
		}
				
}
