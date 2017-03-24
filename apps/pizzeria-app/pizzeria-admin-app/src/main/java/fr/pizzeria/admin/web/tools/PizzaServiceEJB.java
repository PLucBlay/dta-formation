package fr.pizzeria.admin.web.tools;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import fr.pizzeria.exception.DeleteException;
import fr.pizzeria.exception.SaveException;
import fr.pizzeria.exception.UpdateException;
import fr.pizzeria.model.Pizza;

@Stateless
public class PizzaServiceEJB {

	@PersistenceContext(unitName = "pizza-db")
	private EntityManager em;
	private static final String PIZGET = "pizza.get";
	private static final String CODSEARCH = "codeSearched";

	public List<Pizza> findAll() {
		TypedQuery<Pizza> query = em.createNamedQuery("pizza.findAll", Pizza.class);
		return query.getResultList();
	}

	public void saveNew(Pizza pizza) throws SaveException {
		em.persist(pizza);
	}

	public void update(String codePizza, Pizza pizza) throws UpdateException {
		if (exist(codePizza)) {
			try {
				Pizza old = (Pizza) em.createNamedQuery(PIZGET).setParameter(CODSEARCH, codePizza).getResultList()
						.get(0);
				old.setCategorie(pizza.getCategorie());
				old.setCode(pizza.getCode());
				old.setNom(pizza.getNom());
				old.setPrix(pizza.getPrix());
				em.merge(old);
			} catch (PersistenceException e) {
				throw new UpdateException(e);
			}
		} else {
			throw new UpdateException("Code non valide !");
		}
	}

	public void delete(String codePizza) throws DeleteException {
		Pizza piz;
		try {
			piz = (Pizza) em.createNamedQuery(PIZGET).setParameter(CODSEARCH, codePizza).getSingleResult();
		} catch (IndexOutOfBoundsException e) {
			throw new DeleteException(e);
		}
		try {
			em.remove(piz);
		} catch (PersistenceException e) {
			throw new DeleteException(e);
		}
	}

	public boolean exist(String codePizza) {
		try {
			em.createNamedQuery(PIZGET).setParameter(CODSEARCH, codePizza).getResultList().get(0);
			return true;
		} catch (IndexOutOfBoundsException e) {
			Logger.getAnonymousLogger().log(Level.FINE, "pizza does not exist exception", e);
			return false;
		}
	}

	public Pizza get(String codePizza) {
		Pizza piz = null;
		try {
			piz = (Pizza) em.createNamedQuery(PIZGET).setParameter(CODSEARCH, codePizza).getResultList().get(0);
			return piz;
		} catch (IndexOutOfBoundsException e) {
			Logger.getAnonymousLogger().log(Level.FINE, "pizza does not exist exception", e);
			return piz;
		}
	}
}
