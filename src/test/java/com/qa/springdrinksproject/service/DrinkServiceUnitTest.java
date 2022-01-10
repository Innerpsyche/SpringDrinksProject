package com.qa.springdrinksproject.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.springdrinksproject.domain.Drink;
import com.qa.springdrinksproject.repo.DrinkRepo;

@SpringBootTest
public class DrinkServiceUnitTest {

	@Autowired
	private DrinkService service;

	@MockBean
	private DrinkRepo repo;

	@Test
	public void createTest() {
		Drink input = new Drink("Apple Juice", 500, false);
		Drink output = new Drink(1L, "Apple Juice", 500, false);
		
		Mockito.when(this.repo.save(input)).thenReturn(output);
		
		assertEquals(output, this.service.create(input));
		
		Mockito.verify(this.repo, Mockito.times(1)).save(input);
	}
	@Test
	public void getByIdTest() {
		assertEquals(null, this.service.getById(1));
	}
}
