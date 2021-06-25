package sopra.myMenubackEnd.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.myMenubackEnd.model.Repas;
import sopra.myMenubackEnd.model.TypeRepas;
import sopra.myMenubackEnd.repository.IRepasRepository;

@SpringBootTest
public class TestRepas {

	@Autowired
	private IRepasRepository repasRepo;
	
	@Test
	public void repasCreate() {
		
		Repas repas1 = new Repas();

		try {
			repas1.setTypeRepas(TypeRepas.PETIT_DEJ);
			repas1 = repasRepo.save(repas1);

			Repas repasFind = repasRepo.findById(repas1.getId()).get();

			assertEquals(TypeRepas.PETIT_DEJ, repasFind.getTypeRepas());
		}

		finally {
			repasRepo.delete(repas1);
		}
	}

	@Test
	public void repasUpdate() {

		Repas repas1 = new Repas(TypeRepas.PETIT_DEJ);

		repas1 = repasRepo.save(repas1);

		repas1.setTypeRepas(TypeRepas.DINNER);

		repas1 = repasRepo.save(repas1);

		Repas repasFind = repasRepo.findById(repas1.getId()).get();

		try {
			assertEquals(TypeRepas.DINNER, repasFind.getTypeRepas());

		} finally {
			repasRepo.delete(repas1);
		}
	}

	@Test
	public void repasFindAll() {

		Repas repas1 = new Repas(TypeRepas.PETIT_DEJ);
		Repas repas2 = new Repas(TypeRepas.DEJ);
		Repas repas3 = new Repas(TypeRepas.DINNER);

		repas1 = repasRepo.save(repas1);
		repas2 = repasRepo.save(repas2);
		repas3 = repasRepo.save(repas3);

		List<Repas> repas = repasRepo.findAll();

		try {
			assertEquals(3, repas.size());
		}

		finally {
			repasRepo.delete(repas1);
			repasRepo.delete(repas2);
			repasRepo.delete(repas3);
		}
	}

	@Test
	public void findAllRepasByTypeRepas() {

		Repas repas1 = new Repas(TypeRepas.PETIT_DEJ);
		Repas repas2 = new Repas(TypeRepas.DEJ);
		Repas repas3 = new Repas(TypeRepas.DEJ);
		Repas repas4 = new Repas(TypeRepas.DINNER);

		repas1 = repasRepo.save(repas1);
		repas2 = repasRepo.save(repas2);
		repas3 = repasRepo.save(repas3);

		List<Repas> repas = repasRepo.findAllRepasByTypeRepas(TypeRepas.DEJ);

		try {
			assertEquals(2, repas.size());
		}

		finally {
			repasRepo.delete(repas1);
			repasRepo.delete(repas2);
			repasRepo.delete(repas3);
			repasRepo.delete(repas4);
		}
	}
	
	@Test
	public void repasDelete() {

		Repas repas1 = new Repas(TypeRepas.PETIT_DEJ);
		Repas repas2 = new Repas(TypeRepas.DEJ);
		Repas repas3 = new Repas(TypeRepas.DINNER);

		repas1 = repasRepo.save(repas1);
		repas2 = repasRepo.save(repas2);
		repas3 = repasRepo.save(repas3);

		List<Repas> repas = repasRepo.findAll();

		try {
			assertEquals(3, repas.size());
		}

		finally {
			repasRepo.delete(repas1);
			repasRepo.delete(repas2);
			repasRepo.delete(repas3);

			repas = repasRepo.findAll();

			assertEquals(0, repas.size());
		}
	}

	/*
	 * CREATE TEST WITH LINKS
	 * 
	 * @Test public void repasCreate() {
	 * 
	 * SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	 * 
	 * IRepasRepository repasRepo = Application.getInstance().getRepasRepo();
	 * IMenuRepository menuRepo = Application.getInstance().getMenuRepo();
	 * IPlatRepository platRepo = Application.getInstance().getPlatRepo();
	 * 
	 * try {
	 * 
	 * Menu menu1 = new Menu(); menu1.setJour(sdf.parse("11-12-1993")); menu1 =
	 * menuRepo.save(menu1);
	 * 
	 * Plat plat1 = new Plat(); Plat plat2 = new Plat(); plat1.setNombrePersonne(2);
	 * plat2.setNombrePersonne(4); plat1 = platRepo.save(plat1); plat2 =
	 * platRepo.save(plat2);
	 * 
	 * List<Plat> plats = platRepo.findAll();
	 * 
	 * Repas repas1 = new Repas(); repas1.setTypeRepas(TypeRepas.PETIT_DEJ);
	 * repas1.setMenu(menu1); repas1.setPlats(plats);
	 * 
	 * repas1 = repasRepo.save(repas1);
	 * 
	 * Repas repasFind = repasRepo.findById(repas1.getId());
	 * 
	 * Assert.assertEquals(TypeRepas.PETIT_DEJ, repasFind.getTypeRepas());
	 * Assert.assertEquals(menu1, repasFind.getMenu()); Assert.assertEquals(plats,
	 * repasFind.getPlats());
	 * 
	 * menuRepo.delete(menu1); platRepo.delete(plat1); platRepo.delete(plat2);
	 * repasRepo.delete(repas1);
	 * 
	 * } catch (ParseException e) { e.printStackTrace(); } }
	 * 
	 */

	/*
	 * UPDATE TEST WITH LINKS
	 * 
	 * @Test public void repasUpdate() {
	 * 
	 * SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	 * 
	 * IRepasRepository repasRepo = Application.getInstance().getRepasRepo();
	 * IMenuRepository menuRepo = Application.getInstance().getMenuRepo();
	 * IPlatRepository platRepo = Application.getInstance().getPlatRepo();
	 * 
	 * try {
	 * 
	 * Menu menu1 = new Menu(); menu1.setJour(sdf.parse("11-12-1993")); menu1 =
	 * menuRepo.save(menu1);
	 * 
	 * Menu menu2 = new Menu(); menu2.setJour(sdf.parse("11-12-2000")); menu2 =
	 * menuRepo.save(menu2);
	 * 
	 * Plat plat1 = new Plat(); Plat plat2 = new Plat(); plat1.setNombrePersonne(2);
	 * plat2.setNombrePersonne(4); plat1 = platRepo.save(plat1); plat2 =
	 * platRepo.save(plat2); List<Plat> plats = platRepo.findAll();
	 * 
	 * Plat plat3 = new Plat(); Plat plat4 = new Plat();
	 * plat3.setNombrePersonne(10); plat4.setNombrePersonne(6); plat3 =
	 * platRepo.save(plat3); plat4 = platRepo.save(plat4); List<Plat> plats2 =
	 * platRepo.findAll();
	 * 
	 * Repas repas1 = new Repas(); repas1.setTypeRepas(TypeRepas.PETIT_DEJ);
	 * repas1.setMenu(menu1); repas1.setPlats(plats);
	 * 
	 * repas1 = repasRepo.save(repas1);
	 * 
	 * repas1.setTypeRepas(TypeRepas.DINNER); repas1.setMenu(menu2);
	 * repas1.setPlats(plats2);
	 * 
	 * Repas repasFind = repasRepo.findById(repas1.getId());
	 * 
	 * Assert.assertEquals(TypeRepas.DINNER, repasFind.getTypeRepas());
	 * Assert.assertEquals(menu2, repasFind.getMenu()); Assert.assertEquals(plats2,
	 * repasFind.getPlats());
	 * 
	 * menuRepo.delete(menu1); menuRepo.delete(menu2); platRepo.delete(plat1);
	 * platRepo.delete(plat2); platRepo.delete(plat3); platRepo.delete(plat4);
	 * repasRepo.delete(repas1);
	 * 
	 * } catch (ParseException e) { e.printStackTrace(); } }
	 * 
	 */

}
