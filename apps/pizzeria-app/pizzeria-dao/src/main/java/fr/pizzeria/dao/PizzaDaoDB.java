package fr.pizzeria.dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.pizzeria.dao.jdbcauxilliary.PizzaMapper;
import fr.pizzeria.exception.DeleteException;
import fr.pizzeria.exception.SaveException;
import fr.pizzeria.exception.UpdateException;
import fr.pizzeria.model.Pizza;

/**
 * @author PLucBlay
 *
 */
@Repository
@Qualifier("pizzaDaoDB")
public class PizzaDaoDB implements IDao<Pizza, String> {
	private static final String SQLALL = "SELECT * FROM pizza";

	private JdbcTemplate jdbcTemplate;

	/**
	 * @param scan
	 * @param bundle
	 *            containing the database access data
	 */
	@Autowired
	public PizzaDaoDB(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public List<Pizza> findAll() {
		return this.jdbcTemplate.query(SQLALL, new PizzaMapper());
	}

	@Override
	public void saveNew(Pizza pizza) throws SaveException {
		String sqlSaveNew = "INSERT INTO pizza (id, libelle, reference, prix, url_image, categorie_pizza) VALUES (null, ?, ?, ?, ?, ?)";
		this.jdbcTemplate.update(sqlSaveNew, pizza.getNom(), pizza.getCode(), pizza.getPrix(),
				(pizza.getNom() + ".png").replaceAll("\\s", ""), pizza.getCategorie().name());
	}

	@Override
	public void update(String codePizza, Pizza pizza) throws UpdateException {
		if (exist(codePizza) && !exist(pizza.getCode())) {
			String sqlUpdate = "UPDATE pizza SET id=?, libelle=?, reference=?, prix=?, url_image=?, categorie_pizza=? WHERE reference=?";
			this.jdbcTemplate.update(sqlUpdate, pizza.getNom(), pizza.getCode(), pizza.getPrix(),
					(pizza.getNom() + ".png").replaceAll("\\s", ""), pizza.getCategorie().name(), codePizza);
		}
		/*
		 * try (Connection co = DriverManager.getConnection(url, user,
		 * password); PreparedStatement prepStatement = co.prepareStatement(
		 * "UPDATE pizza SET id=?, libelle=?, reference=?, prix=?, url_image=?, categorie_pizza=? WHERE reference=?"
		 * );) { prepStatement.setString(1, pizza.getNom());
		 * prepStatement.setString(2, pizza.getCode());
		 * prepStatement.setDouble(3, pizza.getPrix());
		 * prepStatement.setString(4, (pizza.getNom() +
		 * ".png").replaceAll("\\s", "")); prepStatement.setString(5,
		 * pizza.getCategorie().name()); prepStatement.setString(6,
		 * pizza.getCode()); prepStatement.executeUpdate();
		 * prepStatement.close(); } catch (SQLException e) { throw new
		 * UpdateException(e); }
		 */
	}

	@Override
	public void delete(String codePizza) throws DeleteException {
		if (exist(codePizza)) {
			/*
			 * try (Connection co = DriverManager.getConnection(url, user,
			 * password); PreparedStatement prepStatement =
			 * co.prepareStatement("DELETE FROM pizza WHERE reference=?");) {
			 * prepStatement.setString(1, codePizza);
			 * prepStatement.executeUpdate(); prepStatement.close(); } catch
			 * (SQLException e) { throw new DeleteException(e); }
			 */
			String sqlDelete = "DELETE FROM pizza WHERE reference=?";
			this.jdbcTemplate.update(sqlDelete, codePizza);
		}
	}

	@Override
	public boolean exist(String codePizza) {
		String sqlSelectByCode = "SELECT * FROM pizza WHERE reference=? ";
		try {
			this.jdbcTemplate.queryForObject(sqlSelectByCode, new PizzaMapper(), codePizza);
			return true;
		} catch (EmptyResultDataAccessException e) {
			Logger.getAnonymousLogger().log(Level.FINE, "Pizza n'existe pas", e);
			return false;
		}
	}

	@Override
	public Pizza get(String codePizza) {
		String sqlSelectByCode = "SELECT * FROM pizza WHERE reference=? ";
		return this.jdbcTemplate.queryForObject(sqlSelectByCode, new PizzaMapper(), codePizza);
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
