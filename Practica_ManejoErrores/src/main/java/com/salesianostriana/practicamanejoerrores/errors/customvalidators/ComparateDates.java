package com.salesianostriana.practicamanejoerrores.errors.customvalidators;

import com.salesianostriana.practicamanejoerrores.errors.customvalidators.validators.ComparateDatesValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.concurrent.TimeUnit;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ComparateDatesValidator.class)
public @interface ComparateDates {

    String message() default "La primera fecha debe ser mayor a la segunda";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String firstDate();

    String secondDate();

    @Target({ElementType.TYPE, ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List{

        ComparateDates[] value();

    }


}
