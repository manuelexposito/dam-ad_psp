package com.salesianostriana.practicamanejoerrores.controllers;

import com.salesianostriana.practicamanejoerrores.models.CreateEstacionDto;
import com.salesianostriana.practicamanejoerrores.models.Estacion;
import com.salesianostriana.practicamanejoerrores.models.EstacionDtoConverter;
import com.salesianostriana.practicamanejoerrores.models.GetEstacionDto;
import com.salesianostriana.practicamanejoerrores.services.EstacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

        List<Object> o = estacionService.findAll();
         return o.stream().map(dtoConverter::convertToDto).collect(Collectors.toList());

    }

    @GetMapping("/{id}")
    private GetEstacionDto findOne(@PathVariable Long id){

        Optional<Estacion> estacion = estacionService.findById(id);

        return estacion != null ? dtoConverter.convertToDto(estacion.get()) : null;

    }

    @PostMapping("/")
    private GetEstacionDto createEstacion(@RequestBody CreateEstacionDto dto){

        Object nuevaEstacion = estacionService.save(dto, dtoConverter);

        return dtoConverter.convertToDto(nuevaEstacion);

    }



}
