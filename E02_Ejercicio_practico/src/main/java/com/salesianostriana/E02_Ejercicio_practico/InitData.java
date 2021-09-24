package com.salesianostriana.E02_Ejercicio_practico;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class InitData {

    private final MonumentRepository repository;

    @PostConstruct
    public void init(){

    //Torre Eiffel, Estatua de la Libertad, Stonehenge
        repository.saveAll(
                Arrays.asList(
                    new Monument("FR", "Francia", "París", "E 2° 17′ 40.18″, N 48° 51′ 29.95″", "Torre Eiffel", "La Torre Eiffel es una construcción de hierro de 300 metros de altura que fue creada para la Exposición Universal de...", "https://cdn.culturagenial.com/es/imagenes/torre-eiffel-cke.jpg"),
                    new Monument("US", "Estados Unidos de América", "New York", "40º 41′ 21» N. Longitud: 74º 02′ 40» W", "Estatua de la Libertad", "La estatua representa a la libertad en forma de mujer, está pisando unas cadenas...", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/14/Statue_of_Liberty_25.jpg/170px-Statue_of_Liberty_25.jpg"),
                    new Monument("GB", "Reino Unido", "Condado de Wiltshire", "51°10′44″N 1°49′34″O", "Stonehenge", "Stonehenge es un monumento megalítico tipo crómlech, además de otros elementos como hoyos, fosos, montículos, etc...", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f2/Stonehenge%2C_Condado_de_Wiltshire%2C_Inglaterra%2C_2014-08-12%2C_DD_09.JPG/1920px-Stonehenge%2C_Condado_de_Wiltshire%2C_Inglaterra%2C_2014-08-12%2C_DD_09.JPG")
                )
        );

    }
}
