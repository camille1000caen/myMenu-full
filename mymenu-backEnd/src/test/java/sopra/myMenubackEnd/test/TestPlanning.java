package sopra.myMenubackEnd.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.myMenubackEnd.model.Planning;
import sopra.myMenubackEnd.repository.IPlanningRepository;

@SpringBootTest
public class TestPlanning {

	@Autowired
	private IPlanningRepository planningRepo;
	
	@Test
	public void planningCreate() {

		Planning planning1 = new Planning();

		try {
			planning1.setPeriode(7);
			planning1 = planningRepo.save(planning1);

			Planning planningFind = planningRepo.findById(planning1.getId()).get();

			assertEquals(Duration.ofDays(7), planningFind.getPeriode());
		}

		finally {
			planningRepo.delete(planning1);
		}
	}

	@Test
	public void planningUpdate() {

		Planning planning1 = new Planning();

		try {
			planning1.setPeriode(7);
			planning1 = planningRepo.save(planning1);

			planning1.setPeriode(4);
			planning1 = planningRepo.save(planning1);

			Planning planningFind = planningRepo.findById(planning1.getId()).get();

			assertEquals(Duration.ofDays(4), planningFind.getPeriode());
		}

		finally {
			planningRepo.delete(planning1);
		}
	}

	@Test
	public void planningFindAll() {

		Planning planning1 = new Planning();
		Planning planning2 = new Planning();
		Planning planning3 = new Planning();

		planning1.setPeriode(7);
		planning2.setPeriode(2);
		planning3.setPeriode(5);

		planning1 = planningRepo.save(planning1);
		planning2 = planningRepo.save(planning2);
		planning3 = planningRepo.save(planning3);

		List<Planning> plannings = planningRepo.findAll();

		try {
			assertEquals(3, plannings.size());
		}

		finally {
			planningRepo.delete(planning1);
			planningRepo.delete(planning2);
			planningRepo.delete(planning3);
		}
	}

	@Test
	public void planningDelete() {

		Planning planning1 = new Planning();
		Planning planning2 = new Planning();
		Planning planning3 = new Planning();

		planning1.setPeriode(7);
		planning2.setPeriode(2);
		planning3.setPeriode(5);

		planning1 = planningRepo.save(planning1);
		planning2 = planningRepo.save(planning2);
		planning3 = planningRepo.save(planning3);

		List<Planning> plannings = planningRepo.findAll();

		try {
			assertEquals(3, plannings.size());
		}

		finally {
			planningRepo.delete(planning1);
			planningRepo.delete(planning2);
			planningRepo.delete(planning3);
			
			plannings = planningRepo.findAll();
			
			assertEquals(0, plannings.size());		
		}
	}

}
