package com.salesianostriana.Apuntes_Service.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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



}
