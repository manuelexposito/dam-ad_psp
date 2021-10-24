package com.salesianostriana.e06_ejercicio02.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table( name = "Curso")
public class CursoOnline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    private Profesor profesor;

    @Builder.Default
    @OneToMany( mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Video> videos = new ArrayList<>();

    private String nombre;

    private double puntuacion;


    //HELPERS

    public void addVideo(Video v){

        v.setCurso(this);
        this.videos.add(v);

    }

    public void removeVideo(Video v){

        v.setCurso(null);
        this.videos.remove(v);

    }

    public void addProfesor(Profesor p){

        p.getCursos().add(this);
        this.setProfesor(p);

    }

    public void removeProfesor(Profesor p){

        p.getCursos().remove(p);
        this.setProfesor(null);

    }


}
