package com.salesianostriana.practicamanejoerrores.errors.customvalidators.validators;

import com.salesianostriana.practicamanejoerrores.errors.customvalidators.Ubication;
import com.salesianostriana.practicamanejoerrores.repositories.EstacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//La anotación + El tipo de dato a validar
public class UbicationValidator implements ConstraintValidator<Ubication, String> {

    @Autowired
    private EstacionRepository repository;

    @Override
    public void initialize(Ubication constraintAnnotation) {
    }

    @Override
    public boolean isValid(String ubicacion, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(ubicacion) && !repository.existsByUbicacion(ubicacion);
    }
}
