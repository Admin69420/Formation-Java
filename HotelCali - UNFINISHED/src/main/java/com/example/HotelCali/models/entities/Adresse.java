package com.example.HotelCali.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="addresse_id")
    private Long id;
    private String rue;
    private int numero;
    private int codePostal;
    private String ville;
    private String pays;

}
