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
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Builder.Default
    @OneToMany(mappedBy = "profesor")
    private List<CursoOnline> cursos = new ArrayList<>();


    private String nombre, email;

    private double puntuacion;




}
