package com.salesianostriana.dam._PrimerApiRest;

import lombok.RequiredArgsConstructor;
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

    @GetMapping("/")
    public List<Task> findAll(){

        return repository.findAll();

    }


    @PostMapping("/")
    public ResponseEntity<Task> create(@RequestBody Task task){


        //Esto nos permite modificar el código de estado de la respuesta (que antes salía 200 cuando
        // debía aparecer 201)
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(task));
    }



    @GetMapping("/{id}")
    public Task findOne(@PathVariable("id") Long id){

        return repository.findById(id).orElse(null);


    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
        //también serviría --> ResponseEntity.status(204).build();
    }


    @PutMapping("/{id}")
    public Task edit(@RequestBody Task task, @PathVariable Long id){

        Task old = repository.findById(id).orElse(task);

        old.setText(task.getText());
        old.setTitle(task.getTitle());

        return repository.save(old);

    }


}
