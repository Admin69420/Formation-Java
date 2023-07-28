package be.technofuturtic.demo.models.dto;

import be.technofuturtic.demo.models.entities.Commande;
import be.technofuturtic.demo.models.entities.User;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class UserDTO {
    private Long id;
    private String nom;
    private String prenom;
    private LocalDate dateDeNaissance;
    private Set<Long> commandes;

    public static UserDTO toDTO(User entity){
        if(entity == null)
            throw  new IllegalArgumentException("Ne peut etre null");

        return UserDTO.builder()
                .id(entity.getId())
                .prenom(entity.getPrenom())
                .nom(entity.getNom())
                .dateDeNaissance(entity.getDateDeNaissance())
                .commandes(entity.getCommandes().stream()
                        .map(commande -> commande.getId())
                        .collect(Collectors.toSet())
                )
                .build();
    }
}
