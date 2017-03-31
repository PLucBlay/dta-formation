package fr.pizzeria.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.pizzeria.entity.repo.IngredientRepository;

@Controller
@RequestMapping("/ingredient")
public class IngredientController {

	@Autowired
	private IngredientRepository iRepo;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getListIngredients() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("listeIngredients");
		mav.addObject("listIngredients", iRepo.findAll());
		return mav;
	}
}
