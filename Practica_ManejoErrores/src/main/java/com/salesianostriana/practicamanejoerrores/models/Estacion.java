package com.salesianostriana.practicamanejoerrores.models;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    private String nombre, marca, ubicacion;
    private boolean tieneAutolavado;
    private double  precioGasoilNormal, precioGasolina95Octanos, precioGasoilEspecial, precioGasolina98;

    @Lob
    private String servicios;

    private LocalDateTime fechaApertura;





}
