package com.everis.d4i.tutorial.persistence.specification;

import java.util.function.Predicate;

import com.everis.d4i.tutorial.persistence.entity.FilmEntity;

public interface Specification<T> {
	
	public interface Specification<T> {
		  Predicate toPredicate(Root<T> root, CriteriaQuery query, CriteriaBuilder cb);
	}

	public static Specification<FilmEntity> isYearEqual(final Year year) {
	    return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("year"), year);
	}

}
