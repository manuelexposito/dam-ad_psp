package com.salesianostriana.e06_ejercicio01.repositories;

import com.salesianostriana.e06_ejercicio01.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
