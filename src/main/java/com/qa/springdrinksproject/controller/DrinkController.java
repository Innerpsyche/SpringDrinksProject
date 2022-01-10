package com.qa.springdrinksproject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springdrinksproject.domain.Drink;
import com.qa.springdrinksproject.service.DrinkService;

@RestController
@RequestMapping("/drink")
public class DrinkController {
	private DrinkService service;

	private DrinkController(DrinkService service) {
		this.service = service;
	}

	// create
	@PostMapping("/create")
	public ResponseEntity<Drink> createDrink(@RequestBody Drink drink) {
		return new ResponseEntity<Drink>(this.service.create(drink), HttpStatus.CREATED);
	}

	// read all
	@GetMapping("/readAll")
	public ResponseEntity<List<Drink>> readAllDrinks() {
		return new ResponseEntity<List<Drink>>(this.service.getAll(), HttpStatus.OK);
	}

	// read by id
	@GetMapping("/readById/{id}")
	public ResponseEntity<Drink> readDrinkById(@PathVariable long id) {
		return new ResponseEntity<Drink>(this.service.getById(id), HttpStatus.OK);
	}

	// update
	@PutMapping("/update/{id}")
	public ResponseEntity<Drink> updateDrink(@PathVariable long id, @RequestBody Drink drink) {
		return new ResponseEntity<Drink>(this.service.update(id, drink), HttpStatus.ACCEPTED);

	}

	// delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteDrink(@PathVariable long id) {
		return (this.service.delete(id)) ? new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
	}

}
