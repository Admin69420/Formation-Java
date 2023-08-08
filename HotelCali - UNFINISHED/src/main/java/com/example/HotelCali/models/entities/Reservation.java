package com.example.HotelCali.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    @ManyToMany
    @JoinTable(name = "reservation_chambres",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "chambres_id"))
    private Set<Chambre> chambres = new LinkedHashSet<>();


}
