package com.everis.d4i.tutorial.controller;

import com.everis.d4i.tutorial.controller.rest.FilmRest;
import com.everis.d4i.tutorial.controller.rest.response.NetflixResponse;
import com.everis.d4i.tutorial.exception.NetflixException;

import java.util.List;

import org.springframework.data.domain.Sort;

public interface FilmController {

    NetflixResponse<List<FilmRest>> getFilms(Sort sort);

	NetflixResponse<FilmRest[]> getFilms() throws NetflixException;
    
}
