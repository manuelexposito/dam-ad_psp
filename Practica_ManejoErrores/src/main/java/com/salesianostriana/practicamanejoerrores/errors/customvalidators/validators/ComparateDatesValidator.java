package com.salesianostriana.practicamanejoerrores.errors.customvalidators.validators;

import com.salesianostriana.practicamanejoerrores.errors.customvalidators.ComparateDates;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ComparateDatesValidator implements ConstraintValidator<ComparateDates, Object> {

    private String firstDate;

    private String secondDate;

    @Override
    public void initialize(ComparateDates constraintAnnotation) {
      // ConstraintValidator.super.initialize(constraintAnnotation);
        firstDate = constraintAnnotation.firstDate();
        secondDate = constraintAnnotation.secondDate();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {

        Temporal dateOne = (Temporal) PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(firstDate);
        Temporal dateTwo = (Temporal) PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(secondDate);
        ChronoUnit amountOfTime = ChronoUnit.NANOS;

        long comparation = amountOfTime.between(dateOne, dateTwo);

        return comparation <= 0 ? true : false;
    }
}
