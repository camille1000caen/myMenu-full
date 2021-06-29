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
	plat1.setRecette(recette1);
	plat1.setRepas(repas1);
	plat1 = platRepo.save(plat1);
	}
	
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
		plat1.setNombrePersonne(4);
		plat1.setRecette(recette1);
		plat1.setRepas(repas1);
		plat1 = platRepo.save(plat1);
		}
		
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
		plat1.setNombrePersonne(4);
		plat1.setRecette(recette1);
		plat1.setRepas(repas1);
		plat1 = platRepo.save(plat1);
		}
		
		
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
		plat1.setNombrePersonne(4);
		plat1.setRecette(recette1);
		plat1.setRepas(repas1);
		plat1 = platRepo.save(plat1);
		}
}
