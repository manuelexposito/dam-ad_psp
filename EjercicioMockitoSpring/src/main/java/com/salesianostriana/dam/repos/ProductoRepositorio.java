package com.salesianostriana.dam.repos;

import com.salesianostriana.dam.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductoRepositorio extends JpaRepository<Producto, Long> {


    List<Producto> findByNombreContainsIgnoreCase(String nombre);

    @Query("""
            SELECT p
            FROM Producto p
            WHERE precio between :min and :max
            """)
    List<Producto> findByRangoPrecio(double min, double max);

}
