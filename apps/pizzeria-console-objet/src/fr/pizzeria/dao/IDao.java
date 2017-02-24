package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;

public interface IDao<T> {
	List<T> findAll();

	void saveNew(T t) throws SavePizzaException;

	void update(String code, T t) throws UpdatePizzaException;

	void delete(String code) throws DeletePizzaException;

	boolean exist(String code);
}
