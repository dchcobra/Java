package com.everis.d4i.tutorial.controller.impl;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoAssertionError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.everis.d4i.tutorial.controller.mapper.FilmRestMapper;
import com.everis.d4i.tutorial.controller.rest.FilmRest;
import com.everis.d4i.tutorial.controller.rest.FilteringParameters;
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
	
	@Test
	public void getFilms_test() throws Exception {
		FilmDto film = new FilmDto(1L, "Ford v Ferrari", 2019, "United States", "English", 152, "sports drama film"
				, "American car designer Carroll Shelby and driver Ken Miles battle corporate interference and the "
						+ "laws of physics to build a revolutionary race car for Ford in order to defeat Ferrari at "
						+ "the 24 Hours of Le Mans in 1966.");
		
		Mockito.when(filmService.getPageOfFilms(pageable)).thenReturn();
		
		
		FilmRest filmRest = new FilmRest(1L, "Ford v Ferrari", 2019, "United States", "English", 152, "sports drama film"
				, "American car designer Carroll Shelby and driver Ken Miles battle corporate interference and the "
						+ "laws of physics to build a revolutionary race car for Ford in order to defeat Ferrari at "
						+ "the 24 Hours of Le Mans in 1966.");
		
		Mockito.when(filmRestMapper.mapToRest(film)).thenReturn(filmRest);

		RequestBuilder request = MockMvcRequestBuilders
				.get("http://localhost:8088/netflix/v1/netflix2/v1/films?page=0&size=8")
				.accept(MediaType.APPLICATION_JSON);
						
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content()
				.json("{\"status\":\"Success\",\"code\":\"200 OK\",\"message\":\"OK\",\"data\":{\"content\""
						+ ":[{\"id\":1,\"name\":\"Ford v Ferrari\",\"year\":2019,\"country\":"
						+ "\"United States\",\"language\":\"English\",\"duration\":152,\"shortDescription\":"
						+ "\"sports drama film\",\"longDescription\":\"American car designer Carroll Shelby "
						+ "and driver Ken Miles battle corporate interference and the laws of physics to build"
						+ " a revolutionary race car for Ford in order to defeat Ferrari at the 24 Hours of Le"
						+ " Mans in 1966.\"}],\"pageable\":{\"sort\":{\"sorted\":true,\"unsorted\":false,\"empty\":"
						+ "false},\"pageNumber\":0,\"pageSize\":1,\"offset\":0,\"paged\":true,\"unpaged\":false},"
						+ "\"totalElements\":39,\"totalPages\":39,\"last\":false,\"size\":1,\"number\":0,\"sort\":"
						+ "{\"sorted\":true,\"unsorted\":false,\"empty\":false},\"numberOfElements\":1,\"first\":true,\"empty\":false}}"))
				.andReturn();
	}
	
	
	@Test
	public void getFilmsFilteredStatic_test() throws Exception {
		
		int minimumDuration = 120;
		
		FilmDto film = new FilmDto(1L, "Ford v Ferrari", 2019, "United States", "English", 152, "sports drama film"
				, "American car designer Carroll Shelby and driver Ken Miles battle corporate interference and the "
						+ "laws of physics to build a revolutionary race car for Ford in order to defeat Ferrari at "
						+ "the 24 Hours of Le Mans in 1966.");
		
		Mockito.when(filmService.getFilmsFilteredByMinimumDuration(minimumDuration)).thenReturn(List.of(film));

		FilmRest filmRest = new FilmRest(1L, "Ford v Ferrari", 2019, "United States", "English", 152, "sports drama film"
				, "American car designer Carroll Shelby and driver Ken Miles battle corporate interference and the "
						+ "laws of physics to build a revolutionary race car for Ford in order to defeat Ferrari at "
						+ "the 24 Hours of Le Mans in 1966.");
		
		Mockito.when(filmRestMapper.mapToRest(film)).thenReturn(filmRest);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/netflix2/v1/films-filtered-static?minimumDuration=120")
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request)
		.andExpect(status().isOk())
		.andExpect(content()
		.json("{\"status\":\"Success\",\"code\":\"200 OK\",\"message\":\"OK\",\"data\":[{\"id\":1,\"name\":\"Ford v Ferrari\""
				+ ",\"year\":2019,\"country\":\"United States\",\"language\":\"English\",\"duration\":152,\"shortDescription\":"
				+ "\"sports drama film\",\"longDescription\":\"American car designer Carroll Shelby and driver Ken Miles battle"
				+ " corporate interference and the laws of physics to build a revolutionary race car for Ford in order to defeat"
				+ " Ferrari at the 24 Hours of Le Mans in 1966.\"}]}"))
		.andReturn();
	}
	
	
	@Test
	public void getFilmsFilteredDynamic_test() throws Exception {
		
		FilmDto film = new FilmDto(1L, "Ford v Ferrari", 2019, "United States", "English", 152, "sports drama film"
				, "American car designer Carroll Shelby and driver Ken Miles battle corporate interference and the "
						+ "laws of physics to build a revolutionary race car for Ford in order to defeat Ferrari at "
						+ "the 24 Hours of Le Mans in 1966.");
		
        String name = "Ford";
		FilteringParameters filters = FilteringParameters.builder()
                .name(name)
                .build();
		
		Mockito.when(filmService.getDynamicallyFiltered(filters)).thenReturn(List.of(film));
		
		FilmRest filmRest = new FilmRest(1L, "Ford v Ferrari", 2019, "United States", "English", 152, "sports drama film"
				, "American car designer Carroll Shelby and driver Ken Miles battle corporate interference and the "
						+ "laws of physics to build a revolutionary race car for Ford in order to defeat Ferrari at "
						+ "the 24 Hours of Le Mans in 1966.");
		
		Mockito.when(filmRestMapper.mapToRest(film)).thenReturn(filmRest);

		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/netflix2/v1/films-filtered-dinamically?name=Ford")
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request)
		.andExpect(status().isOk())
		.andExpect(content()
		.json("{\"status\":\"Success\",\"code\":\"200 OK\",\"message\":\"OK\",\"data\":[{\"id\":1,\"name\":\"Ford v Ferrari\""
				+ ",\"year\":2019,\"country\":\"United States\",\"language\":\"English\",\"duration\":152,\"shortDescription\":"
				+ "\"sports drama film\",\"longDescription\":\"American car designer Carroll Shelby and driver Ken Miles battle"
				+ " corporate interference and the laws of physics to build a revolutionary race car for Ford in order to defeat"
				+ " Ferrari at the 24 Hours of Le Mans in 1966.\"}]}"))
		.andReturn();
	}
}
