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
	String url = "jdbc:mysql://localhost:3306/pizzeria";
	String login = "user1";
	String pass = "";
	Connection co = null;

	/**
	 * @param scan
	 */
	public PizzaDaoDB(Scanner scan) {
		this.scan = scan;
		initialize();
	}

	private void initialize() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			co = DriverManager.getConnection(url, login, pass);
		} catch (SQLException | ClassNotFoundException e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, "an exception was thrown", e);
		}
	}

	public void closeDBConnection() {
		try {
			co.close();
		} catch (SQLException e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, "an exception was thrown", e);
		}
	}

	@Override
	public List<Pizza> findAll() {
		List<Pizza> listPizzas = new ArrayList<>();
		try {
			ResultSet resultats;
			Statement statement = co.createStatement();
			resultats = statement.executeQuery("SELECT * FROM pizza");
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
		try {
			PreparedStatement prepStatement = co.prepareStatement(
					"INSERT INTO pizza (id, libelle, reference, prix, url_image, categorie_pizza) VALUES (null, ?, ?, ?, ?, ?)");
			prepStatement.setString(1, pizza.getNom());
			prepStatement.setString(2, pizza.getCode());
			prepStatement.setDouble(3, pizza.getPrix());
			prepStatement.setString(4, (pizza.getNom() + ".png").replaceAll("\\s", ""));
			prepStatement.setString(5, pizza.getCategorie().name());
			prepStatement.executeUpdate();
			prepStatement.close();
		} catch (SQLException e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, "an exception was thrown", e);
			throw new SaveException();
		}
	}

	@Override
	public void update(String codePizza, Pizza pizza) throws UpdateException {
		/*
		 * if (exist(codePizza)) {
		 * listePizzas.set(listePizzas.indexOf(get(codePizza)), pizza); } else {
		 * throw new UpdateException(); }
		 */
	}

	@Override
	public void delete(String codePizza) throws DeleteException {
		if (exist(codePizza)) {
			/*
			 * TODO
			 */
		} else {
			throw new DeleteException();
		}
	}

	public Scanner getScanner() {
		return scan;
	}

	@Override
	public boolean exist(String codePizza) {
		/*
		 * for (Pizza piz : listePizzas) { if (piz.getCode().equals(codePizza))
		 * { return true; } }
		 */
		return false;
		/*
		 * TODO
		 */
	}

	public Pizza get(String codePizza) {
		/*
		 * for (Pizza piz : listePizzas) { if (piz.getCode().equals(codePizza))
		 * { return piz; } }
		 */
		return null;
		/*
		 * TODO
		 */
	}

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

	public void clearFiles() {
		Arrays.stream(new File("data/").listFiles()).forEach(File::delete);
	}
}
