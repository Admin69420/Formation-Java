package com.example.HotelCali.validation.constraints;


import com.example.HotelCali.validation.validators.IsTypeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @author Louis Hendricx
 * @version 0.0.1
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME) // Spécifie que l'annotation sera conservée à l'exécution pour être utilisée par la réflexion.
@Constraint(validatedBy = IsTypeValidator.class) // Spécifie la classe de validation à utiliser pour cette annotation.
public @interface IsType {

    String value() default "Yann"; // Définit une propriété 'value' avec une valeur par défaut.

    String message() default "value should not be Yann"; // Définit une propriété 'message' avec un message d'erreur par défaut.

    Class<?>[] groups() default { }; // Définit une propriété 'groups' qui spécifie les groupes de validation dans lesquels cette annotation sera utilisée.

    Class<? extends Payload>[] payload() default { }; // Définit une propriété 'payload' qui permet de passer des charges utiles supplémentaires lors de la validation.
}

