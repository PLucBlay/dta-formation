package fr.pizzeria.dao;

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
import fr.pizzeria.model.JpaUpdatable;
import fr.pizzeria.model.Pizza;

/**
 * @author PLucBlay
 *
 */
public class PizzaDaoJPAGeneric<T, E> implements IDao<JpaUpdatable, E> {
	private Scanner scan;
	private EntityManagerFactory emf;
	private static final String PERSISTENCE_UNIT_NAME = "pizzeria-console";

	/**
	 * @param scan
	 */
	public PizzaDaoJPAGeneric(Scanner scan) {
		this.scan = scan;
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}

	@Override
	public void stopDao() {
		emf.close();
	}

	@Override
	public List<JpaUpdatable> findAll() {
		EntityManager em = emf.createEntityManager();
		TypedQuery<JpaUpdatable> query = em.createNamedQuery("pizza.findAll", JpaUpdatable.class);
		List<JpaUpdatable> list = query.getResultList();
		em.close();
		return list;
	}

	@Override
	public void saveNew(JpaUpdatable t) throws SaveException {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(t);
			et.commit();
			em.close();
		} catch (PersistenceException e) {
			et.rollback();
			em.close();
			throw new SaveException(e);
		}
	}

	@Override
	public void update(E e, JpaUpdatable t) throws UpdateException {
		if (exist(e)) {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			try {
				JpaUpdatable old = (JpaUpdatable) em.createNamedQuery("pizza.get").setParameter("codeSearched", e)
						.getResultList().get(0);
				et.begin();
				// old.set(t);
				em.merge(old);
				et.commit();
				em.close();
			} catch (PersistenceException exception) {
				et.rollback();
				em.close();
				throw new UpdateException(exception);
			}
		} else {
			throw new UpdateException("Code non valide !");
		}
	}

	@Override
	public void delete(E e) throws DeleteException {
		EntityManager em = emf.createEntityManager();
		Pizza piz;
		try {
			piz = (Pizza) em.createNamedQuery("pizza.get").setParameter("codeSearched", e).getSingleResult();
		} catch (IndexOutOfBoundsException exception) {
			em.close();
			throw new DeleteException(exception);
		}
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.remove(piz);
			et.commit();
			em.close();
		} catch (PersistenceException exception) {
			et.rollback();
			em.close();
			throw new DeleteException(exception);
		}
	}

	@Override
	public Scanner getScanner() {
		return scan;
	}

	@Override
	public boolean exist(E e) {
		EntityManager em = emf.createEntityManager();
		try {
			em.createNamedQuery("t.get").setParameter("codeSearched", e).getResultList().get(0);
			em.close();
			return true;
		} catch (IndexOutOfBoundsException exception) {
			em.close();
			Logger.getAnonymousLogger().log(Level.FINE, "pizza does not exist exception", exception);
			return false;
		}
	}

	@Override
	public JpaUpdatable get(E e) {
		return null;
	}
}
