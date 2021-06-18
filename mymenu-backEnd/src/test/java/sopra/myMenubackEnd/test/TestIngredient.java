package sopra.myMenubackEnd.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.support.ClassPathXmlApplicationContext;


import sopra.myMenubackEnd.model.Ingredient;
import sopra.myMenubackEnd.model.ProduitSaison;
import sopra.myMenubackEnd.model.TypeProduit;
import sopra.myMenubackEnd.repository.IIngredientRepository;

@SpringBootTest
public class TestIngredient {
	@Autowired
	IIngredientRepository ingRepo;
	@Test	
	public void IngredientCreate() {
		
//			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
//				"classpath:application-context.xml");
//			IIngredientRepository ingRepo = context.getBean(IIngredientRepository.class);
		
		Ingredient  ing1 = new Ingredient ();
		ing1.setNom("poulet");
		ing1.setQuantite((Float)200F);
		ing1.setNombreCalories100g((Float)300F);
		ing1.setProduitSaison(ProduitSaison.ETE);
		ing1.setTypeProduit(TypeProduit.VIANDE);		
			
		ing1 = ingRepo.save(ing1);
		
		Ingredient  ingFind = ingRepo.findById(ing1.getId()).get();
		try {
		assertEquals("poulet", ingFind.getNom());
		assertEquals((Float)200F, ingFind.getQuantite());
		assertEquals( (Float)300F, ingFind.getNombreCalories100g());
		assertEquals(ProduitSaison.ETE, ingFind.getProduitSaison());
		assertEquals(TypeProduit.VIANDE, ingFind.getTypeProduit());
		}finally {
		
				
		ingRepo.delete(ing1);
//		context.close();
		
	}}
	
	@Test	
	public void IngredientUpdate() {
		
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
//				"classpath:application-context.xml");
//			IIngredientRepository ingRepo = context.getBean(IIngredientRepository.class);
		
		Ingredient  ing1 = new Ingredient();
		
		ing1.setNom("tomate");
		ing1.setQuantite((Float)100F);
		ing1.setNombreCalories100g((Float)10F);
		ing1.setProduitSaison(ProduitSaison.ETE);
		ing1.setTypeProduit(TypeProduit.VIANDE);	
		
		ing1 = ingRepo.save(ing1);
		
							
		ing1.setNom("poulet");
		ing1.setQuantite((Float)200F);
		ing1.setNombreCalories100g((Float)300F);
		ing1.setProduitSaison(ProduitSaison.HIVER);
		ing1.setTypeProduit(TypeProduit.LEGUMES);	
			
		ing1 = ingRepo.save(ing1);
		Ingredient ingFind = ingRepo.findById(ing1.getId()).get();
		try {
		assertEquals("poulet", ingFind.getNom());
		assertEquals((Float)200F, ingFind.getQuantite());
		assertEquals( (Float)300F, ingFind.getNombreCalories100g());
		assertEquals(ProduitSaison.HIVER, ingFind.getProduitSaison());
		assertEquals(TypeProduit.LEGUMES, ingFind.getTypeProduit());
		
		}finally {		
		ingRepo.delete(ing1);
		//context.close();
	}
	}
	@Test
	public void IngredientFindAll() {
		
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
//				"classpath:application-context.xml");
//			IIngredientRepository ingRepo = context.getBean(IIngredientRepository.class);
		
		Ingredient  ing1 = new Ingredient ();
						
		Ingredient  ing2 = new Ingredient ();
		
		Ingredient  ing3 = new Ingredient ();
		
		ing1.setNom("tomate");
		ing1.setQuantite((Float)100F);
		ing1.setNombreCalories100g((Float)10F);
		ing1.setProduitSaison(ProduitSaison.ETE);
		ing1.setTypeProduit(TypeProduit.VIANDE);
		
		ing2.setNom("poulet");
		ing2.setQuantite((Float)200F);
		ing2.setNombreCalories100g((Float)300F);
		ing2.setProduitSaison(ProduitSaison.HIVER);
		ing2.setTypeProduit(TypeProduit.LEGUMES);	
		
		ing3.setNom("coca");
		ing3.setQuantite((Float)20F);
		ing3.setNombreCalories100g((Float)300F);
		ing3.setProduitSaison(ProduitSaison.ETE);
		ing3.setTypeProduit(TypeProduit.BOISSON);

		ing1 = ingRepo.save(ing1);
		ing2 = ingRepo.save(ing2);
		ing3 = ingRepo.save(ing3);
			
		
		List<Ingredient> ingredients  = ingRepo.findAll();
		try {
		assertEquals(3, ingredients.size());
		}finally {
		ingRepo.delete(ing1);
		ingRepo.delete(ing2);
		ingRepo.delete(ing3);
			
		
	}}
	

	@Test
	public void IngredientDelete() {
		
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
//				"classpath:application-context.xml");
//			IIngredientRepository ingRepo = context.getBean(IIngredientRepository.class);
		
		Ingredient  ing1 = new Ingredient ();
						
		Ingredient  ing2 = new Ingredient ();
		
		Ingredient  ing3 = new Ingredient ();
		
		ing1.setNom("tomate");
		ing1.setQuantite((Float)100F);
		ing1.setNombreCalories100g((Float)10F);
		ing1.setProduitSaison(ProduitSaison.ETE);
		ing1.setTypeProduit(TypeProduit.VIANDE);
		
		ing2.setNom("poulet");
		ing2.setQuantite((Float)200F);
		ing2.setNombreCalories100g((Float)300F);
		ing2.setProduitSaison(ProduitSaison.HIVER);
		ing2.setTypeProduit(TypeProduit.LEGUMES);	
		
		ing3.setNom("coca");
		ing3.setQuantite((Float)20F);
		ing3.setNombreCalories100g((Float)300F);
		ing3.setProduitSaison(ProduitSaison.ETE);
		ing3.setTypeProduit(TypeProduit.BOISSON);

		ing1 = ingRepo.save(ing1);
		ing2 = ingRepo.save(ing2);
		ing3 = ingRepo.save(ing3);
			
		
		List<Ingredient> ingredients  = ingRepo.findAll();
		
		assertEquals(3, ingredients.size());
		try {
		ingRepo.delete(ing1);
		ingRepo.delete(ing2);
		ingRepo.delete(ing3);
		ingredients = ingRepo.findAll();
		}finally {
		assertEquals(0, ingredients.size());
		//context.close();
	}
	}
	@Test
	public void findByName() {
	
	
//	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
//			"classpath:application-context.xml");
//		IIngredientRepository ingRepo = context.getBean(IIngredientRepository.class);
	
	Ingredient  ing1 = new Ingredient ();
					
	Ingredient  ing2 = new Ingredient ();
	
	Ingredient  ing3 = new Ingredient ();
	
	ing1.setNom("tomate");
	ing1.setQuantite((Float)100F);
	ing1.setNombreCalories100g((Float)10F);
	ing1.setProduitSaison(ProduitSaison.ETE);
	ing1.setTypeProduit(TypeProduit.VIANDE);
	
	ing2.setNom("poulet");
	ing2.setQuantite((Float)200F);
	ing2.setNombreCalories100g((Float)300F);
	ing2.setProduitSaison(ProduitSaison.HIVER);
	ing2.setTypeProduit(TypeProduit.LEGUMES);	
	
	ing3.setNom("coca");
	ing3.setQuantite((Float)20F);
	ing3.setNombreCalories100g((Float)300F);
	ing3.setProduitSaison(ProduitSaison.ETE);
	ing3.setTypeProduit(TypeProduit.BOISSON);

	ing1 = ingRepo.save(ing1);
	ing2 = ingRepo.save(ing2);
	ing3 = ingRepo.save(ing3);
		
	
	Ingredient ingredientsParNom  = ingRepo.findIngredientByName("poulet");
	try {
		
		assertEquals(ing2.getId(), ingredientsParNom.getId());
	
				
	}finally {
	ingRepo.delete(ing1);
	ingRepo.delete(ing2);
	ingRepo.delete(ing3);
	}
}
	@Test
	public void findByProduitSaison() {
	
	
//	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
//			"classpath:application-context.xml");
//		IIngredientRepository ingRepo = context.getBean(IIngredientRepository.class);
	
	Ingredient  ing1 = new Ingredient ();
					
	Ingredient  ing2 = new Ingredient ();
	
	Ingredient  ing3 = new Ingredient ();
	
	ing1.setNom("tomate");
	ing1.setQuantite((Float)100F);
	ing1.setNombreCalories100g((Float)10F);
	ing1.setProduitSaison(ProduitSaison.ETE);
	ing1.setTypeProduit(TypeProduit.VIANDE);
	
	ing2.setNom("poulet");
	ing2.setQuantite((Float)200F);
	ing2.setNombreCalories100g((Float)300F);
	ing2.setProduitSaison(ProduitSaison.HIVER);
	ing2.setTypeProduit(TypeProduit.LEGUMES);	
	
	ing3.setNom("coca");
	ing3.setQuantite((Float)20F);
	ing3.setNombreCalories100g((Float)300F);
	ing3.setProduitSaison(ProduitSaison.ETE);
	ing3.setTypeProduit(TypeProduit.BOISSON);

	ing1 = ingRepo.save(ing1);
	ing2 = ingRepo.save(ing2);
	ing3 = ingRepo.save(ing3);
		
	
	List<Ingredient> ingredientsParSaison  =  ingRepo.findIngredientByProduitSaison(ProduitSaison.ETE);
	try {
		
		assertEquals(ing1.getId(), ingredientsParSaison.get(0).getId());
				
	}finally {
	ingRepo.delete(ing1);
	ingRepo.delete(ing2);
	ingRepo.delete(ing3);
	}
}
	@Test
	public void findByTypeProduit() {
	
	
//	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
//			"classpath:application-context.xml");
//		IIngredientRepository ingRepo = context.getBean(IIngredientRepository.class);
	
	Ingredient  ing1 = new Ingredient ();
					
	Ingredient  ing2 = new Ingredient ();
	
	Ingredient  ing3 = new Ingredient ();
	
	ing1.setNom("tomate");
	ing1.setQuantite((Float)100F);
	ing1.setNombreCalories100g((Float)10F);
	ing1.setProduitSaison(ProduitSaison.ETE);
	ing1.setTypeProduit(TypeProduit.VIANDE);
	
	ing2.setNom("poulet");
	ing2.setQuantite((Float)200F);
	ing2.setNombreCalories100g((Float)300F);
	ing2.setProduitSaison(ProduitSaison.HIVER);
	ing2.setTypeProduit(TypeProduit.LEGUMES);	
	
	ing3.setNom("coca");
	ing3.setQuantite((Float)20F);
	ing3.setNombreCalories100g((Float)300F);
	ing3.setProduitSaison(ProduitSaison.ETE);
	ing3.setTypeProduit(TypeProduit.BOISSON);

	ing1 = ingRepo.save(ing1);
	ing2 = ingRepo.save(ing2);
	ing3 = ingRepo.save(ing3);
		
	
	List<Ingredient> ingredientsParProduit  =  ingRepo.findIngredientByTypeProduit(TypeProduit.VIANDE);
	try {
		
		assertEquals(ing1.getId(), ingredientsParProduit.get(0).getId());
				
	}finally {
	ingRepo.delete(ing1);
	ingRepo.delete(ing2);
	ingRepo.delete(ing3);
	}
}
}
