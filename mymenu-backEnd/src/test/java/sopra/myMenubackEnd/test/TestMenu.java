package sopra.myMenubackEnd.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.myMenubackEnd.model.Menu;
import sopra.myMenubackEnd.repository.IMenuRepository;

@SpringBootTest
public class TestMenu {
	
	@Autowired
	private IMenuRepository menuRepo;
	
	@Test
	public void menuCreate() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Menu menu1 = new Menu();

		try {
			menu1.setJour(sdf.parse("1993-12-11"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		menu1 = menuRepo.save(menu1);

		Menu menuFind = menuRepo.findById(menu1.getId()).get();

		try {
			assertEquals(sdf.parse("1993-12-11"), menuFind.getJour());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		menuRepo.delete(menu1);
	}

	@Test
	public void menuUpdate() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Menu menu1 = new Menu();
		try {
			menu1.setJour(sdf.parse("1993-12-11"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		menu1 = menuRepo.save(menu1);

		try {
			menu1.setJour(sdf.parse("2021-10-12"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		menu1 = menuRepo.save(menu1);

		Menu menuFind = menuRepo.findById(menu1.getId()).get();

		try {
			assertEquals(sdf.parse("2021-10-12"), menuFind.getJour());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		menuRepo.delete(menu1);
	}

	@Test
	public void menuFindAll() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {

			Menu menu1 = new Menu();
			Menu menu2 = new Menu();
			Menu menu3 = new Menu();

			menu1.setJour(sdf.parse("1993-12-11"));
			menu1.setJour(sdf.parse("2000-12-11"));
			menu1.setJour(sdf.parse("2021-12-11"));

			menu1 = menuRepo.save(menu1);
			menu2 = menuRepo.save(menu2);
			menu3 = menuRepo.save(menu3);

			List<Menu> menus = menuRepo.findAll();

			assertEquals(3, menus.size());

			menuRepo.delete(menu1);
			menuRepo.delete(menu2);
			menuRepo.delete(menu3);

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void menuDelete() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {

			Menu menu1 = new Menu();
			Menu menu2 = new Menu();
			Menu menu3 = new Menu();
			
			menu1.setJour(sdf.parse("1993-12-11"));
			menu1.setJour(sdf.parse("2000-12-11"));
			menu1.setJour(sdf.parse("2021-12-11"));


			menu1 = menuRepo.save(menu1);
			menu2 = menuRepo.save(menu2);
			menu3 = menuRepo.save(menu3);

			List<Menu> menus = menuRepo.findAll();

			assertEquals(3, menus.size());

			menuRepo.delete(menu1);
			menuRepo.delete(menu2);
			menuRepo.delete(menu3);

			menus = menuRepo.findAll();

			assertEquals(0, menus.size());

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
