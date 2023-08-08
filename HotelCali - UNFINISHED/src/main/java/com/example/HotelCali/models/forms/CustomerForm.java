package com.example.HotelCali.models.forms;

import com.example.HotelCali.Role;
import com.example.HotelCali.validation.constraints.InPast;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Data
public class CustomerForm {
    @NotBlank
    private String prenom;
    @NotBlank
    private String nom;
    @NotBlank
    private String login;
    @NotBlank
    @Size(min = 8)
    private String password;
    @NotNull
    private Role role;
    @Past(message = "Veuillez selectionner une date valide")
    @InPast(amount = 18,unit = ChronoUnit.YEARS)
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateDeNaissance;

}
