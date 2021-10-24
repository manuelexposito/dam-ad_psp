package com.salesianostriana.e06_ejercicio01.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double pvp;

    @ManyToOne
    private Categoria categoria;

    //HELPERS

    public void addToCategory(Categoria c){
        this.setCategoria(c);
    }

    public void removeFromCategory(){
        this.setCategoria(null);
    }
}
