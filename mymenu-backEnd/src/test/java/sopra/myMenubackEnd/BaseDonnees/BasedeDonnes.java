base de donnees dejeuner apres tartiflette :      @Test
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