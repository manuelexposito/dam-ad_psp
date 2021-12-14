package com.salesianostriana.practicamanejoerrores.errors.customvalidators;

import com.salesianostriana.practicamanejoerrores.errors.model.UniqueNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueNameValidator.class)
@Documented //Para que aparezca en la documentación de JAVADOC
public @interface UniqueName {

    String message() default "El nombre de esta gasolinera ya existe. Por favor, ingrese otro.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[]payload() default {};

}
