package com.example.HotelCali.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author l.hendricx
 * */
@Data @Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;

    @OneToOne
    private Adresse adresse;

    @OneToMany
    private Set<Chambre> chambres = new LinkedHashSet<>();

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "proprio_id")
    private Customer proprio;

    @ManyToMany
    @JoinTable(name = "Hotel_customers",
            joinColumns = @JoinColumn(name = "hotel_id"),
            inverseJoinColumns = @JoinColumn(name = "customers_id"))
    private Set<Customer> customers = new LinkedHashSet<>();

    @OneToMany(orphanRemoval = true)
    private Set<Customer> travailleurs = new LinkedHashSet<>();

}
