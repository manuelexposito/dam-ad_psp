package com.salesianostriana.practicamanejoerrores.errors.customvalidators;

import com.salesianostriana.practicamanejoerrores.errors.customvalidators.validators.UbicationValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UbicationValidator.class)
@Documented //Para que aparezca en la documentación de JAVADOC
public @interface Ubication {

    String message() default "La ubicacion de esta gasolinera ya está cogida.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[]payload() default {};

}
