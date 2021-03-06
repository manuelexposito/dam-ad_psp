package com.salesianostriana.dam._PrimerApiRest;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController //Equivalente a @Controller + @ResponseBody
@RequestMapping("/task") //Para devolver una ruta base
@RequiredArgsConstructor
public class TaskController {


    private final TaskRepository repository;
    /*
    @GetMapping("/")
    public List<Task> findAll(){

        return repository.findAll();

    }*/

    //Otra forma de hacer el get para mostrarlos todos.
    @GetMapping("/")
    public ResponseEntity<List<Task>> findAll(){

        return ResponseEntity.ok()
                             .body(repository.findAll());

    }



    //Si pusieramos una de nuestras clases el código de respuesta sería 200, si necesitasemos otra,
    //usaremos ResponseEntity<T>
    @PostMapping("/")
    public ResponseEntity<Task> create(@RequestBody Task task){

        //Esto nos permite modificar el código de estado de la respuesta (que antes salía 200 cuando
        // debía aparecer 201)
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(repository.save(task));
    }
    //@RequestBody T t --> Necesita la estructura de la clase genérica que se le pasa.


    /*




    @GetMapping("/{id}")
    public Task findOne(@PathVariable("id") Long id){

        return repository.findById(id)
                         .orElse(null);

    }*/
    @GetMapping("/{id}")
    public ResponseEntity<Task> findOne(@PathVariable("id") Long id){

        return ResponseEntity
                .of(repository.findById(id));


    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){

        repository.deleteById(id);
        return ResponseEntity.noContent()
                             .build();
        //también serviría --> ResponseEntity.status(204).build();
    }

    /*
    @PutMapping("/{id}")
    public Task edit(@RequestBody Task task, @PathVariable Long id){

        Task old = repository.findById(id)
                             .orElse(task);

        old.setText(task.getText());
        old.setTitle(task.getTitle());


        return repository.save(old);

    }*/

    @PutMapping("/{id}")
    public ResponseEntity<Task> edit(@RequestBody Task task, @PathVariable Long id) {


        return ResponseEntity.of(repository.findById(id).map(x -> {
                    x.setTitle(task.getTitle());
                    x.setText(task.getText());

                    repository.save(x);
                    return x;
                })
        );
    }




}
