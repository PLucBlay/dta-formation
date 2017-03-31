package fr.pizzeria.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.pizzeria.entity.Ingredient;
import fr.pizzeria.entity.repo.IngredientRepository;

@RestController
@RequestMapping("/rest/ingredient")
public class IngredientControllerREST {

	@Autowired
	private IngredientRepository iRepo;

	@RequestMapping(method = RequestMethod.GET)
	public List<Ingredient> getListIngredients() {
		return iRepo.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void putNewIngredient(@RequestBody Ingredient ing) {
		iRepo.save(ing);
	}
}
