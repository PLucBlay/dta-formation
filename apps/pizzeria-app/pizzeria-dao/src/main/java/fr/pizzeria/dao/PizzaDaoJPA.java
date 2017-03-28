package fr.pizzeria.dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

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
	private static final String PIZGET = "pizza.get";
	private static final String CODSEARCH = "codeSearched";

	/**
	 * @param scan
	 */
	public PizzaDaoJPA() {
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}

	@Override
	public void stopDao() {
		emf.close();
	}

	@Override
	public List<Pizza> findAll() {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Pizza> query = em.createNamedQuery("pizza.findAll", Pizza.class);
		List<Pizza> listPizzas = query.getResultList();
		em.close();
		return listPizzas;
	}

	@Override
	public void saveNew(Pizza pizza) throws SaveException {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(pizza);
			et.commit();
			em.close();
		} catch (PersistenceException e) {
			et.rollback();
			em.close();
			throw new SaveException(e);
		}
	}

	@Override
	public void update(String codePizza, Pizza pizza) throws UpdateException {
		if (exist(codePizza)) {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			try {
				Pizza old = (Pizza) em.createNamedQuery(PIZGET).setParameter(CODSEARCH, codePizza).getResultList()
						.get(0);
				et.begin();
				old.setCategorie(pizza.getCategorie());
				old.setCode(pizza.getCode());
				old.setNom(pizza.getNom());
				old.setPrix(pizza.getPrix());
				em.merge(old);
				et.commit();
				em.close();
			} catch (PersistenceException e) {
				et.rollback();
				em.close();
				throw new UpdateException(e);
			}
		} else {
			throw new UpdateException("Code non valide !");
		}
	}

	@Override
	public void delete(String codePizza) throws DeleteException {
		EntityManager em = emf.createEntityManager();
		Pizza piz;
		try {
			piz = (Pizza) em.createNamedQuery(PIZGET).setParameter(CODSEARCH, codePizza).getSingleResult();
		} catch (IndexOutOfBoundsException e) {
			em.close();
			throw new DeleteException(e);
		}
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.remove(piz);
			et.commit();
			em.close();
		} catch (PersistenceException e) {
			et.rollback();
			em.close();
			throw new DeleteException(e);
		}
	}

	@Override
	public boolean exist(String codePizza) {
		EntityManager em = emf.createEntityManager();
		try {
			em.createNamedQuery(PIZGET).setParameter(CODSEARCH, codePizza).getResultList().get(0);
			em.close();
			return true;
		} catch (IndexOutOfBoundsException e) {
			em.close();
			Logger.getAnonymousLogger().log(Level.FINE, "pizza does not exist exception", e);
			return false;
		}
	}

	@Override
	public Pizza get(String codePizza) {
		return null;
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
