package fr.pizzeria.dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

import fr.pizzeria.exception.DeleteException;
import fr.pizzeria.exception.SaveException;
import fr.pizzeria.exception.UpdateException;
import fr.pizzeria.model.Pizza;

/**
 * @author PLucBlay
 *
 */
public class PizzaDaoJPA implements IDao<Pizza, String> {
	private Scanner scan;
	private EntityManagerFactory emf;
	private static final String PERSISTENCE_UNIT_NAME = "pizzeria-console";

	/**
	 * @param scan
	 */
	public PizzaDaoJPA(Scanner scan) {
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		this.scan = scan;
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}

	/**
	 * @return a new EntityManager
	 */
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	@Override
	public List<Pizza> findAll() {
		List<Pizza> listPizzas = new ArrayList<>();
		for (Object obj : getEntityManager().createNamedQuery("pizza.findAll").getResultList()) {
			listPizzas.add((Pizza) obj);
		}
		return listPizzas;
	}

	@Override
	public void saveNew(Pizza pizza) throws SaveException {
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(pizza);
			et.commit();
		} catch (RollbackException e) {
			et.rollback();
			throw new SaveException(e);
		}
	}

	@Override
	public void update(String codePizza, Pizza pizza) throws UpdateException {
	/*	if (exist(codePizza)) {
			try {
				EntityManager em = getEntityManager();
				EntityTransaction et = em.getTransaction();
				Pizza old = (Pizza) getEntityManager().createNamedQuery("pizza.get")
						.setParameter("codeSearched", codePizza).getResultList().get(0);
				et.begin();
				old.setCategorie(pizza.getCategorie());
				em.(pizza);
				et.commit();
			} catch (RollbackException e) {
				et.rollback();
				throw new UpdateException(e);
			}
		} else {
			throw new UpdateException("Code non valide !");
		}*/
	}

	@Override
	public void delete(String codePizza) throws DeleteException {
		throw new DeleteException();
	}

	@Override
	public Scanner getScanner() {
		return scan;
	}

	@Override
	public boolean exist(String codePizza) {
		try {
			getEntityManager().createNamedQuery("pizza.get").setParameter("codeSearched", codePizza).getResultList()
					.get(0);
			return true;
		} catch (IndexOutOfBoundsException e) {
			Logger.getAnonymousLogger().log(Level.FINE, "pizza does not exist exception", e);
			return false;
		}
	}

	@Override
	public Pizza get(String codePizza) {
		return (Pizza) getEntityManager().createNamedQuery("pizza.get").setParameter("codeSearched", codePizza)
				.getResultList().get(0);
	}

	@Override
	public void createFiles() {
		List<Pizza> list = findAll();
		list.stream().forEach(pizza -> {
			try {
				Files.write(Paths.get("data/" + pizza.getCode() + ".txt"), pizza.toString().getBytes());
			} catch (IOException e) {
				Logger.getAnonymousLogger().log(Level.SEVERE, "createFiles exception", e);
			}
		});
	}

	@Override
	public void clearFiles() {
		Arrays.stream(new File("data/").listFiles()).forEach(File::delete);
	}
}
