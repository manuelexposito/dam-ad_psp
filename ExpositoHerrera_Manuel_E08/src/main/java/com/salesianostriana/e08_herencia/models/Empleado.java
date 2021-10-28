package com.salesianostriana.e08_herencia.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NamedEntityGraph(
        name = Empleado.EMPLEADO_CLIENTE_CORP,
        attributeNodes = {
                @NamedAttributeNode("clientes")
        }

)


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Empleado implements Serializable {

    public static final String EMPLEADO_CLIENTE_CORP = "grafo-empleado-clientecorporativo";

    @Id
    @GeneratedValue
    private Long id;

    private String nombre, email;

    @OneToMany(mappedBy = "empleado")
    private List<ClienteCorporativo> clientes = new ArrayList<>();

}
