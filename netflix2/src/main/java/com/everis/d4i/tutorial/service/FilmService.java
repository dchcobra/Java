package com.everis.d4i.tutorial.service;

import com.everis.d4i.tutorial.controller.rest.FilmRest;
import com.everis.d4i.tutorial.exception.NetflixException;
import com.everis.d4i.tutorial.service.dto.FilmDto;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;

public interface FilmService {

    // SORTING

	List<FilmRest> getFilmsByCategorySortedDynamically(Sort sort);

	// PAGINATION
	Page<FilmRest> getPageOfFilms(Pageable pageable);

	Slice<FilmRest> getFilmsByCategorySliced(Integer categoryId, Pageable pageable);

	List<FilmRest> getFilmsByDurationGreaterThanListed(Integer duration, Pageable pageable);
	
}
