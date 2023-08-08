package com.example.HotelCali.models.dto;

import com.example.HotelCali.models.entities.Hotel;
import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class HotelDTO {
    private Long id;
    private String nom;
    private AdresseDTO adresse;
    private Set<ChambreDTO> chambres;
    private CustomerDTO proprio;
    private Set<CustomerDTO> customers;
    private Set<CustomerDTO> travailleurs;

    public static HotelDTO toDTO(Hotel hotel) {
        if(hotel == null)
            throw new RuntimeException();

        return HotelDTO.builder()
                .id(hotel.getId())
                .nom(hotel.getNom())
                .adresse(AdresseDTO.toDTO(hotel.getAdresse()))
                .chambres(hotel.getChambres()
                        .stream().map(ChambreDTO::toDTO)
                        .collect(Collectors.toSet()))
                .proprio(CustomerDTO.toDTO(hotel.getProprio()))
                .customers(hotel.getCustomers().stream()
                        .map(CustomerDTO::toDTO)
                        .collect(Collectors.toSet()))
                .travailleurs(hotel.getTravailleurs().stream()
                        .map(CustomerDTO::toDTO)
                        .collect(Collectors.toSet()))
                .build();

    }
}
