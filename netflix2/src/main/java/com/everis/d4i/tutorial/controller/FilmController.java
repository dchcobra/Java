package com.everis.d4i.tutorial.controller;


import java.time.Year;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import com.everis.d4i.tutorial.controller.rest.FilmRest;
import com.everis.d4i.tutorial.controller.rest.response.NetflixResponse;

public interface FilmController {

	//PAGINATION
	NetflixResponse<Slice<FilmRest>> getFilms(Pageable pageable);
	
	//STATIC FILTERING
    NetflixResponse<List<FilmRest>> getFilmsFilteredStatic(Integer duration);

    // DINAMIC FILTERING
	NetflixResponse<List<FilmRest>> getFilmsFilteredDynamic(String name, Year year);


}
