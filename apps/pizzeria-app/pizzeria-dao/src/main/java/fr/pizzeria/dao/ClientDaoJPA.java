package fr.pizzeria.dao;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import fr.pizzeria.exception.DeleteException;
import fr.pizzeria.exception.SaveException;
import fr.pizzeria.exception.UpdateException;
import fr.pizzeria.model.Client;

/**
 * @author PLucBlay
 *
 */
public class ClientDaoJPA implements IDao<Client, Integer> {
	private Scanner scan;
	private EntityManagerFactory emf;

	/**
	 * @param scan
	 */
	public ClientDaoJPA(Scanner scan, EntityManagerFactory emf) {
		this.scan = scan;
		this.emf = emf;
	}

	@Override
	public void stopDao() {
		emf.close();
	}

	@Override
	public List<Client> findAll() {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Client> query = em.createNamedQuery("client.findAll", Client.class);
		List<Client> listClients = query.getResultList();
		em.close();
		return listClients;
	}

	@Override
	public void saveNew(Client client) throws SaveException {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(client);
			et.commit();
			em.close();
		} catch (PersistenceException e) {
			et.rollback();
			em.close();
			throw new SaveException(e);
		}
	}

	@Override
	public void update(Integer id, Client client) throws UpdateException {
		if (exist(id)) {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			try {
				Client old = (Client) em.createNamedQuery("client.get").setParameter("codeSearched", id).getResultList()
						.get(0);
				et.begin();
				old.setEmail(client.getEmail());
				old.setMotDePasse(client.getMotDePasse());
				old.setNom(client.getNom());
				old.setPrenom(client.getPrenom());
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
	public void delete(Integer id) throws DeleteException {
		EntityManager em = emf.createEntityManager();
		Client client;
		try {
			client = (Client) em.createNamedQuery("client.get").setParameter("codeSearched", id).getSingleResult();
		} catch (IndexOutOfBoundsException e) {
			em.close();
			throw new DeleteException(e);
		}
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.remove(client);
			et.commit();
			em.close();
		} catch (PersistenceException e) {
			et.rollback();
			em.close();
			throw new DeleteException(e);
		}
	}

	@Override
	public boolean exist(Integer id) {
		EntityManager em = emf.createEntityManager();
		try {
			em.createNamedQuery("client.get").setParameter("codeSearched", id).getResultList().get(0);
			em.close();
			return true;
		} catch (IndexOutOfBoundsException e) {
			em.close();
			Logger.getAnonymousLogger().log(Level.FINE, "client does not exist exception", e);
			return false;
		}
	}

	@Override
	public Client get(Integer id) {
		return null;
	}
}
