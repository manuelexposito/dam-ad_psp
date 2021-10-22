package com.salesianostriana.Apuntes_Service.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @Builder
public class Alumno {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre, apellidos, email;


    @ManyToOne
    @JoinColumn(name = "curso", foreignKey = @ForeignKey(name = "FK_ALUMNO_CURSO"))
    private Curso curso;

    /*
    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "alumno_id"),
                            inverseJoinColumns = @JoinColumn (name = "asignatura_id"),
                            name = "matriculaciones")

    private List<Asignatura> asignaturas = new ArrayList<>();
    */

    @OneToMany(mappedBy = "alumno")
    private List<Notas> notas = new ArrayList<>();

    ///HELPERS


    public void addCurso(Curso c){
        this.curso = c;
        c.getAlumnos().add(this);
    }

    public void removeCurso(Curso c){

        c.getAlumnos().remove(this);
        this.curso = null;

    }


}
