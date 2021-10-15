package com.salesianostriana.ud2_eo2_ejerciciospracticos.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="PRODUCT")
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name="NAME", nullable = false)
    private String nombre;


    @Column(name="PRICE", nullable = false)
    private double precio;

    @Column(name="IMAGE")
    private String imagen;

    @Column(name="DESCRIPTION")
    private String descripcion;


}
