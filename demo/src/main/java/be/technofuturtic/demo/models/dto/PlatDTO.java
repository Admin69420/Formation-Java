package be.technofuturtic.demo.models.dto;

import be.technofuturtic.demo.models.entities.Ingredient;
import be.technofuturtic.demo.models.entities.Plat;
import lombok.Builder;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class PlatDTO {
    private Long id;
    private String nom;
    private Set<IngredientDTO> ingredients;

    public static PlatDTO toDTO (Plat entity){
        if(entity == null)
            throw  new IllegalArgumentException("Ne peut etre null");

        return PlatDTO.builder()
                .id(entity.getId())
                .nom(entity.getNom())
                .ingredients(entity.getIngredients().stream()
                        .map(ingredient -> IngredientDTO.toDTO(ingredient))
                        .collect(Collectors.toSet())
                )
                .build();
    }
}


