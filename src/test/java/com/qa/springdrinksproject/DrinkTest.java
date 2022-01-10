package com.qa.springdrinksproject;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.qa.springdrinksproject.domain.Drink;

import nl.jqno.equalsverifier.EqualsVerifier;

public class DrinkTest {
	@Test
	public void testEquals() {
		EqualsVerifier.forClass(Drink.class).usingGetClass().verify();
	}
	
	@Test
	public void noIdConstructor() {
		Drink drink = new Drink("Orange Juice", 200, false);
		
		assertNotNull(drink.getName());
		assertNotNull(drink.getAmount());
		assertNotNull(drink.isAlcoholic());
		
		assertEquals(drink.getName(), "Orange Juice");
		assertEquals(drink.getAmount(), 200);
		assertEquals(drink.isAlcoholic(), false);
		}
	
	@Test
	public void settersTest() {
		Drink drink = new Drink();
		 
		drink.setName("Milkshake");
		drink.setAmount(250);
		drink.setAlcoholic(false);
		
		assertNotNull(drink.getName());
		assertNotNull(drink.getAmount());
		assertNotNull(drink.isAlcoholic());
		
		assertEquals(drink.getName(), "Milkshake");
		assertEquals(drink.getAmount(), 250);
		assertEquals(drink.isAlcoholic(), false);
	}
}
