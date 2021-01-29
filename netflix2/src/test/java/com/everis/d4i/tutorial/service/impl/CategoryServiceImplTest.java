package com.everis.d4i.tutorial.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.everis.d4i.tutorial.exception.NetflixException;
import com.everis.d4i.tutorial.persistence.CategoryRepository;
import com.everis.d4i.tutorial.persistence.entity.CategoryEntity;
import com.everis.d4i.tutorial.persistence.mapper.CategoryEntityMapper;
import com.everis.d4i.tutorial.service.dto.CategoryDto;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceImplTest {

	@InjectMocks
	CategoryServiceImpl services;

	@Mock
	CategoryRepository categoryRepository;
	
	@Mock
	CategoryEntity categoryEntity;
	
	@Mock
	CategoryDto categoryDto;
	
	@Mock
	CategoryEntityMapper categoryEntityMapper;
	
	@Test
	public void getCategories_succesTest() throws NetflixException {
				
		CategoryEntity test = new CategoryEntity(1 , "test", null);
		CategoryEntity test2 = new CategoryEntity(2, "test2", null);
		
		Mockito.when(categoryRepository.findAll()).thenReturn(new ArrayList<CategoryEntity>(List.of(test, test2)));
		
		final Collection<CategoryDto> responseGet = services.getCategories();
		
		assertNotNull(responseGet);
		assertEquals(2, responseGet.size());
	}
	
	@Test
	public void createCategories_succesTest() throws NetflixException {
		
		CategoryEntity categoryNewEntity = new CategoryEntity(1, "newTestMock", null);
		CategoryDto categoryNew = new CategoryDto(1, "newTestMock");

		Mockito.when(categoryEntityMapper.mapToEntity(categoryNew)).thenReturn(categoryNewEntity);
		
		Mockito.when(categoryRepository.save(categoryNewEntity)).thenReturn(categoryNewEntity);
		
		Mockito.when(categoryEntityMapper.mapToDto(categoryNewEntity)).thenReturn(categoryNew);
		
		final CategoryDto responseCreate = services.createCategory(categoryNew);
		
		assertNotNull(responseCreate);
		assertEquals(categoryNew, responseCreate);
	}
	
}
