package be.technofuturtic.demo.service.impl;

import be.technofuturtic.demo.models.dto.IngredientDTO;
import be.technofuturtic.demo.models.dto.PlatDTO;
import be.technofuturtic.demo.models.entities.Ingredient;
import be.technofuturtic.demo.repository.IngredientRepository;
import be.technofuturtic.demo.service.IngredientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void create(Ingredient form) {

    }

    @Override
    public IngredientDTO getOne(Long id) {
        return ingredientRepository.findById(id)
                .map(ingredient -> IngredientDTO.toDTO(ingredient))
                .orElseThrow(() -> new RuntimeException("Ingredient not found"));
    }

    @Override
    public void update(Ingredient form, Long id) {

    }

    @Override
    public List<IngredientDTO> getAll() {
        return ingredientRepository.findAll().stream()
                .map(ingredient -> IngredientDTO.toDTO(ingredient))
                .collect(Collectors.toList());
    }
}
