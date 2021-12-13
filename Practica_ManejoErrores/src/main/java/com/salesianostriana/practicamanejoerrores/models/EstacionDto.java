package com.salesianostriana.practicamanejoerrores.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Lob;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class EstacionDto {

    @NotNull(message = "{estacion.nombre.notnull}")
    @NotEmpty(message = "{estacion.nombre.notempty}")
    private String nombre;


    private String marca;

    @NotNull(message = "{estacion.ubicacion.notnull}")
    private String ubicacion;

    @Builder.Default
    private boolean tieneAutolavado = false;

    @NotNull(message = "{estacion.precio.notnull}")
    @Min(value = 0, message = "{estacion.precio.min}")
    private double precioGasoilNormal, precioGasolina95Octanos;
    @Min(value = 0, message = "{estacion.precio.min}")
    private double precioGasoilEspecial, precioGasolina98;

    @Lob
    private String servicios;

    @PastOrPresent(message = "{estacion.fecha}")
    @Builder.Default
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime fechaApertura = LocalDateTime.now();


}
