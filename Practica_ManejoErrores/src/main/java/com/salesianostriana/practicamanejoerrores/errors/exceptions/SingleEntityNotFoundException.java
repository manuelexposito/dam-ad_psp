package com.salesianostriana.practicamanejoerrores.errors.exceptions;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public class SingleEntityNotFoundException extends EntityNotFoundException{


    public SingleEntityNotFoundException(Class clase, Long id) {
       super(String.format("No se ha podido encontrar el elemento del tipo %s con el ID %s",clase, id));
        //super(messageSource.getMessage({}))
    }
}
