package com.salesianostriana.practicamanejoerrores.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Estacion {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull @NotEmpty
    private String nombre;

    @NotEmpty
    private String marca;

    @NotNull
    private String ubicacion;

    @Builder.Default
    private boolean tieneAutolavado = false;

    @NotNull
    private double precioGasoilNormal, precioGasolina95Octanos;

    private double precioGasoilEspecial, precioGasolina98;

    @Lob
    private String servicios;

    //Fecha del pasado. Ver anotaciones de validacion.
    private LocalDateTime fechaApertura;





}
