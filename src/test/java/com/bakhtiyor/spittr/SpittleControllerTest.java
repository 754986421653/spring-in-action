package com.bakhtiyor.spittr;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import org.junit.Test;
import org.hamcrest.Matchers;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import com.bakhtiyor.spittr.controllers.SpittleController;
import com.bakhtiyor.spittr.models.Spittle;
import com.bakhtiyor.spittr.repositories.SpittleRepository;

public class SpittleControllerTest {

	@Test
	public void shouldShowRecentSpittles() throws Exception {
		List<Spittle> expectedSpittles = createSpittleList(20);
		SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
		Mockito.when(mockRepository.findSpittles(Long.MAX_VALUE, 20))
				.thenReturn(expectedSpittles);

		SpittleController controller = new SpittleController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller)
				.setSingleView(
					new InternalResourceView("/WEB-INF/views/spittles.jsp")
				)
				.build();

		mockMvc.perform(get("/spittles"))
				.andExpect(view().name("spittles"))
				.andExpect(model().attributeExists("spittleList"))
				.andExpect(model().attribute(
					"spittleList", Matchers.hasItems(expectedSpittles.toArray())
				));
	}

	@Test
	public void shouldShowPagedSpittles() throws Exception {
		long max = 238900;
		int count = 50;
		List<Spittle> expectedSpittles = createSpittleList(count);
		SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
		Mockito.when(mockRepository.findSpittles(max, count))
				.thenReturn(expectedSpittles);

		SpittleController controller = new SpittleController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller)
				.setSingleView(
					new InternalResourceView("/WEB-INF/views/spittles.jsp")
				)
				.build();

		mockMvc.perform(get("/spittles?max=" + max + "&count=" + count))
				.andExpect(view().name("spittles"))
				.andExpect(model().attributeExists("spittleList"))
				.andExpect(model().attribute(
					"spittleList", Matchers.hasItems(expectedSpittles.toArray())
				));
	}	

	@Test
	public void testSpittle() throws Exception {
		long id = 12345;
		Spittle expectedSpittle = new Spittle("Hello", new Date());
		SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
		Mockito.when(mockRepository.findOne(id))
				.thenReturn(expectedSpittle);

		SpittleController controller = new SpittleController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller).build();

		mockMvc.perform(get("/spittles/" + id))
				.andExpect(view().name("spittle"))
				.andExpect(model().attributeExists("spittle"))
				.andExpect(model().attribute("spittle", expectedSpittle));
	}

	private List<Spittle> createSpittleList(int count) {
		List<Spittle> spittles = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			spittles.add(new Spittle("Spittle " + i, new Date()));
		}

		return spittles;
	}
}