package com.salesianostriana.e06_ejercicio01.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Categoria implements Serializable {

    @Id
    @GeneratedValue//(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Builder.Default
    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name= "main_category_id" ,nullable = true)
    private List<Categoria> subcategorias = new ArrayList<>();


    //HELPERS

    public void addSubCategory(Categoria subc){

        this.getSubcategorias().add(subc);

    }

    public void removeSubCategory(Categoria subc){

        this.getSubcategorias().remove(subc);
    }



}
