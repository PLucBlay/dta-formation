package fr.pizzeria.dao.jdbcauxilliary;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaMapper implements RowMapper<Pizza> {

	@Override
	public Pizza mapRow(ResultSet arg0, int arg1) throws SQLException {
		Integer id = arg0.getInt("id");
		String nom = arg0.getString("libelle");
		String code = arg0.getString("reference");
		double prix = arg0.getDouble("prix");
		String categorieString = arg0.getString("categorie_pizza");
		CategoriePizza cat = CategoriePizza.valueOf(categorieString.toUpperCase());
		return new Pizza(id, code, nom, prix, cat);
	}

}
