package com.everis.d4i.tutorial.service.impl;

import com.everis.d4i.tutorial.controller.rest.FilmRest;
import com.everis.d4i.tutorial.persistence.FilmRepository;
import com.everis.d4i.tutorial.persistence.mapper.FilmEntityMapper;
import com.everis.d4i.tutorial.service.FilmService;
import com.everis.d4i.tutorial.service.dto.FilmDto;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {
	
	@Autowired
	private FilmRepository filmRepository;

    private final ModelMapper modelMapper = new ModelMapper();

	private final FilmEntityMapper filmEntityMapper;

	@Override
	public Collection<FilmDto> getFilms() {
		return filmRepository.findAll().parallelStream().map(filmEntityMapper::mapToDto).collect(Collectors.toList());
	}

	
	@Override
	public List<FilmRest> getFilmsSortedProgrammatically() {

	    final Sort sortProgrammatically = Sort.by(Sort.Direction.ASC, "year")
	                                              .and(Sort.by(Sort.Direction.DESC, "name"));

	    return filmRepository.findAll(sortProgrammatically).stream()
	                   .map(film -> modelMapper.map(film, FilmRest.class))
	                   .collect(Collectors.toList());
	}


    @Override
    public List<FilmRest> getFilmsByCategorySortedDynamically(final Sort sort) {

        return filmRepository.findAllByCategory_Id(2l, sort).stream()
                       .map(film -> modelMapper.map(film, FilmRest.class))
                       .collect(Collectors.toList());
    }


    @Override
    public List<FilmRest> getFilmsSortedByDefault() {
        return filmRepository.findAllByOrderByYearDesc().stream()
                       .map(film -> modelMapper.map(film, FilmRest.class))
                       .collect(Collectors.toList());
    }

	
}
