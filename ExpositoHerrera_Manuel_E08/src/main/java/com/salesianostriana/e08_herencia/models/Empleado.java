package com.salesianostriana.e08_herencia.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Empleado implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre, email;




}
