package com.example.HotelCali.models.entities;

import com.example.HotelCali.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String prenom;
    private String nom;
    private String login;
    private String password;
    private Role role;
    private LocalDate dateDeNaissance;

    @ManyToMany
    @JoinTable(name = "customer_adresses",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "adresse_id"))
    private Set<Adresse> adresses = new LinkedHashSet<>();

    @OneToMany
    @JoinColumn
    @ToString.Exclude
    private Set<Reservation> reservations;

}
