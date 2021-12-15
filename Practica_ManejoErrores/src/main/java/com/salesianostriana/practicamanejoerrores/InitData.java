package com.salesianostriana.practicamanejoerrores;

import com.salesianostriana.practicamanejoerrores.models.Estacion;
import com.salesianostriana.practicamanejoerrores.services.EstacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitData {

    private final EstacionService estacionService;

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
                        .fechaApertura(LocalDateTime.of(2008, 04, 20, 11, 25))
                        .fechaRegistro(LocalDateTime.of(2010, 05, 12, 11, 30))
                        .build(),

                Estacion.builder()
                        .nombre("Gasolinera 2")
                        .marca("Shell")
                        .precioGasoilEspecial(1.23)
                        .precioGasoilNormal(1.333)
                        .precioGasolina95Octanos(1.432)
                        .precioGasolina98(1.2212)
                        .servicios("Pocos servicios")
                        .ubicacion("51.597548, 28.947914")
                        .fechaApertura(LocalDateTime.of(2005, 02, 12, 10, 00))
                        .fechaRegistro(LocalDateTime.of(2010, 05, 12, 13, 30))
                        .build()

        );

        estacionService.saveAll(list);




    }

}
