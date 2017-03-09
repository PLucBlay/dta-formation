package fr.pizzeria.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import fr.pizzeria.exception.SaveException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoMemoryTest {

	private PizzaDaoMemory pizzaDao;

	@Before
	public void setUp() {
		Scanner scan = new Scanner(System.in);
		pizzaDao = new PizzaDaoMemory(scan);
	}

	@Test
	public void test_find_all() {
		assertEquals(8, pizzaDao.findAll().size());
		assertThat(pizzaDao.findAll().size(), is(8));
	}

	@Test(expected = SaveException.class)
	public void test_save_invalid_data() throws SaveException {
		assertEquals(8, pizzaDao.findAll().size());
		Pizza pizza = new Pizza("", "", 0.0, CategoriePizza.POISSON);
		pizzaDao.saveNew(pizza);
		assertEquals(8, pizzaDao.findAll().size());
	}
}
