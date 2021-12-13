package com.salesianostriana.practicamanejoerrores.errors.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiValidationSubErrors extends ApiSubError{

    private String objeto, campo, mensaje;

    private Object valorRechazado;

}
