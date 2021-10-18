package com.salesianostriana.Apuntes_Service.model;

import lombok.*;

import javax.persistence.*;

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


}
