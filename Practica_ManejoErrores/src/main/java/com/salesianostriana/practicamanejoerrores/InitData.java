package com.salesianostriana.practicamanejoerrores;

import com.salesianostriana.practicamanejoerrores.models.Estacion;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class InitData {

    @PostConstruct
    public void test(){

        List<Estacion> list = List.of(

                Estacion.builder()
                        .nombre("Gasolinera 1")
                        .marca("Cepsa")
                        .precioGasoilEspecial(1.23)
                        .precioGasoilNormal(1.333)
                        .precioGasolina95Octanos(1.432)
                        .precioGasolina98(1.2212)
                        .servicios("Muchos servicios")
                        .tieneAutolavado(true)
                        .ubicacion("19.316327, 34.628906")
                        .build()

        );


    }

}
