/**
 * 
 */
package fr.pizzeria.model;

import java.io.InvalidClassException;

/**
 * @author PLucBlay
 *
 */
public interface JpaUpdatable {
	/**
	 * @param jpaUpdatable
	 * @throws InvalidClassException
	 */
	public void setObject(JpaUpdatable jpaUpdatable) throws InvalidClassException;
}
