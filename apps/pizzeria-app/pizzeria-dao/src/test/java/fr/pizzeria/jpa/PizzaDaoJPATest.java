package fr.pizzeria.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.exception.DeleteException;
import fr.pizzeria.exception.SaveException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Performance;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.repo.PerformanceRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PizzaDaoJPAConfig.class)
public class PizzaDaoJPATest {

	@Autowired
	private IDao<Pizza, String> pizzaDao;

	@Autowired
	private PerformanceRepository performanceRepository;

	@Test
	public void test_find_all() throws SaveException, DeleteException {
		// assertEquals(9, pizzaDao.findAll().size());
		// assertThat(pizzaDao.findAll().size(), is(9));
		assertEquals(0, pizzaDao.findAll().size());
		pizzaDao.saveNew(new Pizza("", "Poisscaille", 25.5, CategoriePizza.POISSON));
		assertTrue(pizzaDao.findAll().size() > 0);
		pizzaDao.delete("Poi");
		assertEquals(0, pizzaDao.findAll().size());
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
		List<Performance> listPerf = performanceRepository.findAll();
		assertTrue(listPerf.isEmpty() == false);
	}
}
