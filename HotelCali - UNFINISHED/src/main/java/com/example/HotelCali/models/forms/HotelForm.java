package com.example.HotelCali.models.forms;

import com.example.HotelCali.models.entities.Adresse;
import com.example.HotelCali.models.entities.Chambre;
import com.example.HotelCali.models.entities.Customer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;
@Data
public class HotelForm {
    @NotBlank
    private String nom;
    @NotBlank
    private Adresse adresse;
    @Size(min =1)
    private Set<Chambre> chambres;
    @NotNull
    private Customer proprio;
    @Size(min=1)
    private Set<Customer> customers;
    @Size(min=1)
    private Set<Customer> travailleurs;



}
