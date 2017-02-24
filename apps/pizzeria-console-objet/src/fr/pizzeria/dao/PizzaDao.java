package fr.pizzeria.dao;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.exception.DeleteException;
import fr.pizzeria.exception.SaveException;
import fr.pizzeria.exception.UpdateException;
import fr.pizzeria.model.Pizza;

public class PizzaDao implements IDao<Pizza, String> {
	private List<Pizza> listePizzas;
	private Scanner scan;

	public PizzaDao(List<Pizza> listePizzas, Scanner scan) {
		this.scan = scan;
		this.listePizzas = listePizzas;
	}

	@Override
	public List<Pizza> findAll() {
		return listePizzas;
	}

	@Override
	public void saveNew(Pizza pizza) throws SaveException {
		try {
			listePizzas.add(pizza);
		} catch (Exception e) {
			throw new SaveException();
		}
	}

	@Override
	public void update(String codePizza, Pizza pizza) throws UpdateException {
		if (exist(codePizza)) {
			listePizzas.set(listePizzas.indexOf(get(codePizza)), pizza);
		} else {
			throw new UpdateException();
		}
	}

	@Override
	public void delete(String codePizza) throws DeleteException {
		if (exist(codePizza)) {
			listePizzas.remove(get(codePizza));
		} else {
			throw new DeleteException();
		}
	}

	public Scanner getScanner() {
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
