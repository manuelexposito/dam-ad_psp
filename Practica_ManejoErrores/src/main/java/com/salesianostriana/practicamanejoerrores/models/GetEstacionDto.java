package com.salesianostriana.practicamanejoerrores.models;

import lombok.*;

import javax.persistence.Lob;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetEstacionDto {

    private String nombre, marca, ubicacion;
    private boolean tieneAutolavado;
    private double  precioGasoilNormal, precioGasolina95Octanos, precioGasoilEspecial, precioGasolina98;

    @Lob
    private String servicios;

    private LocalDateTime fechaApertura;

}
