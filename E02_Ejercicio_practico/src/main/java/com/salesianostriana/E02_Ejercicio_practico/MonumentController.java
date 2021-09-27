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


    //List all monuments

    /*
    El método devolverá una lista de Monumentos con el código de estado 200. En el método "body" no ponemos lo que
    queremos que devuelva para mostrar, y será la lista de monumentos.
     */
    @GetMapping("/")
    public ResponseEntity<List<Monument>> findAll(){

        return ResponseEntity.ok()
                              .body(repository.findAll());
    }


    //Show a monument by id

    /*
     El método "of" devuelve un optional<T>, y es una forma acortada de pedirle que devuelva un código de estado 200
     y el mensaje del cuerpo. En este caso, el monumento del id especificado.

     Nota: En @PathVariable, si quisieramos ponerle un nombre distinto al del identificador que usamos, debemos agregar
     en la anotacion @PathVariable("id")
     */
   @GetMapping("/{id}")
    public ResponseEntity<Monument> findOne(@PathVariable Long id){

        return ResponseEntity.of(repository.findById(id));

   }
    //Create a new monument
    //El método status(HttpStatus.CREATED) devuelve el código de estado 201 (creado).
    @PostMapping("/")
    public ResponseEntity<Monument> create(@RequestBody Monument m){

        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(repository.save(m));

    }

    //Edit a monument

    /*
    El método findById(id) devuelve un Optional, lo que nos permite trabajar con lambdas. El método .map nos permite mapear
    un objeto para cambiarle el tipo; de esta forma, podemos usar el Optional para convertirlo en "Monument" y así poder setear los cambios
    del monumento que le pasamos gracias a la anotación @RequestBody.

    Nota: @RequestBody nos obliga a que los nombres de los atributos que pasamos por JSON sean iguales a los escritos en la clase java.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Monument> edit(@RequestBody Monument monument, @PathVariable Long id) {

        return ResponseEntity.of(repository.findById(id)
                .map(x -> {

                    x.setIsoCode(monument.getIsoCode());
                    x.setCountryName(monument.getCountryName());
                    x.setCityName(monument.getCityName());
                    x.setLocation(monument.getLocation());
                    x.setName(monument.getName());
                    x.setDescription(monument.getDescription());
                    x.setPhoto(monument.getPhoto());

                    repository.save(x);
                    return x;
                })
        );


    }


    //Delete a monument

    /*
    El método noContent() crea un "builder" con un código de estado NO CONTENT o 204. Al no ser un método final, debe
    cerrarse con .build()

    Otra forma de escribir el mismo método sería:
                ResponseEntity.status(204)
                              .build();
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        repository.deleteById(id);
        return ResponseEntity.noContent()
                             .build();


    }


}
