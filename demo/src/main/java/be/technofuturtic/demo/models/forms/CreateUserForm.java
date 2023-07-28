package be.technofuturtic.demo.models.forms;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateUserForm {
    private String nom;
    private String prenom;
    private LocalDate dateDeNaissance;
}
