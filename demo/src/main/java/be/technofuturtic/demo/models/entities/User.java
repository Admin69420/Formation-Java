package be.technofuturtic.demo.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@Entity (name = "personne")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;
    private String nom;
    private String prenom;
    private LocalDate dateDeNaissance;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<Commande> commandes = new LinkedHashSet<>();


    public User(String nom, String prenom, LocalDate dateDeNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
    }
}
