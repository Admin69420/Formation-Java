package com.example.HotelCali.models.dto;

import com.example.HotelCali.models.entities.Adresse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdresseDTO {
    private Long id;
    private String rue;
    private int numero;
    private int codePostal;
    private String ville;
    private String pays;

    public static AdresseDTO toDTO(Adresse adresse) {
        if(adresse == null)
            throw new RuntimeException();

        return AdresseDTO.builder()
                .id(adresse.getId())
                .rue(adresse.getRue())
                .numero(adresse.getNumero())
                .codePostal(adresse.getCodePostal())
                .ville(adresse.getVille())
                .pays(adresse.getPays())
                .build();

    }
}
