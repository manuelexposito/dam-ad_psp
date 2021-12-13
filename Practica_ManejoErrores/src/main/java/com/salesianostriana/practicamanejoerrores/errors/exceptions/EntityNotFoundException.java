package com.salesianostriana.practicamanejoerrores.errors.exceptions;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;


public class EntityNotFoundException extends RuntimeException {
    /*
    @Autowired
    protected MessageSource messageSource;
    */
    //TODO: DUDA - Como poder poder el MessageSource para utilizar los mensajes desde el properties en las excepciones
    public EntityNotFoundException(String message){
        super(message);
    }

}
