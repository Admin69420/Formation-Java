package be.technofuturtic.demo.service;


import be.technofuturtic.demo.models.dto.IngredientDTO;
import be.technofuturtic.demo.models.entities.Ingredient;

import java.util.List;

public interface IngredientService {
    void create(Ingredient form);
    IngredientDTO getOne(Long id);
    void update(Ingredient form, Long id);
    List<IngredientDTO> getAll();
}
