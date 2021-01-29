package com.everis.d4i.tutorial.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.Year;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.everis.d4i.tutorial.exception.NetflixException;
import com.everis.d4i.tutorial.persistence.FilmRepository;
import com.everis.d4i.tutorial.persistence.entity.FilmEntity;
import com.everis.d4i.tutorial.persistence.mapper.FilmEntityMapper;
import com.everis.d4i.tutorial.service.dto.FilmDto;

@RunWith(MockitoJUnitRunner.class)
public class FilmServiceImplTest {
	@InjectMocks
	FilmServiceImpl services;

	@Mock
	FilmRepository filmRepository;
	
	@Mock
	FilmEntity filmEntity;
	
	@Mock
	FilmEntityMapper filmEntityMapper;
	Year num = Year.of(2017);

	@Test
	public void getCategories_succesTest() throws NetflixException {

		FilmEntity test = new FilmEntity(1L, "test", Year.of(2020), "Spain", "Spanish", 120, "short", "long", null, null);
		FilmEntity test2 = new FilmEntity(2L, "test2", Year.of(2020), "England", "English", 110, "short", "long", null, null);
		FilmEntity test3 = new FilmEntity(3L, "test3", Year.of(2020), "China", "chinese", 160, "short", "long", null, null);
		
		Mockito.when(filmRepository.findAll()).thenReturn(new ArrayList<FilmEntity>(List.of(test, test2, test3)));
		
		final Collection<FilmDto> responseGet = services.getFilms();
		
		assertNotNull(responseGet);
		assertEquals(3, responseGet.size());
	}
}
