package com.everis.d4i.tutorial.service;

import com.everis.d4i.tutorial.controller.rest.FilteringParameters;

import com.everis.d4i.tutorial.exception.NetflixException;
import com.everis.d4i.tutorial.service.dto.FilmDto;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;


public interface FilmService {

	Collection<FilmDto> getFilms() throws NetflixException;

	// PAGINATION
	Page<FilmDto> getPageOfFilms(Pageable pageable);

	Slice<FilmDto> getFilmsByCategorySliced(Integer categoryId, Pageable pageable);
	
	// STATIC FILTERING
	
	List<FilmDto> getFilmsFilteredByMinimumDuration(Integer duration);

	
	//DINAMIC FILTERING

	List<FilmDto> getDynamicallyFiltered(FilteringParameters filteringParameters);


}
