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
			+ "Mélanger les oeufs, le lait et le sucre. Tremper la brioche dans ce mélange\ret les faire revenir dans le beurre.\r\n"
			+ "\r\n"
			+ "ÉTAPE 3\r\n"
			+ "Faire chauffer doucement la crème et ajouter le caramel. Laisser épaissir.\r\n"
			+ "\r\n"
			+ "ÉTAPE 4\r\n"
			+ "Dresser la tranche de brioche dans une assiette avec une boule de glace\ret la sauce au caramel.");
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
	Ingredient ingredient5=new Ingredient("glace caramel",100);
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
	repas1.setTypeRepas(TypeRepas.PETIT_DEJ);
	repas1=repasRepo.save(repas1);
	
	Plat plat1=new Plat();
	plat1.setNombrePersonne(4);
	plat1.setRepas(repas1);
	plat1 = platRepo.save(plat1);
	recette1.setPlat(plat1);
	recette1 = recetteRepo.save(recette1);
	}
	
	/********************************************************************************************************************	
	********************************************************************************************************************	2
	********************************************************************************************************************/	
	
	@Test
	public void BiscuitCereal(){
	Recette recette1=new Recette();
	recette1.setEtapes("ÉTAPE 1\r\n"
			+ "Dans une jatte, pétrissez tous les ingrédients ensemble jusqu'à obtenir une\rboule de pâte.\r\n"
			+ "\r\n"
			+ "ÉTAPE 2\r\n"
			+ "Si vous souhaitez faire différents biscuits avec cette même pâte, ne mettez\rpas les ingrédients optionnels.\r\n"
			+ "\r\n"
			+ "ÉTAPE 3\r\n"
			+ "Enveloppez la pâte dans du film transparent et mettre au frigo pour une\rdizaine de minutes au moins.\r\n"
			+ "\r\n"
			+ "ÉTAPE 4\r\n"
			+ "Préchauffez votre four à 200°C et placez du papier sulfurisé sur une plaque\rde cuisson.\r\n"
			+ "\r\n"
			+ "ÉTAPE 5\r\n"
			+ "Sortez la pâte du frigo et, si vous le souhaitez, séparez la pâte en plusieurs\rparts pour y ajouter les ingrédients optionnels.\r\n"
			+ "\r\n"
			+ "ÉTAPE 6\r\n"
			+ "Formez de petites boules de pâtes que vous écraserez dans la paume avant de\rplacer sur la plaque.\r\n"
			+ "\r\n"
			+ "ÉTAPE 7\r\n"
			+ "Placez au four pour environ 10 minutes, selon votre four. Restez à proximité\rdes biscuits. Ils doivent être à peine dorés pour restez moelleux ou bien dorés pour être un peu plus croquants.");
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

	plat1.setRepas(repas1);
	plat1 = platRepo.save(plat1);
	recette1.setPlat(plat1);
	recette1 = recetteRepo.save(recette1);
	}
	
	/********************************************************************************************************************	
	********************************************************************************************************************	3
	********************************************************************************************************************/
	@Test
	public void EnglishBreakfast(){
	Recette recette1=new Recette();
	recette1.setEtapes("Etapes\r\n"
			+ "ÉTAPE 1\r\n"
			+ "- Couper les champignons en tranches et les faire revenir dans une poêle\ravec un peu de beurre, à feu moyen. Saler, poivrer.\r\n"
			+ "\r\n"
			+ "ÉTAPE 2\r\n"
			+ "- Pendant ce temps, faire cuire le bacon dans une grande poêle, et mettre\rle pain à toaster.\r\n"
			+ "\r\n"
			+ "ÉTAPE 3\r\n"
			+ "- Rajouter dans la poêle les oeufs (au plat), saler, poivrer.\r\n"
			+ "\r\n"
			+ "ÉTAPE 4\r\n"
			+ "Réchauffer les haricots au micro-ondes (2 min, en remuant à mi-temps) et\rbeurrer les tranches de pain que l'on coupera en diagonale.\r\n"
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
	plat1.setNombrePersonne(2);
	
	plat1.setRepas(repas1);
	plat1 = platRepo.save(plat1);
	recette1.setPlat(plat1);
	recette1 = recetteRepo.save(recette1);
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
			+ "Etalez sur une plaque tapissée de papier sulfurisé par petites miettes ou\r amas plus ou moins gros (ajoutez un peu de farine si c'est trop pâteux).\r\n"
			+ "\r\n"
			+ "ÉTAPE 4\r\n"
			+ "Enfournez pendant 13 minutes en surveillant la cuisson : le crumble doit être\r bien doré et croustillant sur le dessus.\r\n"
			+ "\r\n"
			+ "ÉTAPE 5\r\n"
			+ "Mélangez tous les autres ingrédients et ajoutez le crumble cuit en miettes,\r une fois bien refroidi (pour que le chocolat ne fonde pas).\r\n"
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
	
	plat1.setRepas(repas1);
	plat1 = platRepo.save(plat1);
	recette1.setPlat(plat1);
	recette1 = recetteRepo.save(recette1);
	}
	
	/********************************************************************************************************************	
	********************************************************************************************************************	5
	********************************************************************************************************************/
	
	@Test
	public void Pancake(){
	Recette recette1=new Recette();
	recette1.setEtapes("ÉTAPE 1\r\n"
			+ "Faire fondre le beurre, dans une casserole à feu doux ou dans un bol au\rmicro-ondes.\r\n"
			+ "\r\n"
			+ "ÉTAPE 2\r\n"
			+ "Mettre la farine, la levure et le sucre dans un saladier. Mélanger et\rcreuser un puits.\r\n"
			+ "\r\n"
			+ "ÉTAPE 3\r\n"
			+ "Ajouter ensuite les oeufs entiers et fouetter l'ensemble.\r\n"
			+ "\r\n"
			+ "ÉTAPE 4\r\n"
			+ "Incorporer le beurre fondu, fouetter puis délayer progressivement le\rmélange avec le lait afin d'éviter les grumeaux.\r\n"
			+ "\r\n"
			+ "ÉTAPE 5\r\n"
			+ "Laisser reposer la pâte au minimum 1 heure au réfrigérateur.\r\n"
			+ "\r\n"
			+ "ÉTAPE 6\r\n"
			+ "Dans une poêle chaude et légèrement huilée, faire cuire comme des\rcrêpes, mais en les faisant plus petites. Réserver au chaud et déguster.");
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

	plat1.setRepas(repas1);
	plat1 = platRepo.save(plat1);
	recette1.setPlat(plat1);
	recette1 = recetteRepo.save(recette1);
	}
	/********************************************************************************************************************	
	********************************************************************************************************************	6
	********************************************************************************************************************/
	@Test
	public void Smoothie(){
	Recette recette1=new Recette();
	recette1.setEtapes("ÉTAPE 1\r\n"
			+ "mettre dans un mixer les bananes coupées en morceaux et la\rchair des kiwis.\r\n"
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
	
	plat1.setRepas(repas1);
	plat1 = platRepo.save(plat1);
	recette1.setPlat(plat1);
	recette1 = recetteRepo.save(recette1);
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
	*******************************************Dej ********************************************************************** 1
	********************************************************************************************************************/	
	
	//plat1 avec recettes1 et tous ses ingédients
		@Test
		public void Tartiflette(){
		Recette recette1=new Recette();
		recette1.setEtapes("ÉTAPE 1\r\n"
				+ "Eplucher les pommes de terre, les couper en dés, bien les rincer\ret les essuyer dans un torchon propre.\r\n"
				+ "\r\n"
				+ "ÉTAPE 2\r\n"
				+ "Faire chauffer l'huile dans une poêle, y faire fondre les oignons.\r\n"
				+ "\r\n"
				+ "ÉTAPE 3\r\n"
				+ "Lorsque les oignons sont fondus, ajouter les pommes de terre et\rles faire dorer de tous les côtés.\r\n"
				+ "\r\n"
				+ "ÉTAPE 4\r\n"
				+ "Lorsqu'elles sont dorées, ajouter les lardons et finir de cuire.\r\n"
				+ "\r\n"
				+ "ÉTAPE 5\r\n"
				+ "D'autre part, gratter la croûte du reblochon et le couper en\rdeux (ou en quatre).\r\n"
				+ "\r\n"
				+ "ÉTAPE 6\r\n"
				+ "Préchauffer le four à 200°C (thermostat 6-7) et préparer un\rplat à gratin en frottant le fond et les bords avec la gousse d'ail épluchée.\r\n"
				+ "\r\n"
				+ "ÉTAPE 7\r\n"
				+ "Dans le plat à gratin, étaler une couche de pommes de terre\raux lardons, disposer dessus la moitié du reblochon, puis de nouveau des pommes de terre. Terminer avec le reste du reblochon (croûte vers les pommes de terre).\r\n"
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
		repas1.setTypeRepas(TypeRepas.DEJ);
		repas1=repasRepo.save(repas1);
		
		Plat plat1=new Plat();
		plat1.setNombrePersonne(4);
		
		plat1.setRepas(repas1);
		plat1 = platRepo.save(plat1);
		recette1.setPlat(plat1);
		recette1 = recetteRepo.save(recette1);
		}
		
		
		@Test
		public void TomateFarcie(){
		Recette recette1=new Recette();
		recette1.setEtapes("ÉTAPE 1\r\n"
				+ "Eplucher et hacher les oignons. Eplucher et hacher les gousses d'ail.\r\n"
				+ "\r\n"
				+ "ÉTAPE 2\r\n"
				+ "Mettre la moitié des oignons dans la chair à saucisse. Ajouter l'ail,\rle sel, le poivre et un peu de persil.\r\n"
				+ "\r\n"
				+ "ÉTAPE 3\r\n"
				+ "Couper le haut des tomates et les évider. Poivrer et saler l'intérieur.\rMettre la farce à l'intérieur et remettre les chapeaux.\r\n"
				+ "\r\n"
				+ "ÉTAPE 4\r\n"
				+ "Mettre le reste des oignons dans un plat avec la chair des tomates.\r\n"
				+ "\r\n"
				+ "ÉTAPE 5\r\n"
				+ "Mettre les tomates farcies dans le plat. Parsemez d'un peu de thym et\rmette une noisette de beurre sur chaque tomates. Faire cuire au four chaud à 180°C (thermostat 6) pendant 1 heure environ.\r\n"
				+ "\r\n"
				+ "ÉTAPE 6\r\n"
				+ "Servir avec du riz.");
		recette1.setNom("Tomates Farcies");
		recette1.setNombrePers(4);
		recette1.setNote(4.6F);
//		List<TypeAlimentation> typesAlim=new ArrayList<TypeAlimentation>();
//		typesAlim.add(TypeAlimentation.NONE);
//		recette1.setTypeAlimentation(typesAlim);

		recette1.setTypeAlimentation(TypeAlimentation.NONE);
		recette1=recetteRepo.save(recette1);
		List<Recette> listRecettes1 = new ArrayList<Recette>();
		listRecettes1.add(recette1);
		recette1.setPhoto("../../assets/images/tomatefarcie.jpg");
		recette1=recetteRepo.save(recette1);
		
		Ingredient ingredient1=new Ingredient("tomate",600);//ingredient1 recette1
		ingredient1.setRecettes(listRecettes1);
		ingredient1=ingredientRepo.save(ingredient1);
		Ingredient ingredient2=new Ingredient("chair à saucisse",500);//ingredient2 recette1
		ingredient2.setRecettes(listRecettes1);
		ingredient2=ingredientRepo.save(ingredient2);
		Ingredient ingredient3=new Ingredient("beurre",20);
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
		Ingredient ingredient7=new Ingredient("thym",2);
		ingredient7.setRecettes(listRecettes1);
		ingredient7=ingredientRepo.save(ingredient7);
		Ingredient ingredient8=new Ingredient("persil",5);
		ingredient8.setRecettes(listRecettes1);
		ingredient8=ingredientRepo.save(ingredient8);
		Ingredient ingredient9=new Ingredient("oignon",20);
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
		repas1.setTypeRepas(TypeRepas.DEJ);
		repas1=repasRepo.save(repas1);
		
		Plat plat1=new Plat();
		plat1.setNombrePersonne(4);
		
		plat1.setRepas(repas1);
		plat1 = platRepo.save(plat1);
		recette1.setPlat(plat1);
		recette1 = recetteRepo.save(recette1);
		}	
		
		/****************************************	
		****************************************	
		****************************************/
		@Test
		public void Blanquette(){
		Recette recette1=new Recette();
		recette1.setEtapes("ÉTAPE 1\r\n"
				+ "Faire revenir la viande dans un peu de beurre doux jusqu'à\rce que les morceaux soient un peu dorés.\r\n"
				+ "\r\n"
				+ "ÉTAPE 2\r\n"
				+ "Saupoudrer de 2 cuillères de farine. Bien remuer.\r\n"
				+ "\r\n"
				+ "ÉTAPE 3\r\n"
				+ "Ajouter 2 ou 3 verres d'eau, les cubes de bouillon, le vin\ret remuer. Ajouter de l'eau si nécessaire pour couvrir.\r\n"
				+ "\r\n"
				+ "ÉTAPE 4\r\n"
				+ "Couper les carottes en rondelles et émincer les oignons puis\rles incorporer à la viande, ainsi que les champignons.\r\n"
				+ "\r\n"
				+ "ÉTAPE 5\r\n"
				+ "Laisser mijoter à feu très doux environ 1h30 à 2h00 en remuant.\r\n"
				+ "\r\n"
				+ "ÉTAPE 6\r\n"
				+ "Si nécessaire, ajouter de l'eau de temps en temps.\r\n"
				+ "\r\n"
				+ "ÉTAPE 7\r\n"
				+ "Dans un bol, bien mélanger la crème fraîche, le jaune d’oeuf et\rle jus de citron. Ajouter ce mélange au dernier moment, bien remuer et servir tout de suite.");
		recette1.setNom("Blanquette de veau");
		recette1.setNombrePers(4);
		recette1.setNote(4.9F);
//		List<TypeAlimentation> typesAlim=new ArrayList<TypeAlimentation>();
//		typesAlim.add(TypeAlimentation.NONE);
//		recette1.setTypeAlimentation(typesAlim);

		recette1.setTypeAlimentation(TypeAlimentation.NONE);
		recette1=recetteRepo.save(recette1);
		List<Recette> listRecettes1 = new ArrayList<Recette>();
		listRecettes1.add(recette1);
		recette1.setPhoto("../../assets/images/blanquette.jpg");
		recette1=recetteRepo.save(recette1);
		
		Ingredient ingredient1=new Ingredient("cube bouillon",20);//ingredient1 recette1
		ingredient1.setRecettes(listRecettes1);
		ingredient1=ingredientRepo.save(ingredient1);
		Ingredient ingredient2=new Ingredient("bouillon de poule",20);//ingredient2 recette1
		ingredient2.setRecettes(listRecettes1);
		ingredient2=ingredientRepo.save(ingredient2);
		Ingredient ingredient3=new Ingredient("carotte",200);
		ingredient3.setRecettes(listRecettes1);
		ingredient3=ingredientRepo.save(ingredient3);
		Ingredient ingredient4=new Ingredient("champignon",75);
		ingredient4.setRecettes(listRecettes1);
		ingredient4=ingredientRepo.save(ingredient4);
		Ingredient ingredient5=new Ingredient("sel",2);
		ingredient5.setRecettes(listRecettes1);
		ingredient5=ingredientRepo.save(ingredient5);
		Ingredient ingredient6=new Ingredient("poivre",3);
		ingredient6.setRecettes(listRecettes1);
		ingredient6=ingredientRepo.save(ingredient6);
		Ingredient ingredient7=new Ingredient("citron",2);
		ingredient7.setRecettes(listRecettes1);
		ingredient7=ingredientRepo.save(ingredient7);
		Ingredient ingredient8=new Ingredient("farine",50);
		ingredient8.setRecettes(listRecettes1);
		ingredient8=ingredientRepo.save(ingredient8);
		Ingredient ingredient9=new Ingredient("vin blanc",20);
		ingredient9.setRecettes(listRecettes1);
		ingredient9=ingredientRepo.save(ingredient9);
		Ingredient ingredient10=new Ingredient("veau",1000);
		ingredient10.setRecettes(listRecettes1);
		ingredient10=ingredientRepo.save(ingredient10);
		Ingredient ingredient11=new Ingredient("oignon",50);
		ingredient11.setRecettes(listRecettes1);
		ingredient11=ingredientRepo.save(ingredient11);
		Ingredient ingredient12=new Ingredient("creme fraiche",75);
		ingredient12.setRecettes(listRecettes1);
		ingredient12=ingredientRepo.save(ingredient12);
		}
		
		/**************	
		**************	
		**************/
		
		
		@Test
		public void Lasagne(){
		Recette recette1=new Recette();
		recette1.setEtapes("ÉTAPE 1\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "Faire revenir gousses hachées d'ail et les oignons\rémincés dans un peu d'huile d'olive.\r\n"
				+ "\r\n"
				+ "ÉTAPE 2\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "Ajouter la carotte et la branche de céleri hachée\rpuis la viande et faire revenir le tout.\r\n"
				+ "\r\n"
				+ "ÉTAPE 3\r\n"
				+ "\r\n"
				+ "Au bout de quelques minutes, ajouter le vin rouge.\r Laisser cuire jusqu'à évaporation.\r\n"
				+ "\r\n"
				+ "ÉTAPE 4\r\n"
				+ "\r\n"
				+ "Ajouter la purée de tomates, l'eau et les herbes.\r Saler, poivrer, puis laisser mijoter à feu doux 45 minutes.\r\n"
				+ "\r\n"
				+ "ÉTAPE 5\r\n"
				+ "\r\n"
				+ "Préparer la béchamel : faire fondre le beurre.\r\n"
				+ "\r\n"
				+ "ÉTAPE 6\r\n"
				+ "\r\n"
				+ "Hors du feu, ajouter la farine d'un coup.\r\n"
				+ "\r\n"
				+ "ÉTAPE 7\r\n"
				+ "Remettre sur le feu et remuer avec un fouet jusqu'à\rl'obtention d'un mélange bien lisse.\r\n"
				+ "\r\n"
				+ "ÉTAPE 8\r\n"
				+ "\r\n"
				+ "Ajouter le lait peu à peu.\r\n"
				+ "\r\n"
				+ "ÉTAPE 9\r\n"
				+ "Remuer sans cesse, jusqu'à ce que le mélange s'épaississe.\r\n"
				+ "\r\n"
				+ "ÉTAPE 10\r\n"
				+ "\r\n"
				+ "Ensuite, parfumer avec la muscade, saler, poivrer.\rLaisser cuire environ 5 minutes, à feu très doux, en remuant. Réserver.\r\n"
				+ "\r\n"
				+ "ÉTAPE 11\r\n"
				+ "\r\n"
				+ "Préchauffer le four à 200°C (thermostat 6-7).\r Huiler le plat à lasagnes. Poser une fine couche de béchamel puis\rdes feuilles de lasagnes, de la bolognaise, de la béchamel et du parmesan.\r Répéter l'opération 3 fois de suite.\r\n"
				+ "\r\n"
				+ "ÉTAPE 12\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "Sur la dernière couche de lasagnes, ne mettre que\r de la béchamel et recouvrir de fromage râpé.\r Parsemer quelques noisettes de beurre.\r\n"
				+ "\r\n"
				+ "ÉTAPE 13\r\n"
				+ "Enfourner pour environ 25 minutes de cuisson.");
		recette1.setNom("Lasagne");
		recette1.setNombrePers(8);
		recette1.setNote(4.9F);
//		List<TypeAlimentation> typesAlim=new ArrayList<TypeAlimentation>();
//		typesAlim.add(TypeAlimentation.NONE);
//		recette1.setTypeAlimentation(typesAlim);

		recette1.setTypeAlimentation(TypeAlimentation.NONE);
		recette1=recetteRepo.save(recette1);
		List<Recette> listRecettes1 = new ArrayList<Recette>();
		listRecettes1.add(recette1);
		recette1.setPhoto("../../assets/images/lasagne.jpg");
		recette1=recetteRepo.save(recette1);
		
		Ingredient ingredient1=new Ingredient("lait",1000);//ingredient1 recette1
		ingredient1.setRecettes(listRecettes1);
		ingredient1=ingredientRepo.save(ingredient1);
		Ingredient ingredient2=new Ingredient("beurre",100);//ingredient2 recette1
		ingredient2.setRecettes(listRecettes1);
		ingredient2=ingredientRepo.save(ingredient2);
		Ingredient ingredient3=new Ingredient("lasagne",500);
		ingredient3.setRecettes(listRecettes1);
		ingredient3=ingredientRepo.save(ingredient3);
		Ingredient ingredient4=new Ingredient("ail",50);
		ingredient4.setRecettes(listRecettes1);
		ingredient4=ingredientRepo.save(ingredient4);
		Ingredient ingredient5=new Ingredient("sel",2);
		ingredient5.setRecettes(listRecettes1);
		ingredient5=ingredientRepo.save(ingredient5);
		Ingredient ingredient6=new Ingredient("poivre",3);
		ingredient6.setRecettes(listRecettes1);
		ingredient6=ingredientRepo.save(ingredient6);
		Ingredient ingredient7=new Ingredient("carotte",150);
		ingredient7.setRecettes(listRecettes1);
		ingredient7=ingredientRepo.save(ingredient7);
		Ingredient ingredient8=new Ingredient("farine",100);
		ingredient8.setRecettes(listRecettes1);
		ingredient8=ingredientRepo.save(ingredient8);
		Ingredient ingredient9=new Ingredient("vin rouge",20);
		ingredient9.setRecettes(listRecettes1);
		ingredient9=ingredientRepo.save(ingredient9);
		Ingredient ingredient10=new Ingredient("purée de tomate",800);
		ingredient10.setRecettes(listRecettes1);
		ingredient10=ingredientRepo.save(ingredient10);
		Ingredient ingredient11=new Ingredient("oignon",50);
		ingredient11.setRecettes(listRecettes1);
		ingredient11=ingredientRepo.save(ingredient11);
		Ingredient ingredient12=new Ingredient("boeuf haché",600);
		ingredient12.setRecettes(listRecettes1);
		ingredient12=ingredientRepo.save(ingredient12);
		Ingredient ingredient13=new Ingredient("herbes",50);
		ingredient13.setRecettes(listRecettes1);
		ingredient13=ingredientRepo.save(ingredient13);
		Ingredient ingredient14=new Ingredient("gruyere rape",70);
		ingredient14.setRecettes(listRecettes1);
		ingredient14=ingredientRepo.save(ingredient14);
		
		
		
		
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
		
		recette1.setIngredients(ingredients1);
		recette1=recetteRepo.save(recette1);
		
		Repas repas1=new Repas();
		repas1.setTypeRepas(TypeRepas.DEJ);
		repas1=repasRepo.save(repas1);
		
		Plat plat1=new Plat();
		plat1.setNombrePersonne(8);
		
		plat1.setRepas(repas1);
		plat1 = platRepo.save(plat1);
		recette1.setPlat(plat1);
		recette1 = recetteRepo.save(recette1);
		}	
		
		/****************************************	
		****************************************	
		****************************************/
		@Test
		public void PouletRoti(){
		Recette recette1=new Recette();
		recette1.setEtapes("ÉTAPE 1\r\n"
				+ "Cette recette est extrêmement simple.\r\n"
				+ "\r\n"
				+ "ÉTAPE 2\r\n"
				+ "Il vous suffit de mettre le poulet dans un plat à four.\r\n"
				+ "\r\n"
				+ "ÉTAPE 3\r\n"
				+ "Pendant ce temps-là, préchauffer le four à 210-240°C (thermostat 7-8).\r\n"
				+ "\r\n"
				+ "ÉTAPE 4\r\n"
				+ "Prenez le beurre et découpez-le en morceaux pour le mettre sur le poulet un peu partout.\r\n"
				+ "\r\n"
				+ "ÉTAPE 5\r\n"
				+ "Salez, poivrez et herbez la bête...\r\n"
				+ "\r\n"
				+ "ÉTAPE 6\r\n"
				+ "Ensuite, attaquez-vous au patates... Il faut les éplucher et puis les faire tremper dans l'eau pour les rincer et les essuyer.\r\n"
				+ "\r\n"
				+ "ÉTAPE 7\r\n"
				+ "Il faut après les découper.\r\n"
				+ "\r\n"
				+ "ÉTAPE 8\r\n"
				+ "Alors, là, c'est comme vous le sentez... faites de jolies formes si vous le voulez, moi, je fais simplement des carrés.\r\n"
				+ "\r\n"
				+ "ÉTAPE 9\r\n"
				+ "En fait, je prends la pomme de terre, la découpe en longueur, la tourne, et puis après la découpe dans l'autre longueur et puis je la tourne dans l'autre sens pour la découper en largeur... et ça, ça fait des sortes de carrés.\r\n"
				+ "\r\n"
				+ "ÉTAPE 10\r\n"
				+ "Et je mets toutes les pommes de terres dans le plat autour du poulet. Les sale.\r\n"
				+ "\r\n"
				+ "ÉTAPE 11\r\n"
				+ "Et puis direction le four après avoir arrosé le tout d'un demi-verre d'eau.\r\n"
				+ "\r\n"
				+ "ÉTAPE 12\r\n"
				+ "Je laisse cuire 1h15... plus ou moins en fonction du poulet et des pommes de terre.\r\n"
				+ "\r\n"
				+ "ÉTAPE 13\r\n"
				+ "Je le tourne régulièrement pendant la cuisson, sur chaque face... Et puis s'il le faut je réarrose d'eau... comme ça, les pommes de terre baignent dans le jus.");
		recette1.setNom("Poulet roti");
		recette1.setNombrePers(4);
		recette1.setNote(4.7F);
//		List<TypeAlimentation> typesAlim=new ArrayList<TypeAlimentation>();
//		typesAlim.add(TypeAlimentation.NONE);
//		recette1.setTypeAlimentation(typesAlim);

		recette1.setTypeAlimentation(TypeAlimentation.NONE);
		recette1=recetteRepo.save(recette1);
		List<Recette> listRecettes1 = new ArrayList<Recette>();
		listRecettes1.add(recette1);
		recette1.setPhoto("../../assets/images/pouletroti.jpg");
		recette1=recetteRepo.save(recette1);
		
		Ingredient ingredient1=new Ingredient("pommes de terre",1000);//ingredient1 recette1
		ingredient1.setRecettes(listRecettes1);
		ingredient1=ingredientRepo.save(ingredient1);
		Ingredient ingredient2=new Ingredient("beurre",50);//ingredient2 recette1
		ingredient2.setRecettes(listRecettes1);
		ingredient2=ingredientRepo.save(ingredient2);
		Ingredient ingredient3=new Ingredient("poulet",1200);
		ingredient3.setRecettes(listRecettes1);
		ingredient3=ingredientRepo.save(ingredient3);
		Ingredient ingredient4=new Ingredient("herbes",50);
		ingredient4.setRecettes(listRecettes1);
		ingredient4=ingredientRepo.save(ingredient4);
		Ingredient ingredient5=new Ingredient("sel",2);
		ingredient5.setRecettes(listRecettes1);
		ingredient5=ingredientRepo.save(ingredient5);
		Ingredient ingredient6=new Ingredient("poivre",3);
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
		repas1.setTypeRepas(TypeRepas.DEJ);
		repas1=repasRepo.save(repas1);
		
		Plat plat1=new Plat();
		plat1.setNombrePersonne(4);
		
		plat1.setRepas(repas1);
		plat1 = platRepo.save(plat1);
		recette1.setPlat(plat1);
		recette1 = recetteRepo.save(recette1);
		}	
		
		/****************************************	
		****************************************	
		****************************************/
		@Test
		public void TagliatelleSaumon(){
		Recette recette1=new Recette();
		recette1.setEtapes("ÉTAPE 1\r\n"
				+ "\r\n"
				+ "Cuire les pâtes à l'eau bouillante salée selon le temps indiqué sur le paquet.\r\n"
				+ "\r\n"
				+ "ÉTAPE 2\r\n"
				+ "\r\n"
				+ "Pendant ce temps, faire fondre le beurre dans une casserole et y ajouter la crème.\r\n"
				+ "\r\n"
				+ "ÉTAPE 3\r\n"
				+ "\r\n"
				+ "Quand la crème est bien chaude, y plonger les dés de saumon, ils doivent cuire à la chaleur de la crème.\r\n"
				+ "\r\n"
				+ "ÉTAPE 4\r\n"
				+ "\r\n"
				+ "Quand ils sont cuits (ils doivent se détacher), ajouter le sel, le poivre et la muscade moulue.\r\n"
				+ "\r\n"
				+ "ÉTAPE 5\r\n"
				+ "Egoutter les pâtes, les disposer dans un grand plat ronde et napper de crème au saumon.\r\n"
				+ "\r\n"
				+ "ÉTAPE 6\r\n"
				+ "\r\n"
				+ "Servir avec du parmesan.");
		recette1.setNom("Tagliatelles");
		recette1.setNombrePers(5);
		recette1.setNote(4.6F);
//		List<TypeAlimentation> typesAlim=new ArrayList<TypeAlimentation>();
//		typesAlim.add(TypeAlimentation.NONE);
//		recette1.setTypeAlimentation(typesAlim);

		recette1.setTypeAlimentation(TypeAlimentation.NONE);
		recette1=recetteRepo.save(recette1);
		List<Recette> listRecettes1 = new ArrayList<Recette>();
		listRecettes1.add(recette1);
		recette1.setPhoto("../../assets/images/tagliatellesaumon.jpg");
		recette1=recetteRepo.save(recette1);
		
		Ingredient ingredient1=new Ingredient("tagliatelle",500);//ingredient1 recette1
		ingredient1.setRecettes(listRecettes1);
		ingredient1=ingredientRepo.save(ingredient1);
		Ingredient ingredient2=new Ingredient("parmesan",50);//ingredient2 recette1
		ingredient2.setRecettes(listRecettes1);
		ingredient2=ingredientRepo.save(ingredient2);
		Ingredient ingredient3=new Ingredient("saumon",250);
		ingredient3.setRecettes(listRecettes1);
		ingredient3=ingredientRepo.save(ingredient3);
		Ingredient ingredient4=new Ingredient("creme fraiche",50);
		ingredient4.setRecettes(listRecettes1);
		ingredient4=ingredientRepo.save(ingredient4);
		Ingredient ingredient5=new Ingredient("sel",2);
		ingredient5.setRecettes(listRecettes1);
		ingredient5=ingredientRepo.save(ingredient5);
		Ingredient ingredient6=new Ingredient("poivre",3);
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
		repas1.setTypeRepas(TypeRepas.DEJ);
		repas1=repasRepo.save(repas1);
		
		Plat plat1=new Plat();
		plat1.setNombrePersonne(5);
		
		plat1.setRepas(repas1);
		plat1 = platRepo.save(plat1);
		recette1.setPlat(plat1);
		recette1 = recetteRepo.save(recette1);
		}	
		
		/****************************************	
		****************************************	
		****************************************/
		@Test
		public void LotteArmoricaine(){
		Recette recette1=new Recette();
		recette1.setEtapes("ÉTAPE 1\r\n"
				+ "Pelez et hachez les 4 échalotes.\r\n"
				+ "\r\n"
				+ "ÉTAPE 2\r\n"
				+ "Pelez et pressez la gousse d'ail.\r\n"
				+ "\r\n"
				+ "ÉTAPE 3\r\n"
				+ "Pelez la douzaine d'oignons grelots.\r\n"
				+ "\r\n"
				+ "ÉTAPE 4\r\n"
				+ "Ouvrez la boîte de tomates et coupez-les.\r\n"
				+ "\r\n"
				+ "ÉTAPE 5\r\n"
				+ "Délayez le concentré de tomates dans les 20 cl de vin blanc.\r\n"
				+ "\r\n"
				+ "ÉTAPE 6\r\n"
				+ "Dans une cocotte en fonte, faites chauffer le beurre et l'huile et y faire colorer à feu vif les tranches de lotte.\r\n"
				+ "\r\n"
				+ "ÉTAPE 7\r\n"
				+ "Flambez-les avec le Cognac puis retirez et placez sur une assiette.\r\n"
				+ "\r\n"
				+ "ÉTAPE 8\r\n"
				+ "Mettez à la place les échalotes, l'ail, les oignons, les tomates et le vin dans lequel est délayé le concentré de tomates. Salez, poivrez, ajoutez le piment et laissez mijoter environ 20 min à découvert.\r\n"
				+ "\r\n"
				+ "ÉTAPE 9\r\n"
				+ "Remettez la lotte dans la sauce, couvrez et laissez cuire encore 20 min.\r\n"
				+ "\r\n"
				+ "ÉTAPE 10\r\n"
				+ "Accompagnez de légumes, pommes de terre et carottes cuites vapeur.");
		recette1.setNom("Lotte à l'armoricaine");
		recette1.setNombrePers(4);
		recette1.setNote(4.8F);
//		List<TypeAlimentation> typesAlim=new ArrayList<TypeAlimentation>();
//		typesAlim.add(TypeAlimentation.NONE);
//		recette1.setTypeAlimentation(typesAlim);

		recette1.setTypeAlimentation(TypeAlimentation.NONE);
		recette1=recetteRepo.save(recette1);
		List<Recette> listRecettes1 = new ArrayList<Recette>();
		listRecettes1.add(recette1);
		recette1.setPhoto("../../assets/images/lotte.jpg");
		recette1=recetteRepo.save(recette1);
		
		Ingredient ingredient1=new Ingredient("concentre tomate",10);//ingredient1 recette1
		ingredient1.setRecettes(listRecettes1);
		ingredient1=ingredientRepo.save(ingredient1);
		Ingredient ingredient2=new Ingredient("ail",20);//ingredient2 recette1
		ingredient2.setRecettes(listRecettes1);
		ingredient2=ingredientRepo.save(ingredient2);
		Ingredient ingredient3=new Ingredient("vin blanc",20);
		ingredient3.setRecettes(listRecettes1);
		ingredient3=ingredientRepo.save(ingredient3);
		Ingredient ingredient4=new Ingredient("cognac",5);
		ingredient4.setRecettes(listRecettes1);
		ingredient4=ingredientRepo.save(ingredient4);
		Ingredient ingredient5=new Ingredient("sel",2);
		ingredient5.setRecettes(listRecettes1);
		ingredient5=ingredientRepo.save(ingredient5);
		Ingredient ingredient6=new Ingredient("poivre",3);
		ingredient6.setRecettes(listRecettes1);
		ingredient6=ingredientRepo.save(ingredient6);
		Ingredient ingredient7=new Ingredient("piment",3);
		ingredient7.setRecettes(listRecettes1);
		ingredient7=ingredientRepo.save(ingredient7);
		Ingredient ingredient8=new Ingredient("tomate pelee",75);
		ingredient8.setRecettes(listRecettes1);
		ingredient8=ingredientRepo.save(ingredient8);
		Ingredient ingredient9=new Ingredient("lotte",600);
		ingredient9.setRecettes(listRecettes1);
		ingredient9=ingredientRepo.save(ingredient9);
		Ingredient ingredient10=new Ingredient("echalotte",20);
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
		
		recette1.setIngredients(ingredients1);
		recette1=recetteRepo.save(recette1);
		
		Repas repas1=new Repas();
		repas1.setTypeRepas(TypeRepas.DEJ);
		repas1=repasRepo.save(repas1);
		
		Plat plat1=new Plat();
		plat1.setNombrePersonne(4);
		
		plat1.setRepas(repas1);
		plat1 = platRepo.save(plat1);
		recette1.setPlat(plat1);
		recette1 = recetteRepo.save(recette1);
		}	
		
		/****************************************	
		****************************************	
		****************************************/
		@Test
		public void BurritosVegan(){
		Recette recette1=new Recette();
		recette1.setEtapes("ÉTAPE 1\r\n"
				+ "\r\n"
				+ "Commencez par faire cuire le quinoa préalablement rincé dans de l'eau additionnée d'un cube de bouillon de légumes pendant 15 minutes.\r\n"
				+ "\r\n"
				+ "ÉTAPE 2\r\n"
				+ "\r\n"
				+ "Une fois cuit, ajoutez les épices mexicain, la sauce tomate, le basilic haché, le poivre et 1cuillère à soupe de sauce soja. Réservez.\r\n"
				+ "\r\n"
				+ "ÉTAPE 3\r\n"
				+ "\r\n"
				+ "Coupez l'oignon et faites le revenir dans une poêle, ajoutez l'ail haché. Ajoutez le poivron coupé en petits morceaux. Laissez cuire une quinzaine de minutes.\r\n"
				+ "\r\n"
				+ "ÉTAPE 4\r\n"
				+ "\r\n"
				+ "Versez les haricots rouges et le maïs préalablement rincés. Versez 1 cuillère à soupe de sauce soja, le paprika et le piment. Salez et poivrez à votre convenance.\r\n"
				+ "\r\n"
				+ "ÉTAPE 5\r\n"
				+ "\r\n"
				+ "Préparez le guacamole en vidant l'avocat. Ajoutez le jus de citron, l'ail en poudre et écrasez à la fourchette. Salez et poivrez.\r\n"
				+ "\r\n"
				+ "ÉTAPE 6\r\n"
				+ "Etalez le guacamole sur une tortilla, ajoutez le mélange poivrons, haricots, maïs. Ajoutez la couche de quinoa et refermez d'un ou des deux côtés.\r\n"
				+ "\r\n"
				+ "ÉTAPE 7\r\n"
				+ "Faites cuire dans une poêle chaude non huilée en commençant par le côté avec le pli pour sceller le burrito, puis de l'autre côté pendant 3 min de chaque côté.");
		recette1.setNom("Burritos Vegan");
		recette1.setNombrePers(4);
		recette1.setNote(5F);
//		List<TypeAlimentation> typesAlim=new ArrayList<TypeAlimentation>();
//		typesAlim.add(TypeAlimentation.NONE);
//		recette1.setTypeAlimentation(typesAlim);

		recette1.setTypeAlimentation(TypeAlimentation.VEGAN);
		recette1=recetteRepo.save(recette1);
		List<Recette> listRecettes1 = new ArrayList<Recette>();
		listRecettes1.add(recette1);
		recette1.setPhoto("../../assets/images/burritosvegan.jpg");
		recette1=recetteRepo.save(recette1);
		
		Ingredient ingredient1=new Ingredient("poivron",75);//ingredient1 recette1
		ingredient1.setRecettes(listRecettes1);
		ingredient1=ingredientRepo.save(ingredient1);
		Ingredient ingredient2=new Ingredient("ail",20);//ingredient2 recette1
		ingredient2.setRecettes(listRecettes1);
		ingredient2=ingredientRepo.save(ingredient2);
		Ingredient ingredient3=new Ingredient("quinoa",250);
		ingredient3.setRecettes(listRecettes1);
		ingredient3=ingredientRepo.save(ingredient3);
		Ingredient ingredient4=new Ingredient("citron",5);
		ingredient4.setRecettes(listRecettes1);
		ingredient4=ingredientRepo.save(ingredient4);
		Ingredient ingredient5=new Ingredient("sel",2);
		ingredient5.setRecettes(listRecettes1);
		ingredient5=ingredientRepo.save(ingredient5);
		Ingredient ingredient6=new Ingredient("poivre",3);
		ingredient6.setRecettes(listRecettes1);
		ingredient6=ingredientRepo.save(ingredient6);
		Ingredient ingredient7=new Ingredient("epices",3);
		ingredient7.setRecettes(listRecettes1);
		ingredient7=ingredientRepo.save(ingredient7);
		Ingredient ingredient8=new Ingredient("sauce tomate",20);
		ingredient8.setRecettes(listRecettes1);
		ingredient8=ingredientRepo.save(ingredient8);
		Ingredient ingredient9=new Ingredient("haricots",500);
		ingredient9.setRecettes(listRecettes1);
		ingredient9=ingredientRepo.save(ingredient9);
		Ingredient ingredient10=new Ingredient("mais",500);
		ingredient10.setRecettes(listRecettes1);
		ingredient10=ingredientRepo.save(ingredient10);
		Ingredient ingredient11=new Ingredient("galette de ble",150);
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
		repas1.setTypeRepas(TypeRepas.DEJ);
		repas1=repasRepo.save(repas1);
		
		Plat plat1=new Plat();
		plat1.setNombrePersonne(4);
		
		plat1.setRepas(repas1);
		plat1 = platRepo.save(plat1);
		recette1.setPlat(plat1);
		recette1 = recetteRepo.save(recette1);
		}
		
		
/********************************************************************************************************************		
*****************************************DINER**********************************************************************
********************************************************************************************************************/	
		
		@Test
		public void PotAuFeu(){
		Recette recette1=new Recette();
		recette1.setEtapes("ÉTAPE 1\r"
				+ "Ficelez les morceaux de viande pour qu'ils se maintiennent en forme pendant \rla cuisson et, s'il y en a, coupez la queue de boeuf en tronçons.\r"
				+ "ÉTAPE 2\r"
				+ "Épluchez les carottes, les poireaux et la branche de céleri, puis lavez-les.\r"
				+ "ÉTAPE 3\r"
				+ "Piquez un oignon avec les clous de girofle et faites dorer le second, à sec, \rau four : il colorera le bouillon (pour colorer le bouillon, ajouter 1/2 cuillerée à \rcafé d’arôme Patrelle).\r"
				+ "ÉTAPE 4\r"
				+ "Mettez dans un faitout tous les morceaux de viande et l’os à moelle, \rpréalablement enveloppé dans une mousseline pour éviter que la moelle ne \rse répande. Mouillez avec 5 litres d'eau froide.\r"
				+ "ÉTAPE 5\r"
				+ "Salez au gros sel. Portez à ébullition et laissez bouillir, en ayant soin \rd'écumer souvent, jusqu'à ce qu'il ne se forme plus d'écume.\r"
				+ "ÉTAPE 6\r"
				+ "Ajoutez-y les oignons, les carottes, les poireaux (liés en botte), le céleri \rbranche, l’ail et le bouquet garni, préalablement ficelé. Ajoutez 12 grains \rde poivre.\r"
				+ "ÉTAPE 7\r"
				+ "Portez de nouveau à ébullition, puis laissez cuire, à couvert (la vapeur doit \rpouvoir s'échapper sur le côté), sur feu très doux, pendant au moins 4 \rheures.\r"
				+ "ÉTAPE 8\r"
				+ "Dégraisser en cours de cuisson avec une petite louche.\r"
				+ "ÉTAPE 9\r"
				+ "Le bouillon du au-feu se consomme chaud ou tiède, en précédant les \rviandes et les légumes ou seul. Il peut aussi être la base de divers potages.\r"
				+ "ÉTAPE 10\r"
				+ "Quant aux morceaux de viande et aux légumes, retirez-les du bouillon et \rdressez-les dans un plat chaud. Servez-les aussitôt, avec des cornichons, \rdu gros sel et de la moutarde forte.");
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
		repas1.setTypeRepas(TypeRepas.DINER);
		repas1=repasRepo.save(repas1);
		
		Plat plat1=new Plat();
		plat1.setNombrePersonne(4);
		
		plat1.setRepas(repas1);
		plat1 = platRepo.save(plat1);
		recette1.setPlat(plat1);
		recette1 = recetteRepo.save(recette1);
		}
		
/********************************************************************************************************************	
********************************************************************************************************************	2
********************************************************************************************************************/	
		
		
		@Test
		public void EnchiladdasHalal(){
		Recette recette1=new Recette();
		recette1.setEtapes("Préparation de la sauce béchamel\r\n"
				+ " ÉTAPE 1\r\n"
				+ "Faites fondre le beurre, ajoutez la farine, mélangez avec un\rfouet, puis versez le lait en continuant à mélanger pour éviter la formation de grumeaux.\r\n"
				+ "ÉTAPE 2\r\n"
				+ "Salez et poivrez, ajoutez une pincée de noix de muscade râpée,\ramenez le tout à ébullition et laissez cuire quelques minutes en mélangeant jusqu'à obtenir une sauce. Retirez du feu dès que ça commence à s'épaissir.\r\n"
                + "ÉTAPE 3\r\n"
				+ "Préparation de la farce\r\n"
				+ "Faites revenir l'oignon et l'ail dans une sauteuse avec l'huile.\rQuand l'oignon devient translucide, ajoutez les lardons de Poulet fumés Isla Délice.\r\n"
				+ "ÉTAPE 4\r\n"
				+ "Ajoutez le concentré de tomate, la purée de piment et la pulpe de\rtomate. Salez et poivrez.\r\n"
				+ "ÉTAPE 5\r\n"
				+ "Portez à ébullition, baissez le feu et laissez mijoter 10 minutes.\rSaupoudrez de persil et mélangez.\r\n"
				+ "ÉTAPE 6\r\n"
				+ "Préparation des iladas\r\n"
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
				+ "Faites cuire 15 minutes au four, jusqu'à faire dorer un peu le\rfromage. Servez chaud avec une salade verte.");
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
		recette1.setPhoto("../../assets/images/iladasHalal.jpg");
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
		Ingredient ingredient8=new Ingredient("pulpe de tomates",150);
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
		Ingredient ingredient16=new Ingredient("lardons de poulet",200);
		ingredient16.setRecettes(listRecettes1);
		ingredient16=ingredientRepo.save(ingredient16);
		
		
		
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
		ingredients1.add(ingredient16);
		ingredient16.setRecettes(listRecettes1);
		recette1.setIngredients(ingredients1);
		recette1=recetteRepo.save(recette1);
		
		Repas repas1=new Repas();
		repas1.setTypeRepas(TypeRepas.DINER);
		repas1=repasRepo.save(repas1);
		
		Plat plat1=new Plat();
		plat1.setNombrePersonne(4);
	
		plat1.setRepas(repas1);
		plat1 = platRepo.save(plat1);
		recette1.setPlat(plat1);
		recette1 = recetteRepo.save(recette1);
		}
		/********************************************************************************************************************	
		********************************************************************************************************************	
		********************************************************************************************************************/	
		@Test
		public void PouletCurry(){
		Recette recette1=new Recette();
		recette1.setEtapes("ÉTAPE 1\r\n"
				+ "Pour la préparation de la purée:\r\n"
				+ "\r\n"
				+ "ÉTAPE 2\r\n"
				+ "Faire cuire les carottes dans de l'eau en ébullition\rpendant 25 min (pour qu'elles soient bien tendres).\r\n"
				+ "\r\n"
				+ "ÉTAPE 3\r\n"
				+ "Faire cuire à feu très doux courgette et poireaux\rpendant 25 min.\r\n"
				+ "\r\n"
				+ "ÉTAPE 4\r\n"
				+ "Une fois le tout cuit, mixer poireaux, carottes et\rcourgette.\r\n"
				+ "\r\n"
				+ "ÉTAPE 5\r\n"
				+ "Ajouter les épices.\r\n"
				+ "\r\n"
				+ "ÉTAPE 6\r\n"
				+ "Pour le poulet:\r\n"
				+ "\r\n"
				+ "ÉTAPE 7\r\n"
				+ "Dans une noisette de beurre, faire cuire le poulet\rcoupé en petits morceaux à feu moyen, pendant 20 min.\r\n"
				+ "\r\n"
				+ "ÉTAPE 8\r\n"
				+ "A la fin de la cuisson, ajouter la crème fraiche,\rle curry et la Maïzena.");
		recette1.setNom("Poulet au curry");
		recette1.setNombrePers(2);
		recette1.setNote(4F);
//		List<TypeAlimentation> typesAlim=new ArrayList<TypeAlimentation>();
//		typesAlim.add(TypeAlimentation.NONE);
//		typesAlim.add(TypeAlimentation.HALAL);
//		recette1.setTypeAlimentation(typesAlim);
		recette1.setTypeAlimentation(TypeAlimentation.NONE);
		recette1=recetteRepo.save(recette1);
		List<Recette> listRecettes1 = new ArrayList<Recette>();
		listRecettes1.add(recette1);	
		recette1.setPhoto("../../assets/images/pouletcurry.jpg");
		recette1=recetteRepo.save(recette1);
		
		Ingredient ingredient1=new Ingredient("poireau",400);//ingredient1 recette1
		ingredient1.setRecettes(listRecettes1);
		ingredient1=ingredientRepo.save(ingredient1);
		Ingredient ingredient2=new Ingredient("carotte",300);//ingredient2 recette1
		ingredient2.setRecettes(listRecettes1);
		ingredient2=ingredientRepo.save(ingredient2);
		Ingredient ingredient3=new Ingredient("courgette",350);
		ingredient3.setRecettes(listRecettes1);
		ingredient3=ingredientRepo.save(ingredient3);
		Ingredient ingredient4=new Ingredient("sel",1);
		ingredient4.setRecettes(listRecettes1);
		ingredient4=ingredientRepo.save(ingredient4);
		Ingredient ingredient5=new Ingredient("poivre",1);
		ingredient5.setRecettes(listRecettes1);
		ingredient5=ingredientRepo.save(ingredient5);
		Ingredient ingredient6=new Ingredient("curry",1);
		ingredient6.setRecettes(listRecettes1);
		ingredient6=ingredientRepo.save(ingredient6);
		Ingredient ingredient7=new Ingredient("poulet",1200);
		ingredient7.setRecettes(listRecettes1);
		ingredient7=ingredientRepo.save(ingredient7);
				
		
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
		
		recette1=recetteRepo.save(recette1);
		
		Repas repas1=new Repas();
		repas1.setTypeRepas(TypeRepas.DINER);
		repas1=repasRepo.save(repas1);
		
		Plat plat1=new Plat();
		plat1.setNombrePersonne(2);
	
		plat1.setRepas(repas1);
		plat1 = platRepo.save(plat1);
		recette1.setPlat(plat1);
		recette1 = recetteRepo.save(recette1);
		}
		/********************************************************************************************************************	
		********************************************************************************************************************	
		********************************************************************************************************************/
		@Test
		public void Quiche(){
		Recette recette1=new Recette();
		recette1.setEtapes("ÉTAPE 1\r\n"
				+ "Mixez tous les ingrédients sauf le jambon, le découper en morceaux et mélanger ensuite avec le reste.\r\n"
				+ "\r\n"
				+ "ÉTAPE 2\r\n"
				+ "Placez dans un plat a tarte beurré et faites cuire une demi-heure à 200°C.");
		recette1.setNom("Quiche");
		recette1.setNombrePers(4);
		recette1.setNote(4.7F);
//		List<TypeAlimentation> typesAlim=new ArrayList<TypeAlimentation>();
//		typesAlim.add(TypeAlimentation.NONE);
//		typesAlim.add(TypeAlimentation.HALAL);
//		recette1.setTypeAlimentation(typesAlim);
		recette1.setTypeAlimentation(TypeAlimentation.NONE);
		recette1=recetteRepo.save(recette1);
		List<Recette> listRecettes1 = new ArrayList<Recette>();
		listRecettes1.add(recette1);	
		recette1.setPhoto("../../assets/images/quiche.jpg");
		recette1=recetteRepo.save(recette1);
		
		Ingredient ingredient1=new Ingredient("sel",1);//ingredient1 recette1
		ingredient1.setRecettes(listRecettes1);
		ingredient1=ingredientRepo.save(ingredient1);
		Ingredient ingredient2=new Ingredient("poivre",1);//ingredient2 recette1
		ingredient2.setRecettes(listRecettes1);
		ingredient2=ingredientRepo.save(ingredient2);
		Ingredient ingredient3=new Ingredient("jambon",200);
		ingredient3.setRecettes(listRecettes1);
		ingredient3=ingredientRepo.save(ingredient3);
		Ingredient ingredient4=new Ingredient("farine",50);
		ingredient4.setRecettes(listRecettes1);
		ingredient4=ingredientRepo.save(ingredient4);
		Ingredient ingredient5=new Ingredient("lait",250);
		ingredient5.setRecettes(listRecettes1);
		ingredient5=ingredientRepo.save(ingredient5);
		Ingredient ingredient6=new Ingredient("oeuf",3);
		ingredient6.setRecettes(listRecettes1);
		ingredient6=ingredientRepo.save(ingredient6);
		Ingredient ingredient7=new Ingredient("creme fraiche",100);
		ingredient7.setRecettes(listRecettes1);
		ingredient7=ingredientRepo.save(ingredient7);
		Ingredient ingredient8=new Ingredient("gruyere rape",100);
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
		
		recette1=recetteRepo.save(recette1);
		
		Repas repas1=new Repas();
		repas1.setTypeRepas(TypeRepas.DINER);
		repas1=repasRepo.save(repas1);
		
		Plat plat1=new Plat();
		plat1.setNombrePersonne(2);
	
		plat1.setRepas(repas1);
		plat1 = platRepo.save(plat1);
		recette1.setPlat(plat1);
		recette1 = recetteRepo.save(recette1);
		}
		/********************************************************************************************************************	
		********************************************************************************************************************	
		********************************************************************************************************************/	
		@Test
		public void SaladeLentille(){
		Recette recette1=new Recette();
		recette1.setEtapes("ÉTAPE 1\r\n"
				+ "Faire cuire les lentilles comme indiqué sur leur emballage (en générale 30 min dans l'eau froide à partir du bouillonnement de l'eau). Laissez les refroidir, pour aller plus vite, vous pouvez les passées sous l'eau froide.\r\n"
				+ "\r\n"
				+ "ÉTAPE 2\r\n"
				+ "Préparez la vinaigrette.\r\n"
				+ "\r\n"
				+ "ÉTAPE 3\r\n"
				+ "Faites revenir les allumettes de lardons.\r\n"
				+ "\r\n"
				+ "ÉTAPE 4\r\n"
				+ "Coupez les tomates en quartier assez fin (plus agréable en bouche) ainsi que la feta en dès.\r\n"
				+ "\r\n"
				+ "ÉTAPE 5\r\n"
				+ "Ajoutez les lentilles une fois froide ainsi que les lardons, la feta et les tomates dans votre vinaigrette.");
		recette1.setNom("Salade aux lentilles");
		recette1.setNombrePers(2);
		recette1.setNote(4.9F);
//		List<TypeAlimentation> typesAlim=new ArrayList<TypeAlimentation>();
//		typesAlim.add(TypeAlimentation.NONE);
//		typesAlim.add(TypeAlimentation.HALAL);
//		recette1.setTypeAlimentation(typesAlim);
		recette1.setTypeAlimentation(TypeAlimentation.NONE);
		recette1=recetteRepo.save(recette1);
		List<Recette> listRecettes1 = new ArrayList<Recette>();
		listRecettes1.add(recette1);	
		recette1.setPhoto("../../assets/images/saladelentille.jpg");
		recette1=recetteRepo.save(recette1);
		
		Ingredient ingredient1=new Ingredient("sel",1);//ingredient1 recette1
		ingredient1.setRecettes(listRecettes1);
		ingredient1=ingredientRepo.save(ingredient1);
		Ingredient ingredient2=new Ingredient("poivre",1);//ingredient2 recette1
		ingredient2.setRecettes(listRecettes1);
		ingredient2=ingredientRepo.save(ingredient2);
		Ingredient ingredient3=new Ingredient("lardon",100);
		ingredient3.setRecettes(listRecettes1);
		ingredient3=ingredientRepo.save(ingredient3);
		Ingredient ingredient4=new Ingredient("tomate",100);
		ingredient4.setRecettes(listRecettes1);
		ingredient4=ingredientRepo.save(ingredient4);
		Ingredient ingredient5=new Ingredient("feta",125);
		ingredient5.setRecettes(listRecettes1);
		ingredient5=ingredientRepo.save(ingredient5);
		Ingredient ingredient6=new Ingredient("lentille",120);
		ingredient6.setRecettes(listRecettes1);
		ingredient6=ingredientRepo.save(ingredient6);
		Ingredient ingredient7=new Ingredient("curry",10);
		ingredient7.setRecettes(listRecettes1);
		ingredient7=ingredientRepo.save(ingredient7);
		Ingredient ingredient8=new Ingredient("miel",10);
		ingredient8.setRecettes(listRecettes1);
		ingredient8=ingredientRepo.save(ingredient8);
		Ingredient ingredient9=new Ingredient("huile de tournesol",20);
		ingredient9.setRecettes(listRecettes1);
		ingredient9=ingredientRepo.save(ingredient9);
		Ingredient ingredient10=new Ingredient("vinaigre balsamique",15);
		ingredient10.setRecettes(listRecettes1);
		ingredient10=ingredientRepo.save(ingredient10);
		Ingredient ingredient11=new Ingredient("huile de noisette",15);
		ingredient11.setRecettes(listRecettes1);
		ingredient11=ingredientRepo.save(ingredient11);
		Ingredient ingredient12=new Ingredient("echalotte",1);
		ingredient12.setRecettes(listRecettes1);
		ingredient12=ingredientRepo.save(ingredient12);
		
				
		
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
		recette1=recetteRepo.save(recette1);
		
		Repas repas1=new Repas();
		repas1.setTypeRepas(TypeRepas.DINER);
		repas1=repasRepo.save(repas1);
		
		Plat plat1=new Plat();
		plat1.setNombrePersonne(2);
	
		plat1.setRepas(repas1);
		plat1 = platRepo.save(plat1);
		recette1.setPlat(plat1);
		recette1 = recetteRepo.save(recette1);
		}
		/********************************************************************************************************************	
		********************************************************************************************************************	
		********************************************************************************************************************/
		@Test
		public void PateCarbo(){
		Recette recette1=new Recette();
		recette1.setEtapes("ÉTAPE 1\r\n"
				+ "Faire cuire les pâtes dans une grande casserole d'eau salée, le temps indiqué sur le paquet.\r\n"
				+ "\r\n"
				+ "ÉTAPE 2\r\n"
				+ "Pendant ce temps, casser les oeufs dans un récipient, ajouter le parmesan râpé, et battre le tout; saler et poivrer.\r\n"
				+ "\r\n"
				+ "ÉTAPE 3\r\n"
				+ "Faire cuire les lardons.\r\n"
				+ "\r\n"
				+ "ÉTAPE 4\r\n"
				+ "Une fois les pâtes cuites, les égoutter, mais pas trop (toujours garder un peu d'eau pour les pâtes en sauce).\r\n"
				+ "\r\n"
				+ "ÉTAPE 5\r\n"
				+ "Ajouter les lardons, avec leur jus de cuisson, porter à feu très doux et y ajouter la préparation (oeuf, parmesan) en remuant sans arrêt.\r\n"
				+ "\r\n"
				+ "ÉTAPE 6\r\n"
				+ "Eteindre le feu avant que la préparation devienne trop sèche !\r\n"
				+ "\r\n"
				+ "ÉTAPE 7\r\n"
				+ "Servir chaud, avec un peu de parmesan râpé en plus.");
		recette1.setNom("Pâtes carbonara");
		recette1.setNombrePers(6);
		recette1.setNote(4.2F);
//		List<TypeAlimentation> typesAlim=new ArrayList<TypeAlimentation>();
//		typesAlim.add(TypeAlimentation.NONE);
//		typesAlim.add(TypeAlimentation.HALAL);
//		recette1.setTypeAlimentation(typesAlim);
		recette1.setTypeAlimentation(TypeAlimentation.NONE);
		recette1=recetteRepo.save(recette1);
		List<Recette> listRecettes1 = new ArrayList<Recette>();
		listRecettes1.add(recette1);	
		recette1.setPhoto("../../assets/images/patecarbo.jpg");
		recette1=recetteRepo.save(recette1);
		
		Ingredient ingredient1=new Ingredient("sel",1);//ingredient1 recette1
		ingredient1.setRecettes(listRecettes1);
		ingredient1=ingredientRepo.save(ingredient1);
		Ingredient ingredient2=new Ingredient("poivre",1);//ingredient2 recette1
		ingredient2.setRecettes(listRecettes1);
		ingredient2=ingredientRepo.save(ingredient2);
		Ingredient ingredient3=new Ingredient("lardon",250);
		ingredient3.setRecettes(listRecettes1);
		ingredient3=ingredientRepo.save(ingredient3);
		Ingredient ingredient4=new Ingredient("parmesan",100);
		ingredient4.setRecettes(listRecettes1);
		ingredient4=ingredientRepo.save(ingredient4);
		Ingredient ingredient5=new Ingredient("spaghetti",500);
		ingredient5.setRecettes(listRecettes1);
		ingredient5=ingredientRepo.save(ingredient5);
		Ingredient ingredient6=new Ingredient("oeuf",6);
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
		
		recette1=recetteRepo.save(recette1);
		
		Repas repas1=new Repas();
		repas1.setTypeRepas(TypeRepas.DINER);
		repas1=repasRepo.save(repas1);
		
		Plat plat1=new Plat();
		plat1.setNombrePersonne(6);
	
		plat1.setRepas(repas1);
		plat1 = platRepo.save(plat1);
		recette1.setPlat(plat1);
		recette1 = recetteRepo.save(recette1);
		}
		
		/********************************************************************************************************************	
		********************************************************************************************************************	
		********************************************************************************************************************/
		@Test
		public void CroqueMonsieur(){
		Recette recette1=new Recette();
		recette1.setEtapes("ÉTAPE 1\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "Beurrez les 8 tranches de pain de mie sur une seule face. Posez 1 tranche de fromage sur chaque tranche de pain de mie. Posez 1 tranche de jambon plié en deux sur 4 tranches de pain de mie. Recouvrez avec les autres tartines (face non beurrée au dessus).\r\n"
				+ "\r\n"
				+ "ÉTAPE 2\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "Dans un bol mélanger le fromage râpé avec le lait, le sel, le poivre et la muscade.\r\n"
				+ "\r\n"
				+ "ÉTAPE 3\r\n"
				+ "Répartissez le mélange sur les croque-monsieur.\r\n"
				+ "\r\n"
				+ "ÉTAPE 4\r\n"
				+ "Placez sur une plaque au four sous le grill pendant 10 mn.");
		recette1.setNom("Croque Monsieur");
		recette1.setNombrePers(4);
		recette1.setNote(4.5F);
//		List<TypeAlimentation> typesAlim=new ArrayList<TypeAlimentation>();
//		typesAlim.add(TypeAlimentation.NONE);
//		typesAlim.add(TypeAlimentation.HALAL);
//		recette1.setTypeAlimentation(typesAlim);
		recette1.setTypeAlimentation(TypeAlimentation.NONE);
		recette1=recetteRepo.save(recette1);
		List<Recette> listRecettes1 = new ArrayList<Recette>();
		listRecettes1.add(recette1);	
		recette1.setPhoto("../../assets/images/croquemonsieur.jpg");
		recette1=recetteRepo.save(recette1);
		
		Ingredient ingredient1=new Ingredient("sel",1);//ingredient1 recette1
		ingredient1.setRecettes(listRecettes1);
		ingredient1=ingredientRepo.save(ingredient1);
		Ingredient ingredient2=new Ingredient("poivre",1);//ingredient2 recette1
		ingredient2.setRecettes(listRecettes1);
		ingredient2=ingredientRepo.save(ingredient2);
		Ingredient ingredient3=new Ingredient("jambon",250);
		ingredient3.setRecettes(listRecettes1);
		ingredient3=ingredientRepo.save(ingredient3);
		Ingredient ingredient4=new Ingredient("tranche de pain",350);
		ingredient4.setRecettes(listRecettes1);
		ingredient4=ingredientRepo.save(ingredient4);
		Ingredient ingredient5=new Ingredient("lait",50);
		ingredient5.setRecettes(listRecettes1);
		ingredient5=ingredientRepo.save(ingredient5);
		Ingredient ingredient6=new Ingredient("beurre",50);
		ingredient6.setRecettes(listRecettes1);
		ingredient6=ingredientRepo.save(ingredient6);
		Ingredient ingredient7=new Ingredient("noix de muscade",10);
		ingredient7.setRecettes(listRecettes1);
		ingredient7=ingredientRepo.save(ingredient7);
		Ingredient ingredient8=new Ingredient("fromage",150);
		ingredient8.setRecettes(listRecettes1);
		ingredient8=ingredientRepo.save(ingredient8);
		Ingredient ingredient9=new Ingredient("gruyere rape",100);
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
		
		recette1=recetteRepo.save(recette1);
		
		Repas repas1=new Repas();
		repas1.setTypeRepas(TypeRepas.DINER);
		repas1=repasRepo.save(repas1);
		
		Plat plat1=new Plat();
		plat1.setNombrePersonne(4);
	
		plat1.setRepas(repas1);
		plat1 = platRepo.save(plat1);
		recette1.setPlat(plat1);
		recette1 = recetteRepo.save(recette1);
		}
		
		/********************************************************************************************************************	
		********************************************************************************************************************	
		********************************************************************************************************************/
		@Test
		public void SaladeCesar(){
		Recette recette1=new Recette();
		recette1.setEtapes("ÉTAPE 1\r\n"
				+ "Faites dorer le pain, coupé en cubes, 3 min dans un peu d'huile.\r\n"
				+ "\r\n"
				+ "ÉTAPE 2\r\n"
				+ "Déchirez les feuilles de romaine dans un saladier, et ajoutez les croûtons préalablement épongés dans du papier absorbant.\r\n"
				+ "\r\n"
				+ "ÉTAPE 3\r\n"
				+ "Préparez la sauce : Faites cuire l'oeuf 1 min 30 dans l'eau bouillante, et rafraîchissez-le.\r\n"
				+ "\r\n"
				+ "ÉTAPE 4\r\n"
				+ "Cassez-le dans le bol d'un mixeur et mixez, avec tous les autres ingrédients; rectifiez l'assaissonnement et incorporez à la salade.\r\n"
				+ "\r\n"
				+ "ÉTAPE 5\r\n"
				+ "Décorez de copeaux de parmesan, et servez.");
		recette1.setNom("Salade Cesar");
		recette1.setNombrePers(4);
		recette1.setNote(4.6F);
//		List<TypeAlimentation> typesAlim=new ArrayList<TypeAlimentation>();
//		typesAlim.add(TypeAlimentation.NONE);
//		typesAlim.add(TypeAlimentation.HALAL);
//		recette1.setTypeAlimentation(typesAlim);
		recette1.setTypeAlimentation(TypeAlimentation.NONE);
		recette1=recetteRepo.save(recette1);
		List<Recette> listRecettes1 = new ArrayList<Recette>();
		listRecettes1.add(recette1);	
		recette1.setPhoto("../../assets/images/salsadecesar.jpg");
		recette1=recetteRepo.save(recette1);
		
		Ingredient ingredient1=new Ingredient("sel",1);//ingredient1 recette1
		ingredient1.setRecettes(listRecettes1);
		ingredient1=ingredientRepo.save(ingredient1);
		Ingredient ingredient2=new Ingredient("poivre",1);//ingredient2 recette1
		ingredient2.setRecettes(listRecettes1);
		ingredient2=ingredientRepo.save(ingredient2);
		Ingredient ingredient3=new Ingredient("parmesan",25);
		ingredient3.setRecettes(listRecettes1);
		ingredient3=ingredientRepo.save(ingredient3);
		Ingredient ingredient4=new Ingredient("câpres",15);
		ingredient4.setRecettes(listRecettes1);
		ingredient4=ingredientRepo.save(ingredient4);
		Ingredient ingredient5=new Ingredient("moutarde",20);
		ingredient5.setRecettes(listRecettes1);
		ingredient5=ingredientRepo.save(ingredient5);
		Ingredient ingredient6=new Ingredient("tabasco",5);
		ingredient6.setRecettes(listRecettes1);
		ingredient6=ingredientRepo.save(ingredient6);
		Ingredient ingredient7=new Ingredient("citron",10);
		ingredient7.setRecettes(listRecettes1);
		ingredient7=ingredientRepo.save(ingredient7);
		Ingredient ingredient8=new Ingredient("ail",15);
		ingredient8.setRecettes(listRecettes1);
		ingredient8=ingredientRepo.save(ingredient8);
		Ingredient ingredient9=new Ingredient("huile",15);
		ingredient9.setRecettes(listRecettes1);
		ingredient9=ingredientRepo.save(ingredient9);
		Ingredient ingredient10=new Ingredient("oeuf",15);
		ingredient10.setRecettes(listRecettes1);
		ingredient10=ingredientRepo.save(ingredient10);
		Ingredient ingredient11=new Ingredient("laitue",200);
		ingredient11.setRecettes(listRecettes1);
		ingredient11=ingredientRepo.save(ingredient11);	
		Ingredient ingredient12=new Ingredient("pain",200);
		ingredient12.setRecettes(listRecettes1);
		ingredient12=ingredientRepo.save(ingredient12);
		
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
		recette1=recetteRepo.save(recette1);
		
		Repas repas1=new Repas();
		repas1.setTypeRepas(TypeRepas.DINER);
		repas1=repasRepo.save(repas1);
		
		Plat plat1=new Plat();
		plat1.setNombrePersonne(4);
	
		plat1.setRepas(repas1);
		plat1 = platRepo.save(plat1);
		recette1.setPlat(plat1);
		recette1 = recetteRepo.save(recette1);
		}
}
