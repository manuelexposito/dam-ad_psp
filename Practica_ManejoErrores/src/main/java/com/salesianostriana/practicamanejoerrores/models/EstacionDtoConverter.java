package com.salesianostriana.practicamanejoerrores.models;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EstacionDtoConverter {

    private final ModelMapper modelMapper;



    public GetEstacionDto convertToDto(Object o) {

        return modelMapper.map(o, GetEstacionDto.class);
    }


    public Estacion convertToEstacion(CreateEstacionDto dto){

        return modelMapper.map(dto, Estacion.class);

    }

       /* public GetEstacionDto convertToDto(Estacion estacion){

        return modelMapper.map(estacion, GetEstacionDto.class);

    }
*/

    /*
    public Estacion convertToEstacion(CreateEstacionDto dto){

        return Estacion.builder()
                .nombre(dto.getNombre())
                .marca(dto.getMarca())
                .ubicacion(dto.getUbicacion())
                .fechaApertura(dto.getFechaApertura())
                .tieneAutolavado(dto.isTieneAutolavado())
                .servicios(dto.getServicios())
                .precioGasolina98(dto.getPrecioGasolina98())
                .precioGasolina95Octanos(dto.getPrecioGasolina95Octanos())
                .precioGasoilNormal(dto.getPrecioGasoilNormal())
                .precioGasoilEspecial(dto.getPrecioGasoilEspecial())
                .build();

    }*/

}
