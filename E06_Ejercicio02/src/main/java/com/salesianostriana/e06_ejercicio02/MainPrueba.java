package com.salesianostriana.e06_ejercicio02;

import com.salesianostriana.e06_ejercicio02.models.CursoOnline;
import com.salesianostriana.e06_ejercicio02.models.Profesor;
import com.salesianostriana.e06_ejercicio02.models.Video;
import com.salesianostriana.e06_ejercicio02.services.CursoService;
import com.salesianostriana.e06_ejercicio02.services.ProfesorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MainPrueba {

    private final CursoService cursoService;
    private final ProfesorService profesorService;

    @PostConstruct
    public void test(){

    List<Video> v1 = List.of(
        Video.builder()
                .titulo("¿Qué es la experiencia de usuario?")
                .orden(1)
                .descripcion("Aquí hablaremos sobre la importancia de la experienca de usuario en nuestra aplicación")
                .url("https://openwebinars.net/academia/aprende/introduccion-ux/11729/").build(),
        Video.builder()
                .titulo("Modelos mentales, conceptuales y patrones de diseño")
                .orden(2)
                .descripcion("Hablaremos sobre distintos modelos mentales y patrones de diseño")
                .url("https://openwebinars.net/academia/aprende/introduccion-ux/11730/").build()
    );

    List<Video> v2 = List.of(
            Video.builder()
                    .titulo("Clases y métodos abstractos")
                    .orden(1)
                    .descripcion("Aquí estudiamos las clases y métodos de tipo abstracto")
                    .url("https://openwebinars.net/academia/aprende/java-8/2908/").build(),
            Video.builder()
                    .titulo("Código que usa Final")
                    .orden(2)
                    .descripcion("Código que usa el modificador final")
                    .url("https://openwebinars.net/academia/aprende/java-8/2909/").build()

            );


    List<Profesor> profesores = List.of(

            Profesor.builder()
                    .nombre("Karla Dorado")
                    .email("karladorado@openwebinars.com")
                    .puntuacion(4.8)
                    .build(),

            Profesor.builder()
                    .nombre("Luis Miguel Lopez")
                    .email("luismilopez@openwebinars.com")
                    .puntuacion(4.5)
                    .build()

    );

    profesorService.saveAll(profesores);

    List<CursoOnline> cursos = List.of(

            CursoOnline.builder()
                    .nombre("Introducción a UX")
                    .puntuacion(4.8)
                    .build(),

            CursoOnline.builder()
                    .nombre("Java 8 para programadores Java")
                    .puntuacion(4.37)
                    .build()


    );

        v1.forEach( v -> {
            cursos.get(0).addVideo(v);
            cursos.get(0).addProfesor(profesores.get(0));

        } );
        v2.forEach( v -> {
            cursos.get(1).addVideo(v);
            cursos.get(1).addProfesor(profesores.get(1));
        });


        cursoService.saveAll(cursos);

    }
}
