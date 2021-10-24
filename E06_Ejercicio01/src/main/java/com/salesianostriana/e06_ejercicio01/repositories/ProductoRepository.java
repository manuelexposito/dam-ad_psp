package com.salesianostriana.e06_ejercicio01.repositories;

import com.salesianostriana.e06_ejercicio01.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
