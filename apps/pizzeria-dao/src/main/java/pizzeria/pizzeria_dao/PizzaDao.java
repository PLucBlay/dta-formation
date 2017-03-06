package pizzeria.pizzeria_dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.exception.DeleteException;
import fr.pizzeria.exception.SaveException;
import fr.pizzeria.exception.UpdateException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDao implements IDao<Pizza, String> {
	private List<Pizza> listePizzas;
	private Scanner scan;

	public PizzaDao(Scanner scan) {
		this.scan = scan;
		this.listePizzas = new ArrayList<Pizza>();
		listePizzas.add(new Pizza("PEP", "La P�p�roni", 12.5, CategoriePizza.VIANDE));
		listePizzas.add(new Pizza("MAR", "La Margherita", 14.00, CategoriePizza.VIANDE));
		listePizzas.add(new Pizza("REI", "La Reine", 11.50, CategoriePizza.VIANDE));
		listePizzas.add(new Pizza("FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		listePizzas.add(new Pizza("CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
		listePizzas.add(new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
		listePizzas.add(new Pizza("ORI", "L'orientale", 13.50, CategoriePizza.POISSON));
		listePizzas.add(new Pizza("IND", "L'indienne", 14.00, CategoriePizza.SANS_VIANDE));
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

	public void createFiles() {
		List<Pizza> list = findAll();
		list.stream().forEach(pizza -> {
			try {
				Files.write(Paths.get("data/" + pizza.getCode() + ".txt"), pizza.toString().getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

	public void clearFiles() {
		Arrays.stream(new File("data/").listFiles()).forEach(File::delete);
	}
}
