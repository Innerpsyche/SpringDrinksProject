package com.qa.springdrinksproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.springdrinksproject.domain.Drink;
import com.qa.springdrinksproject.repo.DrinkRepo;

@Service
public class DrinkService implements ServiceMethods<Drink>{
	
	private DrinkRepo repo;
	
	public DrinkService(DrinkRepo repo) {
		this.repo = repo;
	}
	
	@Override
	public Drink create(Drink drink) {
		return this.repo.save(drink);
	}

	@Override
	public List<Drink> getAll() {
		return this.repo.findAll();
	}

	@Override
	public Drink getById(long id) {
		Optional<Drink> optionalDrink = this.repo.findById(id);
		if(optionalDrink.isPresent()) {
			return optionalDrink.get();
		} else {
			return null;
		}
	}

	@Override
	public Drink update(long id, Drink drink) {
		Optional<Drink> existingDrink = this.repo.findById(id);
		if(existingDrink.isPresent()) {
			Drink existing = existingDrink.get();
			existing.setAmount(drink.getAmount());
			existing.setName(drink.getName());
			existing.setAlcoholic(drink.isAlcoholic());
			
			return this.repo.saveAndFlush(existing);
		} else {
			return null;
		}
	}

	@Override
	public boolean delete(long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
