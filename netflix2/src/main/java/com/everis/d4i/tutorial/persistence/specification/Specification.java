package com.everis.d4i.tutorial.persistence.specification;

import java.util.function.Predicate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.everis.d4i.tutorial.persistence.entity.FilmEntity;

public interface Specification<T> {

	  Predicate toPredicate(Root<T> root, CriteriaQuery query, CriteriaBuilder cb);
	/*
	private Specification<FilmEntity> complexFilter(final FilteringParameters filters) {
	    return Specification.where(ReusableFilmSpecifications.hasName(filters.getName())
	                                    .and(ReusableFilmSpecifications.isYearEqual(Year.of(filters.getYear()))));
	}
	
	private Specification<FilmEntity> staticFilteringOrderExample1() {
	    /*category = 9 && subcategory = drama || subcategory = comedy
	    * returns all biographical dramas OR comedies*/
/*	    return Specification.where(ReusableFilmSpecifications.isCategoryEqual(9))
	                   .and(ReusableFilmSpecifications.hasShortDescription("drama"))
	                   .or(ReusableFilmSpecifications.hasShortDescription("comedy"));
	}

	private Specification<FilmEntity> staticFilteringOrderExample2() {
	    /*category = 9 && (subcategory = drama || subcategory = comedy)
	    * returns all biographical dramas OR biographical comedies*/
/*	    return Specification.where(ReusableFilmSpecifications.isCategoryEqual(9))
	                   .and(ReusableFilmSpecifications.hasShortDescription("drama")
	                                .or(ReusableFilmSpecifications.hasShortDescription("comedy")));
	}
*/
}
