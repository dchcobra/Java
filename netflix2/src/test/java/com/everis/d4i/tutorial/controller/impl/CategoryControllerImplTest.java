package com.everis.d4i.tutorial.controller.impl;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.everis.d4i.tutorial.controller.mapper.CategoryRestMapper;
import com.everis.d4i.tutorial.controller.rest.CategoryRest;
import com.everis.d4i.tutorial.service.CategoryService;
import com.everis.d4i.tutorial.service.dto.CategoryDto;


@RunWith(SpringRunner.class)
@WebMvcTest(CategoryControllerImpl.class)
public class CategoryControllerImplTest {

	@Autowired
	private MockMvc mockMvc;
	
	// Definimos los Beans que utiliza
	@MockBean
	CategoryService categoryService;
	@MockBean
	CategoryRestMapper categoryRestMapper;
	
	// Test of method GET CATEGORIES
	@Test
	public void getCategories_test() throws Exception {
		// Creamos el objeto del bean para hacer pruebas
		CategoryDto category = new CategoryDto(1, "testMockito");
		Mockito.when(categoryService.getCategories()).thenReturn(List.of(category)); // Le damos a mockito lo que tiene que recibir sin procesar
		
		// Creamos un Rest para hacer el test procesado 
		CategoryRest categoryRest = new CategoryRest(1, "testMockito");
		Mockito.when(categoryRestMapper.mapToRest(category)).thenReturn(categoryRest); // JSON para el test

		// Method GET of categories, URL donde se espera el resultado 
		RequestBuilder request = MockMvcRequestBuilders
				.get("/netflix2/v1/categories")
				.accept(MediaType.APPLICATION_JSON);
		
		// Especificamos que es lo que vamos a recibir
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content()
				.json("{\"status\":\"Success\",\"code\":\"200 OK\",\"message\":\"OK\",\"data\":[{\"id\": 1, \"name\": \"testMockito\"}]}"))
				.andReturn();
	}
	
	@Test
	public void createCategory_test() throws Exception {
		
			CategoryDto categoryCreate = new CategoryDto(1, "testMockito");
			Mockito.when(categoryService.getCategories()).thenReturn(List.of(categoryCreate));
			
			CategoryRest categoryRestCreate = new CategoryRest(1, "testMockito");
			Mockito.when(categoryRestMapper.mapToRest(categoryCreate)).thenReturn(categoryRestCreate);
			
			RequestBuilder requestBuilder = MockMvcRequestBuilders
					.post("/netflix2/v1/categories")
					.content("{\"id\": 1, \"name\": \"testMockito\"}")
					.contentType(MediaType.APPLICATION_JSON);
			
			MvcResult result = mockMvc.perform(requestBuilder)
					.andExpect(status().isCreated())
					.andExpect(content()
					.json("{\"status\":\"Success\",\"code\":\"201 CREATED\",\"message\":\"OK\",\"data\":[{\"id\": 1, \"name\": \"testMockito\"}]}"))
					.andReturn();
		}
}

