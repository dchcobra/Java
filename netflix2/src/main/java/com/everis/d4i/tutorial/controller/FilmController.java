package com.everis.d4i.tutorial.controller;


import java.time.Year;
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
//	NetflixResponse<Slice<FilmRest>> getFilms(Pageable pageable);
	
	//STATIC FILTERING
//    NetflixResponse<List<FilmRest>> getFilmsFilteredStaticallyBy(Integer duration);

    // DINAMIC FILTERING
	NetflixResponse<List<FilmRest>> getFilmsFilteredDynamicallyBy(String name, Year year, String country,
			List<String> languages, Integer category, List<String> subcategories, Integer minimumDuration);

}
