package com.example.springdata;

import com.example.springdata.model.Alumno;
import com.example.springdata.repositories.AlumnoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class MainPrueba {

    private final AlumnoRepository repo;

    @PostConstruct
    public void test(){

        Alumno alumno = Alumno.builder()
                .nombre("Nombre")
                .apellido("Apellido")
                .email("Email")
                .build();

        repo.save(alumno);

        repo
                .findAll()
                .forEach(System.out::println);


    }


}
