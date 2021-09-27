package com.salesianostriana.dam._PrimerApiRest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {


    @Id
    @GeneratedValue
    private Long id;

    private String title;
    //@Lob --> nos permitiría convertir el objeto inferior en un objeto grande
    //@Column(size:1000) --> también nos permite aumentar el tamaño de caracteres.
    //@Column(columnDefinition = "TEXT")
    private String text;


    public Task(String title, String text) {
        this.title = title;
        this.text = text;
    }



}
