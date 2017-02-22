package fr.pizzeria.dao;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class PizzaDao implements IPizzaDao {
	private List<Pizza> listePizzas;
	private static Scanner scan;

	@Override
	public List<Pizza> findAllPizzas() {
		return listePizzas;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) {
		return listePizzas.add(pizza);
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) {
		if (existPizza(codePizza)) {
			listePizzas.set(listePizzas.indexOf(getPizza(codePizza)), pizza);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deletePizza(String codePizza) {
		if (existPizza(codePizza)) {
			listePizzas.remove(getPizza(codePizza));
			return true;
		}
		return false;
	}

	public PizzaDao(List<Pizza> listePizzas) {
		scan = new Scanner(System.in);
		this.listePizzas = listePizzas;
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
