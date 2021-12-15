package com.salesianostriana.practicamanejoerrores.errors.customvalidators;

import com.salesianostriana.practicamanejoerrores.errors.customvalidators.validators.ComparateDatesValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.temporal.ChronoUnit;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ComparateDatesValidator.class)
public @interface ComparateDates {

    String message() default "La primera fecha debe ser mayor a la segunda";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    ChronoUnit firstDate();

    ChronoUnit secondDate();

    @Target({ElementType.TYPE, ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List{

        ComparateDates[] value();

    }


}
