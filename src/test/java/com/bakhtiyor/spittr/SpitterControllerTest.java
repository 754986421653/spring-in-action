package com.bakhtiyor.spittr;

import com.bakhtiyor.spittr.controllers.SpitterController;
import com.bakhtiyor.spittr.models.Spitter;
import com.bakhtiyor.spittr.repositories.SpitterRepository;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class SpitterControllerTest {

	@Test
	public void shouldShowRegistration() throws Exception {
	    SpitterRepository mockRepository = Mockito.mock(SpitterRepository.class);
		SpitterController controller = new SpitterController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller).build();

		mockMvc.perform(get("/spitter/register"))
				.andExpect(view().name("registerForm"));
	}

	@Test
	public void shouldProcessRegistration() throws Exception {
		String username = "jbauer";
		String password = "24hours";
		String firstName = "Jack";
		String lastName = "Bauer";

		SpitterRepository mockRepositiory = Mockito.mock(SpitterRepository.class);
		Spitter unsaved = new Spitter(username, password, firstName, lastName);
		Spitter saved = new Spitter(24L, username, password, firstName, lastName);

		Mockito.when(mockRepositiory.save(unsaved)).thenReturn(saved);

		SpitterController controller = new SpitterController(mockRepositiory);
		MockMvc mockMvc = standaloneSetup(controller).build();

		mockMvc.perform(
			post("/spitter/register")
					.param("firstName", firstName)
					.param("lastName", lastName)
					.param("username", username)
					.param("password", password)
		).andExpect(redirectedUrl("/spitter/" + username));

		Mockito.verify(mockRepositiory, Mockito.atLeastOnce()).save(unsaved);
	}
}