package com.everis.d4i.tutorial.persistence;

import com.everis.d4i.tutorial.persistence.entity.FilmEntity;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<FilmEntity, Long> {
    
	List<FilmEntity> findAllByOrderByYearDesc();

    List<FilmEntity> findAllByCategory_Id(Long category, Sort sort);

	
}
