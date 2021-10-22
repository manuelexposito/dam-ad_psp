package com.salesianostriana.Apuntes_Service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class NotasPK implements Serializable {

    private Long alumnoId;

    private Long asignaturaId;

}
