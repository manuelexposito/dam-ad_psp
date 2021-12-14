package com.salesianostriana.practicamanejoerrores.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.salesianostriana.practicamanejoerrores.errors.customvalidators.UniqueName;
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
public abstract class EstacionDto {

    @NotNull(message = "{estacion.nombre.notnull}")
    @NotEmpty(message = "{estacion.nombre.notempty}")
    @UniqueName(message = "{estacion.nombre.uniquename}")
    protected String nombre;


    protected String marca;

    @NotNull(message = "{estacion.ubicacion.notnull}")
    protected String ubicacion;

    @Builder.Default
    protected boolean tieneAutolavado = false;

    @NotNull(message = "{estacion.precio.notnull}")
    @Min(value = 0, message = "{estacion.precio.min}")
    protected double precioGasoilNormal, precioGasolina95Octanos;
    @Min(value = 0, message = "{estacion.precio.min}")
    protected double precioGasoilEspecial, precioGasolina98;

    @Lob
    protected String servicios;

    @PastOrPresent(message = "{estacion.fecha}")
    @Builder.Default
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    protected LocalDateTime fechaApertura = LocalDateTime.now();


}
