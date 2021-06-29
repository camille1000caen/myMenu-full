package sopra.myMenubackEnd.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;


import sopra.myMenubackEnd.model.Plat;

import sopra.myMenubackEnd.repository.IPlatRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class TestPlat {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private IPlatRepository platRepo;
	
	
	
	@Test
	public void platGet() throws Exception {
		mockMvc.perform(get("/plat")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
	@Test
	public void PlatPost() throws Exception {
		Plat plat = new Plat(12);

		ObjectMapper mapper = new ObjectMapper();
		String jsonEval = mapper.writeValueAsString(plat);

		mockMvc.perform(post("/rest/evaluation").contentType(MediaType.APPLICATION_JSON).content(jsonEval))
				.andExpect(status().isOk()).andExpect(jsonPath("$.id", is(notNullValue())))
				.andExpect(jsonPath("$.version").value(0)).andExpect(jsonPath("$.comportemental").value(12));

	}
	@Test
	public void findAllByRepas() throws Exception {
		int sizeStart = platRepo.findAllByRepas("DINER").size();

		Plat plat1 = new Plat(12);
		platRepo.save(plat1);

		Plat plat2 = new Plat(9);
		platRepo.save(plat2);

		Plat plat3 = new Plat(17);
		platRepo.save(plat3);
		
		mockMvc.perform(get("/plat/by-repas/{repas}")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.length()").value(sizeStart + 2));
	}


	
	
	@Test	
	public void platCreate() {
		
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");
			IPlatRepository platRepo = context.getBean(IPlatRepository.class);
		
		Plat plat1 = new Plat(2);

		plat1 = platRepo.save(plat1);
		
		Plat platFind = platRepo.findById(plat1.getId()).get();
		
		
		
		assertEquals(2, platFind.getNombrePersonne());

		platRepo.delete(plat1);
		context.close();
		
	}

	@Test
	public void platUpdate() {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");
			IPlatRepository platRepo = context.getBean(IPlatRepository.class);
		
		Plat plat1 = new Plat(2);

		plat1 = platRepo.save(plat1);

		plat1.setNombrePersonne(4);

		plat1 = platRepo.save(plat1);
		Plat platFind = platRepo.findById(plat1.getId()).get();
		
		assertEquals(4, platFind.getNombrePersonne());;
		
				
		platRepo.delete(plat1);
		context.close();
	}

	@Test
	public void platFindAll() {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");
			IPlatRepository platRepo = context.getBean(IPlatRepository.class);
		
		Plat plat1 = new Plat(3);

		Plat plat2 = new Plat(3);

		plat1 = platRepo.save(plat1);
		plat2 = platRepo.save(plat2);

		List<Plat> plats = platRepo.findAll();

		assertEquals(2, plats.size());

		platRepo.delete(plat1);
		platRepo.delete(plat2);
			
		context.close();
	}

	@Test
	public void platDelete() {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");
			IPlatRepository platRepo = context.getBean(IPlatRepository.class);
		
		Plat plat1 = new Plat(2);

		Plat plat2 = new Plat(2);

		plat1 = platRepo.save(plat1);
		plat2 = platRepo.save(plat2);

		List<Plat> plats = platRepo.findAll();

		assertEquals(2, plats.size());

		platRepo.delete(plat1);
		platRepo.delete(plat2);

		plats = platRepo.findAll();

		assertEquals(0, plats.size());
		
		assertEquals(0, plats.size());
		context.close();
	}
}
