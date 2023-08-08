package com.example.HotelCali.models.forms;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

@Data
public class AdresseForm {
    @NotNull
    private String rue;

    @Positive
    private int numero;
    @Size(min = 4)
    @Positive
    private int codePostal;
    @NotNull
    private String ville;
    @NotNull
    private String pays;

}
