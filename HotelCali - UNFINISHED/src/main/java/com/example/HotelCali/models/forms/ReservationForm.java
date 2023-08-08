package com.example.HotelCali.models.forms;

import com.example.HotelCali.models.entities.Chambre;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class ReservationForm {
    @FutureOrPresent
    @NotBlank
    private LocalDate dateDebut;
    @Future
    @NotBlank
    private LocalDate dateFin;
    @Size(min=1)
    private Set<Chambre> chambres;
}
