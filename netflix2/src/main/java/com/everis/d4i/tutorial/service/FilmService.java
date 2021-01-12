package com.everis.d4i.tutorial.service;

import com.everis.d4i.tutorial.exception.NetflixException;
import com.everis.d4i.tutorial.service.dto.FilmDto;
import com.everis.d4i.tutorial.controller.rest.FilmRest;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Sort;


public interface FilmService {

	Collection<FilmDto> getFilms() throws NetflixException;

	List<FilmRest> getFilmsByCategorySortedDynamically(Sort sort);

	List<FilmRest> getFilmsSortedProgrammatically();

	List<FilmRest> getFilmsSortedByDefault();

}
