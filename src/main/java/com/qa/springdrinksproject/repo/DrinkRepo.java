package com.qa.springdrinksproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.springdrinksproject.domain.Drink;

public interface DrinkRepo extends JpaRepository<Drink, Long>{
		
}
