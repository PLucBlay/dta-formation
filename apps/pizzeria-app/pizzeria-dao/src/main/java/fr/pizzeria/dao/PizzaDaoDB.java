package fr.pizzeria.dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.pizzeria.exception.DeleteException;
import fr.pizzeria.exception.SaveException;
import fr.pizzeria.exception.UpdateException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoDB implements IDao<Pizza, String> {
	private Scanner scan;
	private String url;
	private String user;
	private String password;

	/**
	 * @param scan
	 */
	public PizzaDaoDB(Scanner scan, ResourceBundle bundle) {
		url = bundle.getString("url");
		user = bundle.getString("user");
		password = bundle.getString("password");
		this.scan = scan;
		try {
			Class.forName(bundle.getString("driver"));
		} catch (ClassNotFoundException e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, "an exception was thrown", e);
		}
	}

	@Override
	public List<Pizza> findAll() {
		List<Pizza> listPizzas = new ArrayList<>();
		try (Connection co = DriverManager.getConnection(url, user, password);
				Statement statement = co.createStatement();
				ResultSet resultats = statement.executeQuery("SELECT * FROM pizza");) {
			while (resultats.next()) {
				Integer id = resultats.getInt("id");
				String nom = resultats.getString("libelle");
				String code = resultats.getString("reference");
				double prix = resultats.getDouble("prix");
				String categorieString = resultats.getString("categorie_pizza");
				CategoriePizza cat = CategoriePizza.valueOf(categorieString.toUpperCase());
				listPizzas.add(new Pizza(id, code, nom, prix, cat));
			}
			resultats.close();
			statement.close();
			return listPizzas;
		} catch (SQLException e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, "an exception was thrown", e);
		}
		return null;
	}

	@Override
	public void saveNew(Pizza pizza) throws SaveException {
		try (Connection co = DriverManager.getConnection(url, user, password);
				PreparedStatement prepStatement = co.prepareStatement(
						"INSERT INTO pizza (id, libelle, reference, prix, url_image, categorie_pizza) VALUES (null, ?, ?, ?, ?, ?)");) {
			prepStatement.setString(1, pizza.getNom());
			prepStatement.setString(2, pizza.getCode());
			prepStatement.setDouble(3, pizza.getPrix());
			prepStatement.setString(4, (pizza.getNom() + ".png").replaceAll("\\s", ""));
			prepStatement.setString(5, pizza.getCategorie().name());
			prepStatement.executeUpdate();
		} catch (SQLException e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, "an exception was thrown", e);
			throw new SaveException(e);
		}
	}

	@Override
	public void update(String codePizza, Pizza pizza) throws UpdateException {
		try (Connection co = DriverManager.getConnection(url, user, password);
				PreparedStatement prepStatement = co.prepareStatement(
						"UPDATE pizza SET id=?, libelle=?, reference=?, prix=?, url_image=?, categorie_pizza=? WHERE reference=?");) {
			prepStatement.setString(1, pizza.getNom());
			prepStatement.setString(2, pizza.getCode());
			prepStatement.setDouble(3, pizza.getPrix());
			prepStatement.setString(4, (pizza.getNom() + ".png").replaceAll("\\s", ""));
			prepStatement.setString(5, pizza.getCategorie().name());
			prepStatement.setString(6, pizza.getCode());
			prepStatement.executeUpdate();
			prepStatement.close();
		} catch (SQLException e) {
			throw new UpdateException(e);
		}
	}

	@Override
	public void delete(String codePizza) throws DeleteException {
		if (exist(codePizza)) {
			try (Connection co = DriverManager.getConnection(url, user, password);
					PreparedStatement prepStatement = co.prepareStatement("DELETE FROM pizza WHERE reference=?");) {
				prepStatement.setString(1, codePizza);
				prepStatement.executeUpdate();
				prepStatement.close();
			} catch (SQLException e) {
				throw new DeleteException(e);
			}
		}
	}

	@Override
	public Scanner getScanner() {
		return scan;
	}

	@Override
	public boolean exist(String codePizza) {
		try (Connection co = DriverManager.getConnection(url, user, password);
				PreparedStatement prepStatement = co.prepareStatement("SELECT id FROM pizza WHERE reference=? ");) {
			prepStatement.setString(1, codePizza);
			ResultSet resultats = prepStatement.executeQuery("SELECT * FROM pizza");
			if (resultats.next()) {
				resultats.close();
				return true;
			} else {
				resultats.close();
				return false;
			}
		} catch (SQLException e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, "an exception was thrown", e);
		}
		return false;
	}

	public Pizza get(String codePizza) {
		try (Connection co = DriverManager.getConnection(url, user, password);
				PreparedStatement prepStatement = co.prepareStatement("SELECT id FROM pizza WHERE reference=? ");) {
			prepStatement.setString(1, codePizza);
			ResultSet resultats = prepStatement.executeQuery("SELECT * FROM pizza");
			if (resultats.next()) {
				Integer id = resultats.getInt("id");
				String nom = resultats.getString("libelle");
				String code = resultats.getString("reference");
				double prix = resultats.getDouble("prix");
				String categorieString = resultats.getString("categorie_pizza");
				CategoriePizza cat = CategoriePizza.valueOf(categorieString.toUpperCase());
				resultats.close();
				return new Pizza(id, code, nom, prix, cat);
			} else {
				resultats.close();
				return null;
			}
		} catch (SQLException e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, "an exception was thrown", e);
			return null;
		}
	}

	@Override
	public void createFiles() {
		List<Pizza> list = findAll();
		list.stream().forEach(pizza -> {
			try {
				Files.write(Paths.get("data/" + pizza.getCode() + ".txt"), pizza.toString().getBytes());
			} catch (IOException e) {
				Logger.getAnonymousLogger().log(Level.SEVERE, "an exception was thrown", e);
			}
		});
	}

	@Override
	public void clearFiles() {
		Arrays.stream(new File("data/").listFiles()).forEach(File::delete);
	}
}
