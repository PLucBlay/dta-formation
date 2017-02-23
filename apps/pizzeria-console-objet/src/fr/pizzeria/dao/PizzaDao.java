package fr.pizzeria.dao;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDao implements IPizzaDao {
	private List<Pizza> listePizzas;
	private static Scanner scan;

	public PizzaDao(List<Pizza> listePizzas) {
		scan = new Scanner(System.in);
		this.listePizzas = listePizzas;
	}

	@Override
	public List<Pizza> findAllPizzas() {
		return listePizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) throws SavePizzaException {
		try {
			listePizzas.add(pizza);
		} catch (Exception e) {
			throw new SavePizzaException();
		}
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		if (existPizza(codePizza)) {
			listePizzas.set(listePizzas.indexOf(getPizza(codePizza)), pizza);
		} else {
			throw new UpdatePizzaException();
		}
	}

	@Override
	public void deletePizza(String codePizza) throws DeletePizzaException {
		if (existPizza(codePizza)) {
			listePizzas.remove(getPizza(codePizza));
		}
		throw new DeletePizzaException();
	}

	public static Scanner getScanner() {
		return scan;
	}

	public boolean existPizza(String codePizza) {
		for (Pizza piz : listePizzas) {
			if (piz.getCode().equals(codePizza)) {
				return true;
			}
		}
		return false;
	}

	public Pizza getPizza(String codePizza) {
		for (Pizza piz : listePizzas) {
			if (piz.getCode().equals(codePizza)) {
				return piz;
			}
		}
		return null;
	}
}
