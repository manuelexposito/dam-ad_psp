package com.salesianostriana.Apuntes_Service.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @Builder
public class Curso {

    @Id
    @GeneratedValue
    private Long id;


    private String nombre, tutor;

    @Builder.Default //Con esta anotación, si no le pasamos un valor a "asignaturas", tomará el que está INICIALIZADO AQUÍ
    @OneToMany(mappedBy = "curso")
    private List<Asignatura> asignaturas = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "curso")
    private List<Alumno> alumnos = new ArrayList<>();

    public Curso(String nombre, String tutor) {
        this.nombre = nombre;
        this.tutor = tutor;
    }







}
