package fr.pizzeria.entity.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.entity.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
}
