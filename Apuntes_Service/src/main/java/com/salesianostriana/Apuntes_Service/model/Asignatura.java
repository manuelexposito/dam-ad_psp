package com.salesianostriana.Apuntes_Service.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Asignatura {

    @Id
    @GeneratedValue
    private Long id;


    private String nombre, profesor;

    @ManyToOne
    private Curso curso;

    /*
    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "asignatura_id"),
                            inverseJoinColumns = @JoinColumn (name = "alumno_id"),
                            name = "matriculaciones")

    private List<Alumno> alumnos = new ArrayList<>();
    */

    @OneToMany(mappedBy = "asignatura")
    private List<Notas> notas = new ArrayList<>();


    //HELPERS


    public void addToCurso(Curso c){
        this.curso = c;
        c.getAsignaturas().add(this);
    }

    public void removeFromCurso(Curso c){

        c.getAsignaturas().remove(this);
        this.curso = null;

    }



}
