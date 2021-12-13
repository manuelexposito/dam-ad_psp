package com.salesianostriana.practicamanejoerrores.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Lob;
import java.time.LocalDateTime;

@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetEstacionDto extends EstacionDto{

    private LocalDateTime fechaApertura;

}
