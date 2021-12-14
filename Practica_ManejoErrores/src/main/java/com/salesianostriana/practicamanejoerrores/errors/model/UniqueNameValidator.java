package com.salesianostriana.practicamanejoerrores.errors.model;

import com.salesianostriana.practicamanejoerrores.errors.customvalidators.UniqueName;
import com.salesianostriana.practicamanejoerrores.repositories.EstacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//La anotación + El tipo de dato a validar
public class UniqueNameValidator implements ConstraintValidator<UniqueName, String> {

    @Autowired
    private EstacionRepository repository;

    @Override
    public void initialize(UniqueName constraintAnnotation) {
    }

    @Override
    public boolean isValid(String nombre, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(nombre) && !repository.existsByNombre(nombre);
    }
}
