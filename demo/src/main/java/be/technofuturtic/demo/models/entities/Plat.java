package be.technofuturtic.demo.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
public class Plat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "plat_id")
    private Long id;
    private String nom;

    @ManyToMany
    @JoinTable(name = "Plat_ingredients",
            joinColumns = @JoinColumn(name = "plat_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private Set<Ingredient> ingredients = new LinkedHashSet<>();

}
