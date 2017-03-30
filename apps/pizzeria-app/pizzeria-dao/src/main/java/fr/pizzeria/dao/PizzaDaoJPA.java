package fr.pizzeria.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.exception.DeleteException;
import fr.pizzeria.exception.SaveException;
import fr.pizzeria.exception.UpdateException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.repo.PizzaRepository;

/**
 * @author PLucBlay
 *
 */
@Repository
public class PizzaDaoJPA implements IDao<Pizza, String> {

	@Autowired
	private PizzaRepository pizzaRepository;

	@Override
	public List<Pizza> findAll() {
		return pizzaRepository.findAll();
	}

	@Override
	public void saveNew(Pizza pizza) throws SaveException {
		pizzaRepository.save(pizza);
	}

	@Override
	@Transactional
	public void update(String codePizza, Pizza pizza) throws UpdateException {
		Pizza temp = (Pizza) pizzaRepository.findByCode(codePizza);
		temp.setCode(pizza.getCode());
		temp.setNom(pizza.getNom());
		temp.setPrix(pizza.getPrix());
		temp.setCategorie(pizza.getCategorie());
		pizzaRepository.save(temp);
	}

	@Override
	public void delete(String codePizza) throws DeleteException {
		pizzaRepository.delete(pizzaRepository.findByCode(codePizza));
	}

	@Override
	public boolean exist(String codePizza) {
		return !pizzaRepository.findByCode(codePizza).isEmpty();
	}

	@Override
	public Pizza get(String codePizza) {
		return pizzaRepository.findByCode(codePizza).get(0);
	}
}
