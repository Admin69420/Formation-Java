package com.example.HotelCali.models.dto;

import com.example.HotelCali.Type;
import com.example.HotelCali.models.entities.Adresse;
import com.example.HotelCali.models.entities.Chambre;
import lombok.Builder;
import lombok.Data;
import org.hibernate.engine.spi.BatchFetchQueue;

@Data
@Builder
public class ChambreDTO {
    private Long id;
    private Type type;
    private double prix;
    private String nom;

    public static ChambreDTO toDTO(Chambre chambre) {
        if(chambre == null)
            throw new RuntimeException();

        return ChambreDTO.builder()
                .id(chambre.getId())
                .type(chambre.getType())
                .prix(chambre.getPrix())
                .nom(chambre.getNom())
                .build();

    }
}
