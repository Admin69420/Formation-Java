package be.technofuturtic.demo.repository;

import be.technofuturtic.demo.models.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}