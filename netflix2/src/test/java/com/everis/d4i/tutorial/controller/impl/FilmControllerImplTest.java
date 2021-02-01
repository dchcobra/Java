package com.everis.d4i.tutorial.controller.impl;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.everis.d4i.tutorial.controller.mapper.FilmRestMapper;
import com.everis.d4i.tutorial.controller.rest.FilmRest;
import com.everis.d4i.tutorial.service.FilmService;
import com.everis.d4i.tutorial.service.dto.FilmDto;

@RunWith(SpringRunner.class)
@WebMvcTest(FilmControllerImpl.class)
public class FilmControllerImplTest {

	@Autowired
	private MockMvc mockMvc;
	
	// Definimos los Beans
	@MockBean
	private FilmService filmService;
	@MockBean
	private FilmRestMapper filmRestMapper;
	
	// Test of method GET FILMS
	@Test
	public void getFilms_test() throws Exception {
		// Creamos un objeto para poder hacer pruebas
		FilmDto film = new FilmDto(1L, "Ford v Ferrari", 2019, "United States", "English", 152, "sports drama film"
				, "American car designer Carroll Shelby and driver Ken Miles battle corporate interference and the "
						+ "laws of physics to build a revolutionary race car for Ford in order to defeat Ferrari at "
						+ "the 24 Hours of Le Mans in 1966.");
		Mockito.when(filmService.getFilms()).thenReturn(List.of(film)); // Le damos a mockito lo que tiene que recibir sin procesar
		
		// Creamos un rest para hacer el test de mapear
		FilmRest filmRest = new FilmRest(1L, "Ford v Ferrari", 2019, "United States", "English", 152, "sports drama film"
				, "American car designer Carroll Shelby and driver Ken Miles battle corporate interference and the "
						+ "laws of physics to build a revolutionary race car for Ford in order to defeat Ferrari at "
						+ "the 24 Hours of Le Mans in 1966.");
		Mockito.when(filmRestMapper.mapToRest(film)).thenReturn(filmRest); // JSON para hacer el test
		// Method GET of films, URL donde se espera el resultado 
		RequestBuilder request = MockMvcRequestBuilders
				.get("/netflix2/v1/films")
				.accept(MediaType.APPLICATION_JSON);
		
		// Especificamos que es lo que vamos a recibir
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content()
				.json("{\"status\":\"Success\",\"code\":\"200 OK\",\"message\":\"OK\",\"data\":[{\"id\":1,\"name\":\"Ford v Ferrari\",\"year\":2019"
						+ ",\"country\":\"United States\",\"language\":\"English\",\"duration\":152,\"shortDescription\":\"sports drama film\""
						+ ",\"longDescription\":\"American car designer Carroll Shelby and driver Ken Miles battle corporate interference and the "
						+ "laws of physics to build a revolutionary race car for Ford in order to defeat Ferrari at the 24 Hours of Le Mans in 1966.\"}]}"))
				.andReturn();
	}
}
