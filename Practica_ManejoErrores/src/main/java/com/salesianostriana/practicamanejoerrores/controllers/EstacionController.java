package com.salesianostriana.practicamanejoerrores.controllers;

import com.salesianostriana.practicamanejoerrores.models.Estacion;
import com.salesianostriana.practicamanejoerrores.models.EstacionDtoConverter;
import com.salesianostriana.practicamanejoerrores.models.GetEstacionDto;
import com.salesianostriana.practicamanejoerrores.services.EstacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estacion")
@RequiredArgsConstructor
public class EstacionController {

    private final EstacionService estacionService;
    private final EstacionDtoConverter dtoConverter;

    @GetMapping("/")
    private List<GetEstacionDto> findAll(){
        //TODO: Problema de compatibilidad con Modelmapper --> Investigar
        List<Object> o = estacionService.findAll();
         return o.stream().map(dtoConverter::convertToDto).collect(Collectors.toList());
      //  return null;
    }

    @GetMapping("/{id}")
    private GetEstacionDto findOne(@PathVariable Long id){

        Optional<Estacion> estacion = estacionService.findById(id);

        return estacion != null ? dtoConverter.convertToDto(estacion.get()) : null;

    }



}
