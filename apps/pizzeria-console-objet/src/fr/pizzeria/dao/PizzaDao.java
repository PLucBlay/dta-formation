package fr.pizzeria.dao;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDao implements IDao<Pizza> {
	private List<Pizza> listePizzas;
	private static Scanner scan;

	public PizzaDao(List<Pizza> listePizzas) {
		scan = new Scanner(System.in);
		this.listePizzas = listePizzas;
	}

	@Override
	public List<Pizza> findAll() {
		return listePizzas;
	}

	@Override
	public void saveNew(Pizza pizza) throws SavePizzaException {
		try {
			listePizzas.add(pizza);
		} catch (Exception e) {
			throw new SavePizzaException();
		}
	}

	@Override
	public void update(String codePizza, Pizza pizza) throws UpdatePizzaException {
		if (exist(codePizza)) {
			listePizzas.set(listePizzas.indexOf(get(codePizza)), pizza);
		} else {
			throw new UpdatePizzaException();
		}
	}

	@Override
	public void delete(String codePizza) throws DeletePizzaException {
		if (exist(codePizza)) {
			listePizzas.remove(get(codePizza));
		} else {
			throw new DeletePizzaException();
		}
	}

	public static Scanner getScanner() {
		return scan;
	}

	public boolean exist(String codePizza) {
		for (Pizza piz : listePizzas) {
			if (piz.getCode().equals(codePizza)) {
				return true;
			}
		}
		return false;
	}

	public Pizza get(String codePizza) {
		for (Pizza piz : listePizzas) {
			if (piz.getCode().equals(codePizza)) {
				return piz;
			}
		}
		return null;
	}
}
