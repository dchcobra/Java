package com.everis.d4i.tutorial.service.impl;

import com.everis.d4i.tutorial.controller.rest.FilmRest;
import com.everis.d4i.tutorial.persistence.FilmRepository;
import com.everis.d4i.tutorial.persistence.entity.FilmEntity;
import com.everis.d4i.tutorial.persistence.mapper.FilmEntityMapper;
import com.everis.d4i.tutorial.persistence.specification.Specifications;
import com.everis.d4i.tutorial.service.FilmService;
import com.everis.d4i.tutorial.service.dto.FilmDto;

import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import com.everis.d4i.tutorial.controller.rest.FilteringParameters;



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

    // STATIC FILTERING
    
    @Override
    public List<FilmRest> getFilmsFilteredByMinimumDuration(final Integer duration) {
        return filmRepository.findAllByDurationGreaterThan(duration).stream()
                       .map(film -> modelMapper.map(film, FilmRest.class))
                       .collect(Collectors.toList());
    }

    @Override
    public List<FilmRest> getFilmsByCategoryAndSubcategory(final Integer categoryId, final String subcategory) {
        return filmRepository.findAllByCategory_IdAndShortDescriptionContaining(categoryId, subcategory).stream()
                       .map(film -> modelMapper.map(film, FilmRest.class))
                       .collect(Collectors.toList());
    }

    @Override
    public List<FilmRest> getFilmsByYearAndCategoryNameWithNativeQuery(final Integer year, final String categoryName) {
        return filmRepository.myOwnNativeQueryFunctionFilterByYearAndCategory(year, categoryName).stream()
                       .map(film -> modelMapper.map(film, FilmRest.class))
                       .collect(Collectors.toList());
    }
    
    //DINAMIC FILTERING
    
    //filter by year
    /*@Override
    public List<FilmRest> getDynamicallyFiltered(final FilteringParameters filteringParameters) {

        final List<FilmEntity> filmList = filmRepository.findAll(Specifications.isYearEqual(filteringParameters.getYear()));

        return filmList.stream()
                       .map(film -> modelMapper.map(film, FilmRest.class))
                       .collect(Collectors.toList());
    }*/

    //filter by name
    @Override
    public List<FilmRest> getDynamicallyFiltered(final FilteringParameters filteringParameters) {

        final List<FilmEntity> filmList = filmRepository.findAll(Specifications.hasName(filteringParameters.getName()));

        return filmList.stream()
                       .map(film -> modelMapper.map(film, FilmRest.class))
                       .collect(Collectors.toList());
    }
    
    private Specification<FilmEntity> complexFilter(final FilteringParameters filters) {
        return Specification.where(Specifications.hasName(filters.getName())
                                           .and(Specifications.isYearEqual(filters.getYear())));
    }


}
