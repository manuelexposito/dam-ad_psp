package com.salesianostriana.e06_ejercicio02.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @ManyToOne
    @JoinColumn(name = "curso_id")
    private CursoOnline curso;

    private int orden;

    @Lob
    private String titulo, descripcion, url;

}
