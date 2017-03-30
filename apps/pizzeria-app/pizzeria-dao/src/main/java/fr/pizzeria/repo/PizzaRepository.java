package fr.pizzeria.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.model.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
	List<Pizza> findByCode(String code);
}
