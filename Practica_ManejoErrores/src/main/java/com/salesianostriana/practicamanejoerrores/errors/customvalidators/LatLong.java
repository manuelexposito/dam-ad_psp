package com.salesianostriana.practicamanejoerrores.errors.customvalidators;

import com.salesianostriana.practicamanejoerrores.errors.customvalidators.validators.LatLongValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LatLongValidator.class)
public @interface LatLong {

    String message() default "Coordinadas incorrectas";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
