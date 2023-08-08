package com.example.HotelCali.validation.validators;

import com.example.HotelCali.Type;
import com.example.HotelCali.validation.constraints.IsType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
/**
 * @author Louis Hendricx
 * @version 0.0.1
 */
public class IsTypeValidator implements ConstraintValidator<IsType, String> {

    private String notEqualValue; // Variable pour stocker la valeur à ne pas égaler.

    // Méthode d'initialisation appelée une fois lors de la création d'une instance du validateur.
    @Override
    public void initialize(IsType constraintAnnotation) {
        notEqualValue = constraintAnnotation.value();
    }

    // Méthode de validation qui vérifie si la valeur passée en argument est différente de la valeur à ne pas égaler.

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (
                value.equals(Type.SIMPLE.name()) ||
                        value.equals(Type.DOUBLE.name()) ||
                        value.equals(Type.SUITE.name())
        ) {
            return true; // Renvoie true si la valeur est différente de notEqualValue, sinon renvoie false indiquant une validation invalide.
        }
        context.buildConstraintViolationWithTemplate("Should not be " + notEqualValue).addConstraintViolation();
        return false;
    }
}

