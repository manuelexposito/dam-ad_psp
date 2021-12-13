package com.salesianostriana.practicamanejoerrores.errors.exceptions;

public class ListEntitiesNotFoundException extends EntityNotFoundException{

    public ListEntitiesNotFoundException(Class clase) {

        super(String.format("No se han podido encontrar los elementos del tipo %s",clase));

    }
}
