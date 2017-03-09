package fr.pizzeria.dao;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.exception.DeleteException;
import fr.pizzeria.exception.SaveException;
import fr.pizzeria.exception.UpdateException;

public interface IDao<T, C> {
	List<T> findAll();

	void saveNew(T t) throws SaveException;

	void update(C code, T t) throws UpdateException;

	void delete(C code) throws DeleteException;

	boolean exist(C code);

	Scanner getScanner();

	void clearFiles();

	void createFiles();
}
