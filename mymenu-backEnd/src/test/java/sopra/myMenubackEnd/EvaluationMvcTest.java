package sopra.myMenubackEnd;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import sopra.formation.model.Evaluation;
import sopra.formation.repository.IEvaluationRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class EvaluationMvcTest {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private IEvaluationRepository evaluationRepo;

	@Test
	@WithUserDetails("manon")
	public void evaluationGet() throws Exception {
		mockMvc.perform(get("/rest/evaluation")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	@WithUserDetails("manon")
	public void evaluationPost() throws Exception {
		Evaluation eval = new Evaluation(12, 16, "pas mal");

		ObjectMapper mapper = new ObjectMapper();
		String jsonEval = mapper.writeValueAsString(eval);

		mockMvc.perform(post("/rest/evaluation").contentType(MediaType.APPLICATION_JSON).content(jsonEval))
				.andExpect(status().isOk()).andExpect(jsonPath("$.id", is(notNullValue())))
				.andExpect(jsonPath("$.version").value(0)).andExpect(jsonPath("$.comportemental").value(12));

	}

	@Test
	@WithUserDetails(value = "eric")
	public void evaluationFindByComportemental() throws Exception {
		int sizeStart = evaluationRepo.findByComportementalGreaterThanEqual(10).size();

		Evaluation eval1 = new Evaluation(12, 16, "pas mal");
		evaluationRepo.save(eval1);

		Evaluation eval2 = new Evaluation(9, 16, "pas mal 2");
		evaluationRepo.save(eval2);

		Evaluation eval3 = new Evaluation(17, 16, "pas mal 3");
		evaluationRepo.save(eval3);
		
		mockMvc.perform(get("/rest/evaluation/by-comportemental/10")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.length()").value(sizeStart + 2));
	}
}
