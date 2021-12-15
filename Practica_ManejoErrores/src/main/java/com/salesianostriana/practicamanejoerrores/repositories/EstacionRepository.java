package com.salesianostriana.practicamanejoerrores.repositories;

import com.salesianostriana.practicamanejoerrores.models.Estacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EstacionRepository extends JpaRepository<Estacion, Long> {

    //Consulta para el UbicationValidator, comprueba is el nombre de esa estacion ya existe
    boolean existsByUbicacion(String ubicacion);

}
