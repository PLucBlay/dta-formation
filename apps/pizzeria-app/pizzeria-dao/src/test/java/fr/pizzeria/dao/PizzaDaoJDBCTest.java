package fr.pizzeria.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.exception.DeleteException;
import fr.pizzeria.exception.SaveException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PizzaDaoConfig.class)
public class PizzaDaoJDBCTest {

	@Autowired
	private IDao<Pizza, String> pizzaDao;

	@Test
	public void test_find_all() {
		// assertEquals(9, pizzaDao.findAll().size());
		// assertThat(pizzaDao.findAll().size(), is(9));

		assertTrue(pizzaDao.findAll().size() > 0);
	}

	@Test
	public void test_global() throws SaveException, DeleteException {
		int initialNumber = pizzaDao.findAll().size();
		assertFalse(pizzaDao.exist("CODEPOI"));
		pizzaDao.saveNew(new Pizza("CODEPOI", "NomPoisson", 25.5, CategoriePizza.POISSON));
		assertTrue((initialNumber + 1) == pizzaDao.findAll().size());
		assertTrue(pizzaDao.exist("CODEPOI"));
		pizzaDao.delete("CODEPOI");
		assertTrue(initialNumber == pizzaDao.findAll().size());
		assertFalse(pizzaDao.exist("CODEPOI"));
	}
}
