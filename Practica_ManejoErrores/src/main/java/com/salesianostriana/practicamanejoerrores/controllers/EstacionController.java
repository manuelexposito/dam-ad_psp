package com.salesianostriana.practicamanejoerrores.controllers;

import com.salesianostriana.practicamanejoerrores.models.CreateEstacionDto;
import com.salesianostriana.practicamanejoerrores.models.Estacion;
import com.salesianostriana.practicamanejoerrores.models.EstacionDtoConverter;
import com.salesianostriana.practicamanejoerrores.models.GetEstacionDto;
import com.salesianostriana.practicamanejoerrores.services.EstacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public List<GetEstacionDto> findAll(){

         List<Estacion> o = estacionService.findAll();
         return o.stream().map(dtoConverter::convertToDto).collect(Collectors.toList());

    }

    @GetMapping("/{id}")
    public GetEstacionDto findOne(@PathVariable Long id){

       // Optional<Estacion> estacion = estacionService.findById(id);
        Estacion estacion = estacionService.findById(id);
        return dtoConverter.convertToDto(estacion);

    }

    @PostMapping("/")
    public GetEstacionDto createEstacion(@Valid  @RequestBody CreateEstacionDto dto){

        Estacion nuevaEstacion = estacionService.save(dto, dtoConverter);

        return dtoConverter.convertToDto(nuevaEstacion);

    }


    @PutMapping("/{id}")
    public GetEstacionDto editEstacion(@Valid @RequestBody CreateEstacionDto dto, @PathVariable Long id){

        Estacion e = estacionService.findById(id);
        Estacion editada = estacionService.edit(e, dto);


        return dtoConverter.convertToDto(e);

    }




    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEstacion(@PathVariable Long id){

        Estacion estacion = estacionService.findById(id);
        return estacionService.delete(estacion);
    }


}
