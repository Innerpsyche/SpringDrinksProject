package com.qa.springdrinksproject.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.springdrinksproject.domain.Drink;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:drink-schema.sql", "classpath:drink-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class DrinkControllerIntegrationTest {
	@Autowired
	private MockMvc mvc;
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void createTest() throws Exception {
		Drink input = new Drink("Tea", 200, false);
		Drink output = new Drink(4L, "Tea", 200, false);
		
		String inputJSON = this.mapper.writeValueAsString(input);
		String outputJSON = this.mapper.writeValueAsString(output);
		
		mvc.perform(post("/drink/create").contentType(MediaType.APPLICATION_JSON)
		.content(inputJSON))
		.andExpect(status().isCreated())
		.andExpect(content().json(outputJSON));
	}
}
