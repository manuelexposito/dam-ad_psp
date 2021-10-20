package com.salesianostriana.Apuntes_Service;

import com.salesianostriana.Apuntes_Service.model.Alumno;
import com.salesianostriana.Apuntes_Service.model.Asignatura;
import com.salesianostriana.Apuntes_Service.model.Curso;
import com.salesianostriana.Apuntes_Service.service.AlumnoService;
import com.salesianostriana.Apuntes_Service.service.AsignaturaService;
import com.salesianostriana.Apuntes_Service.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MainPrueba {

    private final AlumnoService alumnoService;
    private final CursoService cursoService;
    private final AsignaturaService asignaturaService;
    @PostConstruct
    public void test(){

        Curso dam2 = Curso.builder()
                .nombre("2DAM")
                .tutor("Luismi")
                .alumnos(new ArrayList<>())
                .build();



        cursoService.save(dam2);

        Alumno alumno = Alumno.builder()
                .nombre("Luis")
                .apellidos("Lopez")
                .email("luislo@sasasas")
                .curso(dam2).build();

        alumnoService.save(alumno);
        alumno.addCurso(dam2);

        List<Asignatura> asignaturas = List.of(

           Asignatura.builder().nombre("PSP").profesor("Luismi").build(),
           Asignatura.builder().nombre("EIE").profesor("Jesus").build()

        ) ;
        asignaturaService.saveAll(asignaturas);
        alumno.getAsignaturas().addAll(asignaturas);
        alumnoService.edit(alumno);





    }
}
