package com.salesianostriana.E02_Ejercicio_practico;

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
public class Monument {


    @Id
    @GeneratedValue
    private long Id;

    private String isoCode;
    private String countryName;
    private String cityName;
    private String location;
    private String name;
    private String description;
    private String photo;

    public Monument(String isoCode, String countryName, String cityName, String location, String name, String description, String photo) {
        this.isoCode = isoCode;
        this.countryName = countryName;
        this.cityName = cityName;
        this.location = location;
        this.name = name;
        this.description = description;
        this.photo = photo;
    }
}
