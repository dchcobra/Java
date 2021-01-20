package com.everis.d4i.tutorial.controller.impl;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.everis.d4i.tutorial.controller.rest.CategoryRest;
import com.everis.d4i.tutorial.controller.rest.response.NetflixResponse;

@RunWith(SpringRunner.class)
@WebMvcTest(CategoryControllerImpl.class)
public class CategoryControllerImplTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void getCategories() throws Exception {
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/netflix2/v1/categories")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content()
				.json("{\"status\":\"Success\",\"code\":\"200 OK\",\"message\":\"OK\",\"data\":[{\"id\":1,\"name\":\"documentary\"},{\"id\":2,\"name\":\"drama\"},{\"id\":3,\"name\":\"thriller\"},{\"id\":4,\"name\":\"short film\"},{\"id\":5,\"name\":\"historical\"},{\"id\":6,\"name\":\"comedy drama\"},{\"id\":7,\"name\":\"animated\"},{\"id\":8,\"name\":\"war\"},{\"id\":9,\"name\":\"biographical\"},{\"id\":10,\"name\":\"superhero\"},{\"id\":11,\"name\":\"musical\"},{\"id\":12,\"name\":\"romantic\"}]}"))
				.andReturn();
	}
}
