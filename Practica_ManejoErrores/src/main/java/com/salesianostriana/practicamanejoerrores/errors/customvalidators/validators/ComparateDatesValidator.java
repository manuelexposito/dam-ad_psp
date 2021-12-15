package com.salesianostriana.practicamanejoerrores.errors.customvalidators.validators;

import com.salesianostriana.practicamanejoerrores.errors.customvalidators.ComparateDates;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

public class ComparateDatesValidator implements ConstraintValidator<ComparateDates, Object> {

    private Temporal firstDate;

    private Temporal secondDate;

    @Override
    public void initialize(ComparateDates constraintAnnotation) {
       // ConstraintValidator.super.initialize(constraintAnnotation);
       // firstDate = constraintAnnotation.firstDate();
        //secondDate = constraintAnnotation.secondDate();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        //return false;
       // Object dateOne = PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(firstDate.toString());
       // Object dateTwo = PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(secondDate.toString());
        ChronoUnit amountOfTime = null;
        long comparation = amountOfTime.between(firstDate, secondDate);
        //TODO: Comprobar si funciona
        //TODO:
        /*
        Valida que la fecha de apertura debe ser menor o igual a la fecha de registro de la estación de servicio.
        No podemos tener dos estaciones de servicio en la misma localización.
         */
        return comparation == comparation * -1 ? true : false ;
    }
}
