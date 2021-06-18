package sopra.myMenubackEnd.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.test.context.support.WithUserDetails;

import sopra.formation.model.Evaluation;
import sopra.myMenubackEnd.model.AjustementQuantite;
import sopra.myMenubackEnd.model.Magasin;
import sopra.myMenubackEnd.model.MagasinIngredient;
import sopra.myMenubackEnd.repository.IAdresseRepository;
import sopra.myMenubackEnd.repository.IAjustementQuantiteRepository;
import sopra.myMenubackEnd.repository.IIngredientRepository;
import sopra.myMenubackEnd.repository.IListeCourseRepository;
import sopra.myMenubackEnd.repository.IMagasinIngredientRepository;
import sopra.myMenubackEnd.repository.IMagasinRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerRestTestCamille {
	
	@Autowired
	private MockMvc mockMvc;
	
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
	
	//////////////////////Test méthodes GET pour listeCourse, magasin, magasinIngredient et Ajustement Quantité///////////////////////////////////////
	@Test
	@WithUserDetails("user")
	public void listeCourseGet() throws Exception {
		mockMvc.perform(get("/listeCourse")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
	
	@Test
	@WithUserDetails("user")
	public void magasinGet() throws Exception {
		mockMvc.perform(get("/magasin")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
	
	@Test
	@WithUserDetails("user")
	public void magasinIngredientGet() throws Exception {
		mockMvc.perform(get("/magasinIngredient")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
	
	@Test
	@WithUserDetails("user")
	public void ajustementQuantiteGet() throws Exception {
		mockMvc.perform(get("/ajustementQuantite")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
		
//////////////////////Test méthodes POST pour listeCourse, magasin, magasinIngredient et Ajustement Quantité///////////////////////////////////////
	
	@Test
	@WithUserDetails("admin")
	public void quantiteModifeePost() throws Exception {
		AjustementQuantite ajustement = new AjustementQuantite();
		ajustement.setQuantiteModifiee(2F);	

		ObjectMapper mapper = new ObjectMapper();
		String jsonEval = mapper.writeValueAsString(ajustement);

		mockMvc.perform(post("/ajustementQuantite").contentType(MediaType.APPLICATION_JSON).content(jsonEval))
				.andExpect(status().isOk()).andExpect(jsonPath("$.id", is(notNullValue())))
				.andExpect(jsonPath("$.version").value(0)).andExpect(jsonPath("$.quantiteModifiee").value(2F));

	}
	
	@Test
	@WithUserDetails("admin")
	public void magasinPost() throws Exception {
		Magasin magasin = new Magasin();

		magasin.setNom("Carrefour");
		magasin.setSiret("123456789");


		ObjectMapper mapper = new ObjectMapper();
		String jsonEval = mapper.writeValueAsString(magasin);

		mockMvc.perform(post("/magasin").contentType(MediaType.APPLICATION_JSON).content(jsonEval))
				.andExpect(status().isOk()).andExpect(jsonPath("$.id", is(notNullValue())))
				.andExpect(jsonPath("$.version").value(0)).andExpect(jsonPath("$.nom").value("Carrefour")).andExpect(jsonPath("$.siret").value("123456789"));

	}
	
	@Test
	@WithUserDetails("admin")
	public void magasinIngredientPost() throws Exception {
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


		ObjectMapper mapper = new ObjectMapper();
		String jsonEval = mapper.writeValueAsString(magasinIngred);

		mockMvc.perform(post("/magasinIngredient").contentType(MediaType.APPLICATION_JSON).content(jsonEval))
				.andExpect(status().isOk()).andExpect(jsonPath("$.id", is(notNullValue())))
				.andExpect(jsonPath("$.version").value(0)).andExpect(jsonPath("$.bio").value(true)).andExpect(jsonPath("$.datePeremption").value("2021-10-10")).andExpect(jsonPath("$.prix").value(3.5F)).andExpect(jsonPath("$.produitLocal").value(false)).andExpect(jsonPath("$.marque").value("marque repère"));

	}
	
	

}
