package com.salesianostriana.e08_herencia.models;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
@Table(name = "pedido")
public class Pedido implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String producto, tipo;

    @CreatedDate
    private LocalDateTime fechaCreacion;

    @Enumerated(EnumType.STRING)
    private EstadoPedido estadoPedido;

    private double precio;

    private int cantidad;

    @ManyToOne
    private Cliente cliente;

    //HELPER



}
