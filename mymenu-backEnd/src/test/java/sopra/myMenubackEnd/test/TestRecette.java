package sopra.myMenubackEnd.test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import sopra.myMenubackEnd.model.Recette;
import sopra.myMenubackEnd.model.TypeAlimentation;

import sopra.myMenubackEnd.repository.IRecetteRepository;

@SpringBootTest
public class TestRecette {
	@Autowired
	IRecetteRepository recRepo;
	@Test	
	public void RecetteCreate() {
		
		
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
//				"classpath:application-context.xml");
//			IRecetteRepository recRepo = context.getBean(IRecetteRepository.class);
	
		
		
		Recette rec1 = new Recette("couscous", "mettre les legumes et le poulet", 5, 800,5F, TypeAlimentation.HALAL);
			
			
		rec1 = recRepo.save(rec1);
		
		Recette recFind = recRepo.findById(rec1.getId()).get();
		try {
		assertEquals("couscous", recFind.getNom());
		assertEquals( "mettre les legumes et le poulet", recFind.getEtapes());
		assertEquals( 5, recFind.getNombrePers());
		assertEquals(800, recFind.getTotalCalories());
		assertEquals(TypeAlimentation.HALAL, recFind.getTypeRecette());
		
		}finally {
						
		recRepo.delete(rec1);
		
		//context.close();
	}}
	
	@Test	
	public void RecetteUpdate() {
		
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
//				"classpath:application-context.xml");
//			IRecetteRepository recRepo = context.getBean(IRecetteRepository.class);
		
		Recette rec1 = new Recette("couscous", "mettre les legumes et le poulet", 5, 800,5F, TypeAlimentation.HALAL);
		
		rec1 = recRepo.save(rec1);
		
							
		rec1.setNom("tartiflette");
		rec1.setEtapes("patate et reblochon");
		rec1.setNombrePers(8);
		rec1.setTotalCalories(500);
		rec1.setTypeRecette(TypeAlimentation.NONE);
		
			
		rec1 = recRepo.save(rec1);
		Recette recFind = recRepo.findById(rec1.getId()).get();
		try {
		assertEquals("tartiflette", recFind.getNom());
		assertEquals( "patate et reblochon", recFind.getEtapes());
		assertEquals( 8, recFind.getNombrePers());
		assertEquals(500, recFind.getTotalCalories());
		assertEquals(TypeAlimentation.NONE, recFind.getTypeRecette());
		}finally {
				
		recRepo.delete(rec1);
		//context.close();
	}}
	
	@Test
	public void RecetteFindAll() {
		
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
//				"classpath:application-context.xml");
//			IRecetteRepository recRepo = context.getBean(IRecetteRepository.class);
		
		Recette rec1 = new Recette("couscous", "mettre les legumes et le poulet", 5, 800,5F, TypeAlimentation.HALAL);
						
		Recette rec2 = new Recette("tartiflette", "patate et reblochon", 5, 800,5F, TypeAlimentation.NONE);
		
		Recette rec3 = new Recette("couscous", "mettre les legumes et le poulet", 5, 800,5F, TypeAlimentation.HALAL);

		rec1 = recRepo.save(rec1);
		rec2 = recRepo.save(rec2);
		rec3 = recRepo.save(rec3);
			
		
		List<Recette> recettes = recRepo.findAll();
		try {
		assertEquals(3, recettes.size());
		}finally {
		recRepo.delete(rec1);
		recRepo.delete(rec2);
		recRepo.delete(rec3);
			
		//context.close();
	}
	}

	@Test
	public void RecetteDelete() {
		
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
//				"classpath:application-context.xml");
//			IRecetteRepository recRepo = context.getBean(IRecetteRepository.class);
		
		Recette rec1 = new Recette("couscous", "mettre les legumes et le poulet", 5, 800,5F, TypeAlimentation.HALAL);
						
		Recette rec2 = new Recette("tartiflette", "patate et reblochon", 5, 800,5F, TypeAlimentation.NONE);
		
		Recette rec3 = new Recette("couscous", "mettre les legumes et le poulet", 5, 800,5F, TypeAlimentation.HALAL);

		rec1 = recRepo.save(rec1);
		rec2 = recRepo.save(rec2);
		rec3 = recRepo.save(rec3);
			
		
		List<Recette> recettes = recRepo.findAll();
		
		assertEquals(3, recettes.size());
	
		recRepo.delete(rec1);
		recRepo.delete(rec2);
		recRepo.delete(rec3);
		
		recettes = recRepo.findAll();
		
		assertEquals(0, recettes.size());
		//context.close();
	}
	@Test
	public void findByRisingCalories() {
	
//	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
//			"classpath:application-context.xml");
//		IRecetteRepository recRepo = context.getBean(IRecetteRepository.class);
	
	Recette rec1 = new Recette("couscous", "mettre les legumes et le poulet", 5, 200,5F, TypeAlimentation.HALAL);
					
	Recette rec2 = new Recette("tartiflette", "patate et reblochon", 5, 800,5F, TypeAlimentation.NONE);
	
	Recette rec3 = new Recette("couscous", "mettre les legumes et le poulet", 5, 10,5F, TypeAlimentation.HALAL);

	rec1 = recRepo.save(rec1);
	rec2 = recRepo.save(rec2);
	rec3 = recRepo.save(rec3);
	
	List<Recette> recettesParCalories = recRepo.findByRisingCalories();
	try {
		assertEquals(rec1.getId(), recettesParCalories.get(1).getId());
		assertEquals(rec2.getId(), recettesParCalories.get(2).getId());
		assertEquals(rec3.getId(), recettesParCalories.get(0).getId());
	}finally{
		recRepo.delete(rec1);
		recRepo.delete(rec2);
		recRepo.delete(rec3);
	}
	
}
	@Test
public void findByName() {
//	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");
//	IRecetteRepository recRepo = context.getBean(IRecetteRepository.class);

	Recette rec1 = new Recette("couscous", "mettre les legumes et le poulet", 5, 200,5F, TypeAlimentation.HALAL);
	
Recette rec2 = new Recette("tartiflette", "patate et reblochon", 5, 800,5F, TypeAlimentation.NONE);

Recette rec3 = new Recette("couscous", "mettre les legumes et le poulet", 5, 10,5F, TypeAlimentation.HALAL);

rec1 = recRepo.save(rec1);
rec2 = recRepo.save(rec2);
rec3 = recRepo.save(rec3);


	List<Recette> recettesParNom = recRepo.findByName("couscous");
	try {
		assertEquals(rec1.getId(), recettesParNom.get(0).getId());
	} finally {
		recRepo.delete(rec1);
		recRepo.delete(rec2);
		recRepo.delete(rec3);
	}
	}
	@Test
	public void findByRisingNote() {
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");
//		IRecetteRepository recRepo = context.getBean(IRecetteRepository.class);

		Recette rec1 = new Recette("couscous", "mettre les legumes et le poulet", 5, 200,3F, TypeAlimentation.HALAL);
		
	Recette rec2 = new Recette("tartiflette", "patate et reblochon", 5, 800,5F, TypeAlimentation.NONE);

	Recette rec3 = new Recette("couscous", "mettre les legumes et le poulet", 5, 10,2F, TypeAlimentation.HALAL);

	rec1 = recRepo.save(rec1);
	rec2 = recRepo.save(rec2);
	rec3 = recRepo.save(rec3);


	List<Recette> recettesParNote = recRepo.findByRisingNote();
	try {
		assertEquals(rec1.getId(), recettesParNote.get(1).getId());
		assertEquals(rec2.getId(), recettesParNote.get(2).getId());
		assertEquals(rec3.getId(), recettesParNote.get(0).getId());
	}finally{
		recRepo.delete(rec1);
		recRepo.delete(rec2);
		recRepo.delete(rec3);
	}
	
}
	@Test
	public void findByTypeAlimentation() {
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");
//		IRecetteRepository recRepo = context.getBean(IRecetteRepository.class);

		Recette rec1 = new Recette("couscous", "mettre les legumes et le poulet", 5, 200,3F, TypeAlimentation.HALAL);
		
	Recette rec2 = new Recette("tartiflette", "patate et reblochon", 5, 800,5F, TypeAlimentation.NONE);

	Recette rec3 = new Recette("tartiflette", "patate et reblochon", 5, 800,2F, TypeAlimentation.NONE);

	rec1 = recRepo.save(rec1);
	rec2 = recRepo.save(rec2);
	rec3 = recRepo.save(rec3);


	List<Recette> recettesPartypalim = recRepo.findByTypeAlimentation(TypeAlimentation.HALAL);
	try {
		assertEquals(rec1.getId(), recettesPartypalim.get(0).getId());
		
	}finally{
		recRepo.delete(rec1);
		recRepo.delete(rec2);
		recRepo.delete(rec3);
	}
	
}
	
}




