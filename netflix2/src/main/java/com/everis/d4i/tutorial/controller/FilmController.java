package com.everis.d4i.tutorial.controller;

import com.everis.d4i.tutorial.exception.NetflixException;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;

import com.everis.d4i.tutorial.controller.rest.FilmRest;
import com.everis.d4i.tutorial.controller.rest.response.NetflixResponse;

public interface FilmController {

    // SORTING
//	NetflixResponse<List<FilmRest>> getFilms(Sort sort);

	//PAGINATION
	NetflixResponse<Slice<FilmRest>> getFilms(Pageable pageable);
}
