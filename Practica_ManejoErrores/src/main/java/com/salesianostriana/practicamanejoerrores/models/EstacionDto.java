package com.salesianostriana.practicamanejoerrores.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Lob;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class EstacionDto {

    private String nombre, marca, ubicacion;
    private boolean tieneAutolavado;
    private double  precioGasoilNormal, precioGasolina95Octanos, precioGasoilEspecial, precioGasolina98;

    @Lob
    private String servicios;


}
