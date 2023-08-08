package com.example.HotelCali.models.forms;

import com.example.HotelCali.Type;
import com.example.HotelCali.validation.constraints.IsType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NonNull;

@Data
public class ChambreForm {
    @IsType
    @NotBlank
    private Type type;
    @Positive
    private double prix;
    @NotNull
    @NotBlank
    private String nom;

}
