package com.salesianostriana.e08_herencia.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@NamedEntityGraph(
        name = Cliente.CLIENTE_PEDIDO,
        attributeNodes = {
                @NamedAttributeNode("pedidos")
        }
)

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
public class Cliente implements Serializable {


    public static final String CLIENTE_PEDIDO = "grafo-cliente-pedido";


    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String email;
    private String direccion;

    @Builder.Default
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos = new ArrayList<>();

    //Helpers

    public void addPedido(Pedido p){

        this.getPedidos().add(p);
        p.setCliente(this);
    }

}
