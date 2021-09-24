package com.salesianostriana.E02_Ejercicio_practico;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RequestMapping("/monument")
@RestController
@RequiredArgsConstructor
public class MonumentController {

    private final MonumentRepository repository;


    /*
    -Listar monumentos
    -Mostrar un monumento por id
    -Crear un nuevo monumento
    -Modificar un monumento
    -Eliminar un monumento
     */

    //List all monuments

    @GetMapping("/")
    public List<Monument> findAll(){

        return repository.findAll();

    }


    //Show a monument by id

    @GetMapping("/{id}")
    public Monument findOne(@PathVariable("id") Long id){

        return repository.findById(id).orElse(null);
    }


    //Create a new monument

    @PostMapping("/")
    public ResponseEntity<Monument> create(@RequestBody Monument m){

        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(m));

    }

    //Edit a monument

    @PutMapping("/{id}")
    public Monument edit(@RequestBody Monument monument, @PathVariable Long id){

    Monument m = repository.findById(id).orElse(monument);

    m.setCountryName(monument.getCountryName());
    m.setCityName(monument.getName());
    m.setDescription(monument.getDescription());
    m.setLocation(monument.getLocation());
    m.setIsoCode(monument.getIsoCode());
    m.setName(monument.getName());
    m.setPhoto(monument.getPhoto());

    return repository.save(m);


    }



    //Delete a monument

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){

        repository.deleteById(id);
        return ResponseEntity.noContent().build();


    }


}
