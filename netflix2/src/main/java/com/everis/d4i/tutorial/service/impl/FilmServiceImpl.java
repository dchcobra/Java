package com.everis.d4i.tutorial.service.impl;

import com.everis.d4i.tutorial.controller.rest.FilmRest;
import com.everis.d4i.tutorial.persistence.FilmRepository;
import com.everis.d4i.tutorial.persistence.mapper.FilmEntityMapper;
import com.everis.d4i.tutorial.service.FilmService;
import com.everis.d4i.tutorial.service.dto.FilmDto;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {

	private final FilmRepository filmRepository;

	private final FilmEntityMapper filmEntityMapper;
	
    private ModelMapper modelMapper = new ModelMapper();

/* SORT */

    @Override
    public List<FilmRest> getFilmsByCategorySortedDynamically(final Sort sort) {

        return filmRepository.findAllByCategory_Id(1, sort).stream()
                       .map(film -> modelMapper.map(film, FilmRest.class))
                       .collect(Collectors.toList());
    }

    // PAGINATION
    @Override
    public Page<FilmRest> getPageOfFilms(final Pageable pageable) {
        return filmRepository.findAll(pageable).map(film -> modelMapper.map(film, FilmRest.class));
    }

    @Override
    public Slice<FilmRest> getFilmsByCategorySliced(final Integer categoryId, final Pageable pageable) {
        return filmRepository.findAllByCategory_Id(2, pageable).map(film -> modelMapper.map(film, FilmRest.class));
    }

    @Override
    public List<FilmRest> getFilmsByDurationGreaterThanListed(final Integer duration, final Pageable pageable) {
        return filmRepository.findAllByDurationGreaterThan(duration, pageable).stream()
                       .map(film -> modelMapper.map(film, FilmRest.class))
                       .collect(Collectors.toList());
    }


}
