package com.salesianostriana.practicamanejoerrores.models;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EstacionDtoConverter {

    private final ModelMapper modelMapper;

   /* public GetEstacionDto convertToDto(Estacion estacion){

        return modelMapper.map(estacion, GetEstacionDto.class);

    }
*/

    public GetEstacionDto convertToDto(Object o) {
        return modelMapper.map(o, GetEstacionDto.class);
    }
}
