package com.salesianostriana.Apuntes_Service;

import com.salesianostriana.Apuntes_Service.model.Alumno;
import com.salesianostriana.Apuntes_Service.model.Curso;
import com.salesianostriana.Apuntes_Service.service.AlumnoService;
import com.salesianostriana.Apuntes_Service.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class MainPrueba {

    private final AlumnoService alumnoService;
    private final CursoService cursoService;

    @PostConstruct
    public void test(){

        Curso dam2 = Curso.builder()
                .nombre("2DAM")
                .tutor("Luismi")
                .alumnos(new ArrayList<>())
                .build();



        cursoService.save(dam2);

        Alumno a = Alumno.builder()
                .nombre("Luis")
                .apellidos("Lopez")
                .email("luislo@sasasas")
                .curso(dam2).build();

        alumnoService.save(a);
        a.addCurso(dam2);


    }
}
