package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.exception.DeleteException;
import fr.pizzeria.exception.SaveException;
import fr.pizzeria.exception.UpdateException;

/**
 * @author PLucBlay
 *
 * @param <T>
 *            element in the list
 * @param <C>
 *            identifier to an element
 */
public interface IDao<T, C> {

	/**
	 * close anything that need it when dao stops
	 */
	default void stopDao() {
		throw new UnsupportedOperationException();
	}

	/**
	 * @return a list of all the elements T
	 */
	List<T> findAll();

	/**
	 * add a new element to the model managed by the Dao
	 * 
	 * @param element
	 * @throws SaveException
	 */
	void saveNew(T element) throws SaveException;

	/**
	 * update an element in the model managed by the Dao
	 * 
	 * @param code
	 *            identifying the element
	 * @param element
	 *            replacing the existing element identified by code
	 * @throws UpdateException
	 */
	void update(C code, T element) throws UpdateException;

	/**
	 * delete an element in the model managed by the Dao
	 * 
	 * @param code
	 *            identifying the element
	 * @throws DeleteException
	 */
	void delete(C code) throws DeleteException;

	/**
	 * @param code
	 *            identifying the element
	 * @return true if exist
	 */
	boolean exist(C code);

	/**
	 * return element corresponding to code
	 * 
	 * @param code
	 * @return element(T)
	 */
	T get(C code);

	/**
	 * clear files created by the dao
	 */
	default void clearFiles() {
		throw new UnsupportedOperationException();
	}

	/**
	 * create files corresponding to the model managed by the Dao
	 */
	default void createFiles() {
		throw new UnsupportedOperationException();
	}
}
