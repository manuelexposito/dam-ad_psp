package com.salesianostriana.practicamanejoerrores.errors.customvalidators.validators;

import antlr.StringUtils;
import com.salesianostriana.practicamanejoerrores.errors.customvalidators.LatLong;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LatLongValidator implements ConstraintValidator<LatLong, String> {

    @Override
    public void initialize(LatLong constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
      //  return false;
        return s.matches("^[-+]?([1-8]?\\d(\\.\\d+)?|90(\\.0+)?),\\s*[-+]?(180(\\.0+)?|((1[0-7]\\d)|([1-9]?\\d))(\\.\\d+)?)$");

    }
}
