package com.salesianostriana.practicamanejoerrores.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.salesianostriana.practicamanejoerrores.errors.customvalidators.ComparateDates;
import com.salesianostriana.practicamanejoerrores.errors.customvalidators.LatLong;
import com.salesianostriana.practicamanejoerrores.errors.customvalidators.Ubication;
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
@ComparateDates(firstDate = "fechaApertura", secondDate = "fechaRegistro", message = "{estacion.fechas.comparacion}")
public abstract class EstacionDto {

    @NotNull(message = "{estacion.nombre.notnull}")
    @NotEmpty(message = "{estacion.nombre.notempty}")

    protected String nombre;


    protected String marca;

    @NotNull(message = "{estacion.ubicacion.notnull}")
    @LatLong(message = "La ubicación no es correcta")
    @Ubication(message = "{estacion.nombre.ubicacion}")
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    protected LocalDateTime fechaApertura;


    @Builder.Default
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    protected LocalDateTime fechaRegistro = LocalDateTime.now() ;


}
