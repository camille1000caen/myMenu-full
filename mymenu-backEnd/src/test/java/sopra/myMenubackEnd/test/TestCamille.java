package sopra.myMenubackEnd.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import sopra.myMenubackEnd.model.Adresse;
import sopra.myMenubackEnd.model.AjustementQuantite;
import sopra.myMenubackEnd.model.Ingredient;
import sopra.myMenubackEnd.model.ListeCourse;
import sopra.myMenubackEnd.model.Magasin;
import sopra.myMenubackEnd.model.MagasinIngredient;
import sopra.myMenubackEnd.repository.IAdresseRepository;
import sopra.myMenubackEnd.repository.IAjustementQuantiteRepository;
import sopra.myMenubackEnd.repository.IIngredientRepository;
import sopra.myMenubackEnd.repository.IListeCourseRepository;
import sopra.myMenubackEnd.repository.IMagasinIngredientRepository;
import sopra.myMenubackEnd.repository.IMagasinRepository;

@SpringBootTest
public class TestCamille {

	@Autowired
	private IAjustementQuantiteRepository ajustementRepo;
	@Autowired
	private IMagasinRepository magasinRepo;
	@Autowired
	private IMagasinIngredientRepository magasinIngredientRepo;
	@Autowired
	private IListeCourseRepository listeRepo;
	@Autowired
	private IIngredientRepository ingredientRepo;
	@Autowired
	private IAdresseRepository adresseRepo;
	////////////////////////////////////////TEST AJUSTEMENT QUANTITE/////////////////////////////////////////////

	@Test
	public void ajustementCreateSimple() {

		AjustementQuantite ajustement = new AjustementQuantite();

		ajustement.setQuantiteModifiee(2F);	

		ajustement = ajustementRepo.save(ajustement); 

		AjustementQuantite ajustementFind = ajustementRepo.findById(ajustement.getId()).get();
		try {
			assertEquals((Float)2.0F, ajustementFind.getQuantiteModifiee());
		}finally {
			ajustementRepo.delete(ajustement); 		
		}

	}	 

	@Test
	public void ajustementCreateAvecLiens() {

		
		Ingredient ingredient1 = new Ingredient();
		ingredient1.setNom("tomate");
		ingredient1.setQuantite(3F);
		ingredient1 = ingredientRepo.save(ingredient1);

		AjustementQuantite ajustement1 = new AjustementQuantite();			
		ajustement1.setQuantiteModifiee(2F);

		ingredient1.setAjustementQuantite(ajustement1);

		ajustement1 = ajustementRepo.save(ajustement1);

		ingredient1 = ingredientRepo.save(ingredient1);

		List<AjustementQuantite> ajustementFind = ajustementRepo.findAll();
		try {
			assertEquals((Float)2F,ajustementFind.get(0).getQuantiteModifiee());		
		}finally {	
			ingredientRepo.delete(ingredient1); 
			ajustementRepo.delete(ajustement1);
		}

	}	

	@Test
	public void ajustementUpdate() {

		AjustementQuantite ajustement = new AjustementQuantite();

		ajustement.setQuantiteModifiee(2F);	
		ajustement = ajustementRepo.save(ajustement);
		AjustementQuantite ajustementFind = ajustementRepo.findById(ajustement.getId()).get();

		ajustement.setQuantiteModifiee(6F);	
		ajustement = ajustementRepo.save(ajustement);
		ajustementFind = ajustementRepo.findById(ajustement.getId()).get();
		try {
			assertEquals((Float)6F, ajustementFind.getQuantiteModifiee());
		}finally {
			ajustementRepo.delete(ajustement);
		}

	}	

	@Test
	public void ajustementFindAll() {
		
		AjustementQuantite ajustement1 = new AjustementQuantite();
		ajustement1.setQuantiteModifiee(3F); 
		ajustement1 = ajustementRepo.save(ajustement1);		

		AjustementQuantite ajustement2 = new AjustementQuantite();
		ajustement2.setQuantiteModifiee(6F);
		ajustement2 = ajustementRepo.save(ajustement2);			

		List<AjustementQuantite> ajustements = ajustementRepo.findAll();
		try {
			assertEquals(2, ajustements.size());
		}finally {
			ajustementRepo.delete(ajustement1);
			ajustementRepo.delete(ajustement2);		
		}

	}

	@Test
	public void ajustementQuantiteDelete() {

		AjustementQuantite ajustement1 = new AjustementQuantite();
		AjustementQuantite ajustement2 = new AjustementQuantite();

		ajustement1 = ajustementRepo.save(ajustement1);
		ajustement2 = ajustementRepo.save(ajustement2);	

		List<AjustementQuantite> ajustements = ajustementRepo.findAll();

		assertEquals(2, ajustements.size());

		ajustementRepo.delete(ajustement1);
		ajustementRepo.delete(ajustement2);		

		ajustements = ajustementRepo.findAll();
		try {
			assertEquals(0, ajustements.size());
		}finally {
			ajustementRepo.delete(ajustement1);
			ajustementRepo.delete(ajustement2);	
		}
	}


	////////////////////////////////////////TEST LISTE COURSE/////////////////////////////////////////////

	@Test
	public void listeCourseCreateAvecLien() {

		
		Ingredient ingredient1 = new Ingredient();
		ingredient1.setNom("tomate");
		ingredient1.setQuantite(3F);			
		ingredient1 = ingredientRepo.save(ingredient1);

		AjustementQuantite ajustement1 = new AjustementQuantite();
		ajustement1.setQuantiteModifiee(2F);

		ajustement1 = ajustementRepo.save(ajustement1);	

		ingredient1.setAjustementQuantite(ajustement1);

		ingredient1 = ingredientRepo.save(ingredient1);

		ListeCourse listeCourse1 = new ListeCourse();

		listeCourse1.setAjustementQuantite(ajustement1);
		listeCourse1 = listeRepo.save(listeCourse1);

		List<Ingredient> ingredients = ingredientRepo.findAll();

		ajustement1.setIngredients(ingredients);

		ajustement1 = ajustementRepo.save(ajustement1);

		ListeCourse listeFind = listeRepo.findById(listeCourse1.getId()).get();
		try {
			assertEquals((Float)2F,listeFind.getAjustementQuantite().getQuantiteModifiee());			
		}finally {
			listeRepo.delete(listeCourse1);

			ingredientRepo.delete(ingredient1);

			ajustementRepo.delete(ajustement1);		
		}
	}

	@Test
	public void listeCourseCreateSimple() {

		ListeCourse liste1 = new ListeCourse();	
		ListeCourse liste2 = new ListeCourse();

		try {
			liste1 = listeRepo.save(liste1);
		} catch(PersistenceException e) {
		}
		try {
			liste2 = listeRepo.save(liste2);
		} catch(PersistenceException e) {
		}

		List<ListeCourse> listeCourses = listeRepo.findAll();
		try {
			assertEquals(2, listeCourses.size());
		}finally {
			listeRepo.delete(liste1);
			listeRepo.delete(liste2);

		}
	}	

	@Test
	public void listeCourseUpdate() {

		Ingredient ingredient = new Ingredient();
		ingredient.setNom("tomate");
		ingredient.setQuantite(3F);		

		ingredient = ingredientRepo.save(ingredient);

		AjustementQuantite ajustement = new AjustementQuantite();

		ajustement.setQuantiteModifiee(2F);
		ingredient.setAjustementQuantite(ajustement);

		ajustement = ajustementRepo.save(ajustement);
		ingredient = ingredientRepo.save(ingredient);				

		ListeCourse listeCourse = new ListeCourse();

		listeCourse.setAjustementQuantite(ajustement);	
		listeCourse = listeRepo.save(listeCourse);

		ajustement.setQuantiteModifiee(6F);
		ingredient.setAjustementQuantite(ajustement);

		ajustement = ajustementRepo.save(ajustement);
		ingredient = ingredientRepo.save(ingredient);		

		listeCourse.setAjustementQuantite(ajustement);
		listeCourse = listeRepo.save(listeCourse);

		ListeCourse listeFind = listeRepo.findById(listeCourse.getId()).get();
		try {
			assertEquals(listeCourse.getAjustementQuantite().getQuantiteModifiee(),listeFind.getAjustementQuantite().getQuantiteModifiee());
		}finally {
			listeRepo.delete(listeCourse);
			ingredientRepo.delete(ingredient);		
			ajustementRepo.delete(ajustement);
		}
	}	

	@Test
	public void listeCourseFindAll() {

		ListeCourse liste1 = new ListeCourse();	
		ListeCourse liste2 = new ListeCourse();	

		liste1 = listeRepo.save(liste1);
		liste2 = listeRepo.save(liste2);			

		List<ListeCourse> listeCourses = listeRepo.findAll();
		try {
			assertEquals(2, listeCourses.size());
		}finally {
			listeRepo.delete(liste1);
			listeRepo.delete(liste2);	
		}
	}

	@Test
	public void listeCourseDelete() {

		ListeCourse liste1 = new ListeCourse();	
		ListeCourse liste2 = new ListeCourse();	

		liste1 = listeRepo.save(liste1);
		liste2 = listeRepo.save(liste2);			

		List<ListeCourse> listeCourses = listeRepo.findAll();

		assertEquals(2, listeCourses.size());

		listeRepo.delete(liste1);
		listeRepo.delete(liste2);	

		listeCourses = listeRepo.findAll();
		try {
			assertEquals(0, listeCourses.size());
		}finally {
			listeRepo.delete(liste1);
			listeRepo.delete(liste2);	
		}
	}

	//////////////////////////////////////// TEST MAGASIN INGREDIENTS/////////////////////////////////////////////
	@Test
	public void magasinIngredientCreate() {
		
		MagasinIngredient magasinIngred = new MagasinIngredient();
		magasinIngred.setBio(true);
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		try {
			magasinIngred.setDatePeremption(sdf.parse("2021-10-10"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		magasinIngred.setPrix(3.5F);
		magasinIngred.setProduitLocal(false);
		magasinIngred.setMarque("marque repère");

		try {
			magasinIngred = magasinIngredientRepo.save(magasinIngred);
		} catch(PersistenceException e) {
		}
		MagasinIngredient magasinIngredFind = magasinIngredientRepo.findById(magasinIngred.getId()).get();
		try {
			assertEquals(true, magasinIngredFind.getBio());
			try {
				assertEquals(sdf.parse("2021-10-10"), magasinIngredFind.getDatePeremption());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			assertEquals((Float)3.5F, magasinIngredFind.getPrix());
			assertEquals(false, magasinIngredFind.getProduitLocal());
			assertEquals("marque repère", magasinIngredFind.getMarque());	
		}finally {
			magasinIngredientRepo.delete(magasinIngred);

		} 
	}

	@Test
	public void magasinIngredientUpdate() {

		MagasinIngredient magasinIngred = new MagasinIngredient();
		magasinIngred.setBio(true);
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		try {
			magasinIngred.setDatePeremption(sdf.parse("2021-10-10"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		magasinIngred.setPrix(3.5F);
		magasinIngred.setProduitLocal(false);
		magasinIngred.setMarque("marque repère");		

		magasinIngred = magasinIngredientRepo.save(magasinIngred);
		MagasinIngredient magasinIngredFind = magasinIngredientRepo.findById(magasinIngred.getId()).get();

		magasinIngred.setBio(false);
		try {
			magasinIngred.setDatePeremption(sdf.parse("2022-02-03"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		magasinIngred.setPrix(6F);
		magasinIngred.setProduitLocal(true); 
		magasinIngred.setMarque("Marie");		

		magasinIngred = magasinIngredientRepo.save(magasinIngred);
		magasinIngredFind = magasinIngredientRepo.findById(magasinIngred.getId()).get();
		try {
			assertEquals(false, magasinIngredFind.getBio());
			try {
				assertEquals(sdf.parse("2022-02-03"), magasinIngredFind.getDatePeremption());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			assertEquals((Float)6F, magasinIngredFind.getPrix());
			assertEquals(true, magasinIngredFind.getProduitLocal());
			assertEquals("Marie", magasinIngredFind.getMarque());
		}finally {
			magasinIngredientRepo.delete(magasinIngred); 
		}
	}

	@Test
	public void magasinIngredientFindAll() {

		MagasinIngredient magasinIngred1 = new MagasinIngredient(); 

		magasinIngred1.setBio(true);
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		try {
			magasinIngred1.setDatePeremption(sdf.parse("2021-10-10"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		magasinIngred1.setPrix(3.5F);
		magasinIngred1.setProduitLocal(false);
		magasinIngred1.setMarque("marque repère");

		magasinIngred1 = magasinIngredientRepo.save(magasinIngred1);		

		MagasinIngredient magasinIngred2 = new MagasinIngredient();

		magasinIngred2.setBio(false);
		try {
			magasinIngred2.setDatePeremption(sdf.parse("2022-01-12"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		magasinIngred2.setPrix(5F);
		magasinIngred2.setProduitLocal(true);
		magasinIngred2.setMarque("Marie");

		magasinIngred2 = magasinIngredientRepo.save(magasinIngred2);			

		List<MagasinIngredient> magasinIngredients = magasinIngredientRepo.findAll();
		try {
			assertEquals(2, magasinIngredients.size());
		}finally {
			magasinIngredientRepo.delete(magasinIngred1);
			magasinIngredientRepo.delete(magasinIngred2);	
		}
	}

	@Test
	public void magasinIngredientDelete() {

		MagasinIngredient magasinIngred1 = new MagasinIngredient(); 
		MagasinIngredient magasinIngred2 = new MagasinIngredient(); 

		magasinIngred1 = magasinIngredientRepo.save(magasinIngred1);
		magasinIngred2 = magasinIngredientRepo.save(magasinIngred2);	

		List<MagasinIngredient> magasinIngredients = magasinIngredientRepo.findAll();

		assertEquals(2, magasinIngredients.size());

		magasinIngredientRepo.delete(magasinIngred1);
		magasinIngredientRepo.delete(magasinIngred2);		

		magasinIngredients = magasinIngredientRepo.findAll();
		try {
			assertEquals(0, magasinIngredients.size());
		}finally {
			magasinIngredientRepo.delete(magasinIngred1);
			magasinIngredientRepo.delete(magasinIngred2);
		}
	}

	@Test
	public void magasinIngredientFindByBrand() {

		MagasinIngredient magasinIngred1 = new MagasinIngredient(); 
		MagasinIngredient magasinIngred2 = new MagasinIngredient();

		magasinIngred1.setBio(true);
		Date date1 = new Date();
		magasinIngred1.setDatePeremption(date1);
		magasinIngred1.setPrix(3.5F);
		magasinIngred1.setProduitLocal(false);
		magasinIngred1.setMarque("marque repère");

		magasinIngred1 = magasinIngredientRepo.save(magasinIngred1);

		magasinIngred2.setBio(false);
		Date date2= new Date();
		magasinIngred2.setDatePeremption(date2);
		magasinIngred2.setPrix(5F);
		magasinIngred2.setProduitLocal(true);
		magasinIngred2.setMarque("Marie");

		magasinIngred2 = magasinIngredientRepo.save(magasinIngred2);			

		List<MagasinIngredient> marqueMarie = magasinIngredientRepo.findByBrand("Marie");
		try {
			assertEquals(magasinIngred2.getId(), marqueMarie.get(0).getId());
		}finally {
			magasinIngredientRepo.delete(magasinIngred1);
			magasinIngredientRepo.delete(magasinIngred2);

		}
	}

	@Test
	public void magasinIngredientFindAllBio() {

		MagasinIngredient magasinIngred1 = new MagasinIngredient(); 
		MagasinIngredient magasinIngred2 = new MagasinIngredient();

		magasinIngred1.setBio(true);
		Date date1 = new Date();
		magasinIngred1.setDatePeremption(date1);
		magasinIngred1.setPrix(3.5F);
		magasinIngred1.setProduitLocal(false);
		magasinIngred1.setMarque("marque repère");

		magasinIngred1 = magasinIngredientRepo.save(magasinIngred1);

		magasinIngred2.setBio(false);
		Date date2= new Date();
		magasinIngred2.setDatePeremption(date2);
		magasinIngred2.setPrix(5F);
		magasinIngred2.setProduitLocal(true);
		magasinIngred2.setMarque("Marie");

		magasinIngred2 = magasinIngredientRepo.save(magasinIngred2);		

		List<MagasinIngredient> marqueBio = magasinIngredientRepo.findAllBio();
		try {
			assertEquals(magasinIngred1.getId(), marqueBio.get(0).getId());
		}finally {
			magasinIngredientRepo.delete(magasinIngred1);
			magasinIngredientRepo.delete(magasinIngred2);

		}
	}

	@Test
	public void magasinIngredientFindAllProduitLocal() {

		MagasinIngredient magasinIngred1 = new MagasinIngredient(); 
		MagasinIngredient magasinIngred2 = new MagasinIngredient();

		magasinIngred1.setBio(true);
		Date date1 = new Date();
		magasinIngred1.setDatePeremption(date1);
		magasinIngred1.setPrix(3.5F);
		magasinIngred1.setProduitLocal(false);
		magasinIngred1.setMarque("marque repère");

		magasinIngred1 = magasinIngredientRepo.save(magasinIngred1);

		magasinIngred2.setBio(false);
		Date date2= new Date();
		magasinIngred2.setDatePeremption(date2);
		magasinIngred2.setPrix(5F);
		magasinIngred2.setProduitLocal(true);
		magasinIngred2.setMarque("Marie");

		magasinIngred2 = magasinIngredientRepo.save(magasinIngred2);			

		List<MagasinIngredient> marqueLocale = magasinIngredientRepo.findAllProduitLocal();
		try {
			assertEquals(magasinIngred2.getId(), marqueLocale.get(0).getId());
		}finally {
			magasinIngredientRepo.delete(magasinIngred1);
			magasinIngredientRepo.delete(magasinIngred2);

		}
	}

	@Test
	public void magasinIngredientFindByRisingPrice() {

		MagasinIngredient magasinIngred1 = new MagasinIngredient(); 
		MagasinIngredient magasinIngred2 = new MagasinIngredient();

		magasinIngred1.setBio(true);
		Date date1 = new Date();
		magasinIngred1.setDatePeremption(date1);
		magasinIngred1.setPrix(3.5F);
		magasinIngred1.setProduitLocal(false);
		magasinIngred1.setMarque("marque repère");

		magasinIngred1 = magasinIngredientRepo.save(magasinIngred1);

		magasinIngred2.setBio(false);
		Date date2= new Date();
		magasinIngred2.setDatePeremption(date2);
		magasinIngred2.setPrix(5F);
		magasinIngred2.setProduitLocal(true);
		magasinIngred2.setMarque("Marie");

		magasinIngred2 = magasinIngredientRepo.save(magasinIngred2);			

		List<MagasinIngredient> magasinsParPrix = magasinIngredientRepo.findAllByRisingPrice();
		try {
			assertEquals(magasinIngred1.getId(), magasinsParPrix.get(0).getId());
			assertEquals(magasinIngred2.getId(), magasinsParPrix.get(1).getId());
		}finally {
			magasinIngredientRepo.delete(magasinIngred1);
			magasinIngredientRepo.delete(magasinIngred2);

		}
	}

	@Test
	public void magasinIngredientFindByMagasin() {

		MagasinIngredient magasinIngred = new MagasinIngredient(); 

		magasinIngred.setBio(true);
		Date date1 = new Date();
		magasinIngred.setDatePeremption(date1);
		magasinIngred.setPrix(3.5F);
		magasinIngred.setProduitLocal(false);
		magasinIngred.setMarque("marque repère");		
		magasinIngred = magasinIngredientRepo.save(magasinIngred);


		Magasin magasin1 = new Magasin(); 
		Magasin magasin2 = new Magasin();

		magasin1.setNom("Carrefour");
		magasin1 = magasinRepo.save(magasin1);

		magasin2.setNom("Leclerc"); 
		magasin2 = magasinRepo.save(magasin2);

		magasin1.setMagasinIngredient(magasinIngred);
		magasin1 = magasinRepo.save(magasin1);
		magasin2.setMagasinIngredient(magasinIngred);
		magasin2 = magasinRepo.save(magasin2);


		List<Magasin> magasins = magasinRepo.findAll();
		magasinIngred.setMagasins(magasins);

		magasinIngred = magasinIngredientRepo.save(magasinIngred);

		List<MagasinIngredient> magasinIngredByMagasin = magasinIngredientRepo.findByMagasin("Carrefour");
		try {
			assertEquals(magasinIngred.getId(), magasinIngredByMagasin.get(0).getId());		
		}finally{
			magasinRepo.delete(magasin1);
			magasinRepo.delete(magasin2);
			magasinIngredientRepo.delete(magasinIngred);		

		}

	}



	////////////////////////////////////////TEST MAGASIN /////////////////////////////////////////////
	@Test
	public void magasinCreate() {

		Magasin magasin = new Magasin();

		magasin.setNom("Carrefour");
		magasin.setSiret("123456789");

		try {
			magasin = magasinRepo.save(magasin);
		} catch(PersistenceException e) {
		}
		Magasin magasinFind = magasinRepo.findById(magasin.getId()).get();
		try {
			assertEquals("Carrefour", magasinFind.getNom());	
			assertEquals("123456789", magasinFind.getSiret());	
		}finally {
			magasinRepo.delete(magasin); 
		}
	}

	@Test
	public void magasinUpdate() {

		Magasin magasin = new Magasin();

		magasin.setNom("Carrefour");
		magasin.setSiret("123456789");		

		magasin = magasinRepo.save(magasin);		
		Magasin magasinFind = magasinRepo.findById(magasin.getId()).get();

		magasin.setNom("Leclerc"); 
		magasin.setSiret("987654321");	 

		magasin = magasinRepo.save(magasin);		
		magasinFind = magasinRepo.findById(magasin.getId()).get();
		try {
			assertEquals("Leclerc", magasinFind.getNom());	
			assertEquals("987654321", magasinFind.getSiret());	
		}finally {
			magasinRepo.delete(magasin);
		}
	}

	@Test
	public void magasinFindAll() {

		Magasin magasin1 = new Magasin(); 

		magasin1.setNom("Carrefour");
		magasin1.setSiret("123456789");		

		magasin1 = magasinRepo.save(magasin1);		 

		Magasin magasin2 = new Magasin(); 

		magasin2.setNom("Leclerc"); 
		magasin2.setSiret("987654321");	 

		magasin2 = magasinRepo.save(magasin2);			

		List<Magasin> magasins = magasinRepo.findAll();
		try {
			assertEquals(2, magasins.size());
		}finally {
			magasinRepo.delete(magasin1);
			magasinRepo.delete(magasin2);	
		}
	}
	
	@Test
	public void magasinFindByName() {

		Magasin magasin1 = new Magasin(); 

		magasin1.setNom("Carrefour");
		magasin1.setSiret("123456789");		

		magasin1 = magasinRepo.save(magasin1);		 

		Magasin magasin2 = new Magasin(); 

		magasin2.setNom("Leclerc"); 
		magasin2.setSiret("987654321");	 

		magasin2 = magasinRepo.save(magasin2);			

		List<Magasin> magasins = magasinRepo.findAllByName("Leclerc");
		try {
			assertEquals(magasin2.getId(), magasins.get(0).getId());
		}finally {
			magasinRepo.delete(magasin1);
			magasinRepo.delete(magasin2);
		}
	}
	
	@Test
	public void magasinFindBySiret() {

		Magasin magasin1 = new Magasin(); 

		magasin1.setNom("Carrefour");
		magasin1.setSiret("123456789");		

		magasin1 = magasinRepo.save(magasin1);		 

		Magasin magasin2 = new Magasin(); 

		magasin2.setNom("Leclerc"); 
		magasin2.setSiret("987654321");	 

		magasin2 = magasinRepo.save(magasin2);			

		List<Magasin> magasins = magasinRepo.findAllBySiret("123456789");
		try {
			assertEquals(magasin1.getId(), magasins.get(0).getId());
		}finally {
			magasinRepo.delete(magasin1);
			magasinRepo.delete(magasin2);
		}
	}
	
	@Test
	public void magasinFindByVille() {

		Magasin magasin1 = new Magasin(); 
		magasin1.setNom("Carrefour");
		magasin1.setSiret("123456789");	
		magasin1 = magasinRepo.save(magasin1);		 

		Magasin magasin2 = new Magasin(); 
		magasin2.setNom("Leclerc"); 
		magasin2.setSiret("987654321");	
		magasin2 = magasinRepo.save(magasin2);	
		
		Adresse adr1 = new Adresse("33 rue IKEA", "Residence plikepluck", "33000", "Bordeaux", "France");
			
		adr1.setMagasin(magasin1);
		adr1= adresseRepo.save(adr1);
		
		Adresse adr2 = new Adresse("12 rue ALINEA", "Residence contrefaçon", "72000", "LE MANS", "France");
		
		adr2.setMagasin(magasin2);
		adr2= adresseRepo.save(adr2);

		List<Magasin> magasins = magasinRepo.findAllByVille("LE MANS");
		try {
			assertEquals(magasin2.getId(), magasins.get(0).getId());
		}finally {
			adresseRepo.delete(adr1);
			adresseRepo.delete(adr2);
			magasinRepo.delete(magasin1);
			magasinRepo.delete(magasin2);

		}
	}
	
	@Test
	public void magasinFindByZipCode() {

		
		Magasin magasin1 = new Magasin(); 
		magasin1.setNom("Carrefour");
		magasin1.setSiret("123456789");	
		magasin1 = magasinRepo.save(magasin1);		 

		Magasin magasin2 = new Magasin(); 
		magasin2.setNom("Leclerc"); 
		magasin2.setSiret("987654321");	
		magasin2 = magasinRepo.save(magasin2);	
		
		Adresse adr1 = new Adresse("33 rue IKEA", "Residence plikepluck", "33000", "Bordeaux", "France");
			
		adr1.setMagasin(magasin1);
		adr1= adresseRepo.save(adr1);
		
		Adresse adr2 = new Adresse("12 rue ALINEA", "Residence contrefaçon", "72000", "LE MANS", "France");
		
		adr2.setMagasin(magasin2);
		adr2= adresseRepo.save(adr2);

		List<Magasin> magasins = magasinRepo.findAllByZipCode("33000");
		try {
			assertEquals(magasin1.getId(), magasins.get(0).getId());
		}finally {
			adresseRepo.delete(adr1);
			adresseRepo.delete(adr2);
			magasinRepo.delete(magasin1);
			magasinRepo.delete(magasin2);
			
		}
	}

	@Test
	public void magasinDelete() {

		Magasin magasin1 = new Magasin(); 
		Magasin magasin2 = new Magasin(); 

		magasin1 = magasinRepo.save(magasin1);
		magasin2 = magasinRepo.save(magasin2);	

		List<Magasin> magasin = magasinRepo.findAll();

		assertEquals(2, magasin.size());

		magasinRepo.delete(magasin1);
		magasinRepo.delete(magasin2);		

		magasin = magasinRepo.findAll();
		try {
			assertEquals(0, magasin.size());
		}finally {

		}

	}
}
