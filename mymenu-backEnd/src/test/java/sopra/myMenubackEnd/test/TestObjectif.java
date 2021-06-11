package sopra.myMenubackEnd.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.myMenubackEnd.model.Objectif;
import sopra.myMenubackEnd.model.TypeObjectif;
import sopra.myMenubackEnd.repository.IObjectifRepository;

@SpringBootTest
public class TestObjectif {

	@Autowired
	private IObjectifRepository objectifRepo;
	
	@Test
	public void objectifCreate() {

		Objectif objectif1 = new Objectif();

		objectif1.setTypeObjectif(TypeObjectif.BIEN_ETRE);
		objectif1.setCommentaire("commentaire1");
		objectif1.setNombreCaloriesParSemaine(2400);
		objectif1.setNombreRepasParJour(3);
		objectif1 = objectifRepo.save(objectif1);

		try {
			Objectif objectifFind = objectifRepo.findById(objectif1.getId()).get();

			assertEquals(TypeObjectif.BIEN_ETRE, objectifFind.getTypeObjectif());
			assertEquals("commentaire1", objectifFind.getCommentaire());
			assertEquals(2400, objectifFind.getNombreCaloriesParSemaine());
			assertEquals(3, objectifFind.getNombreRepasParJour());
		}

		finally {
			objectifRepo.delete(objectif1);
		}
	}

	@Test
	public void objectifUpdate() {

		Objectif objectif1 = new Objectif();

		objectif1.setTypeObjectif(TypeObjectif.BIEN_ETRE);
		objectif1.setCommentaire("commentaire1");
		objectif1.setNombreCaloriesParSemaine(2400);
		objectif1.setNombreRepasParJour(3);
		objectif1 = objectifRepo.save(objectif1);

		objectif1.setTypeObjectif(TypeObjectif.PRISE_MASSE);
		objectif1.setCommentaire("commentaire2");
		objectif1.setNombreCaloriesParSemaine(1800);
		objectif1.setNombreRepasParJour(2);
		objectif1 = objectifRepo.save(objectif1);

		try {
			Objectif objectifFind = objectifRepo.findById(objectif1.getId()).get();

			assertEquals(TypeObjectif.PRISE_MASSE, objectifFind.getTypeObjectif());
			assertEquals("commentaire2", objectifFind.getCommentaire());
			assertEquals(1800, objectifFind.getNombreCaloriesParSemaine());
			assertEquals(2, objectifFind.getNombreRepasParJour());
		}

		finally {
			objectifRepo.delete(objectif1);
		}
	}

	@Test
	public void objectifFindAll() {

		Objectif objectif1 = new Objectif();
		Objectif objectif2 = new Objectif();

		objectif1.setTypeObjectif(TypeObjectif.BIEN_ETRE);
		objectif1.setCommentaire("commentaire1");
		objectif1.setNombreCaloriesParSemaine(2400);
		objectif1.setNombreRepasParJour(3);
		objectif1 = objectifRepo.save(objectif1);

		objectif2.setTypeObjectif(TypeObjectif.PRISE_MASSE);
		objectif2.setCommentaire("commentaire2");
		objectif2.setNombreCaloriesParSemaine(1800);
		objectif2.setNombreRepasParJour(2);
		objectif2 = objectifRepo.save(objectif2);

		List<Objectif> objectifs = objectifRepo.findAll();
				
		try {
			assertEquals(2, objectifs.size());
		}

		finally {
			objectifRepo.delete(objectif1);
			objectifRepo.delete(objectif2);
		}
	}
	
	@Test
	public void objectifDelete() {

		Objectif objectif1 = new Objectif();
		Objectif objectif2 = new Objectif();

		objectif1.setTypeObjectif(TypeObjectif.BIEN_ETRE);
		objectif1.setCommentaire("commentaire1");
		objectif1.setNombreCaloriesParSemaine(2400);
		objectif1.setNombreRepasParJour(3);
		objectif1 = objectifRepo.save(objectif1);

		objectif2.setTypeObjectif(TypeObjectif.PRISE_MASSE);
		objectif2.setCommentaire("commentaire2");
		objectif2.setNombreCaloriesParSemaine(1800);
		objectif2.setNombreRepasParJour(2);
		objectif2 = objectifRepo.save(objectif2);

		List<Objectif> objectifs = objectifRepo.findAll();
				
		try {
			assertEquals(2, objectifs.size());
		}

		finally {
			objectifRepo.delete(objectif1);
			objectifRepo.delete(objectif2);
			
			objectifs = objectifRepo.findAll();
			
			assertEquals(0, objectifs.size());
		}
	}	
}
