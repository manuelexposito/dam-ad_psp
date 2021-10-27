package com.salesianostriana.e08_herencia.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "pedido")
public class Pedido implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String producto, tipo;

    private double precio;

    private int cantidad;

    @ManyToOne
    private Cliente cliente;

}
