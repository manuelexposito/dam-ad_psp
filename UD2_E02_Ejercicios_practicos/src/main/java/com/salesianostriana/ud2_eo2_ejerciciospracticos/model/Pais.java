package com.salesianostriana.ud2_eo2_ejerciciospracticos.model;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="COUNTRY")
@AllArgsConstructor
@NoArgsConstructor
public class Pais {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;


    @Column(name="NAME", nullable = false)
    private String nombre;

}
