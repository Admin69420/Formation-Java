package com.example.HotelCali.models.dto;

import com.example.HotelCali.Role;
import com.example.HotelCali.models.entities.Chambre;
import com.example.HotelCali.models.entities.Customer;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CustomerDTO {
    private Long id;
    private String prenom;
    private String nom;
    private String login;
    private String password;
    private Role role;
    private LocalDate dateDeNaissance;

    public static CustomerDTO toDTO(Customer customer) {
        if(customer == null)
            throw new RuntimeException();

        return CustomerDTO.builder()
                .id(customer.getId())
                .prenom(customer.getPrenom())
                .nom(customer.getNom())
                .login(customer.getLogin())
                .password(customer.getPassword())
                .role(customer.getRole())
                .dateDeNaissance(customer.getDateDeNaissance())
                .build();

    }
}
