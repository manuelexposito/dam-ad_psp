package com.salesianostriana.practicamanejoerrores.controllers;

import com.salesianostriana.practicamanejoerrores.models.CreateEstacionDto;
import com.salesianostriana.practicamanejoerrores.models.Estacion;
import com.salesianostriana.practicamanejoerrores.models.EstacionDtoConverter;
import com.salesianostriana.practicamanejoerrores.models.GetEstacionDto;
import com.salesianostriana.practicamanejoerrores.services.EstacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estacion")
@RequiredArgsConstructor
@Validated
public class EstacionController {

    private final EstacionService estacionService;
    private final EstacionDtoConverter dtoConverter;

    @GetMapping("/")
    public List<GetEstacionDto> findAll(){

         List<Estacion> o = estacionService.findAll();
         return o.stream().map(dtoConverter::convertToDto).collect(Collectors.toList());

    }

    @GetMapping("/{id}")
    public GetEstacionDto findOne(@PathVariable @Min(value = 1, message = "{param.min.id}") Long id){

       // Optional<Estacion> estacion = estacionService.findById(id);
        Estacion estacion = estacionService.findById(id);
        return dtoConverter.convertToDto(estacion);

    }

    @PostMapping("/")
    public ResponseEntity<GetEstacionDto> createEstacion(@Valid  @RequestBody CreateEstacionDto dto){

        Estacion nuevaEstacion = estacionService.save(dto, dtoConverter);

        return ResponseEntity.status(HttpStatus.CREATED).body(dtoConverter.convertToDto(nuevaEstacion));

    }


    @PutMapping("/{id}")
    public GetEstacionDto editEstacion(@Valid @RequestBody CreateEstacionDto dto, @PathVariable Long id){

        Estacion e = estacionService.findById(id);
        Estacion editada = estacionService.edit(e, dto);


        return dtoConverter.convertToDto(e);

    }




    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEstacion(@PathVariable Long id){

        estacionService.delete(estacionService.findById(id));

        return ResponseEntity.noContent().build();
    }


}
