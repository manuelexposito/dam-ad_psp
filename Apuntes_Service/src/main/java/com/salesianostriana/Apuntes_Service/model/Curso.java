package com.salesianostriana.Apuntes_Service.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @Builder
public class Curso {

    @Id
    @GeneratedValue
    private Long id;


    private String nombre, tutor;

    public Curso(String nombre, String tutor) {
        this.nombre = nombre;
        this.tutor = tutor;
    }
}
