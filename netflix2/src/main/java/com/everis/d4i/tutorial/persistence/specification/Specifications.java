package com.everis.d4i.tutorial.persistence.specification;

import java.time.Year;

import org.springframework.data.jpa.domain.Specification;

import com.everis.d4i.tutorial.persistence.entity.FilmEntity;

public class Specifications<T> {
	
    public static Specification<FilmEntity> isYearEqual(final Year year) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("year"), year);
    }
	
	public static Specification<FilmEntity> hasName(final String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }

    public static Specification<FilmEntity> hasShortDescription(final String subcategory) {
        return ((root, query, criteriaBuilder)
                        -> criteriaBuilder.like(root.get("shortDescription"), "%" + subcategory + "%"));
    }

    public static Specification<FilmEntity> isCategoryEqual(final Integer categoryId) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("category"), categoryId));
    }

}
