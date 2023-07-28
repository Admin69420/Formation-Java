package be.technofuturtic.demo.models.dto;

import be.technofuturtic.demo.models.entities.Ingredient;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IngredientDTO {
    private Long id;
    private String nom;

    public static IngredientDTO toDTO (Ingredient entity){
        if(entity == null)
            throw  new IllegalArgumentException("Ne peut etre null");

        return IngredientDTO.builder()
                .id(entity.getId())
                .nom(entity.getNom())
                .build();
    }
}
