package com.salesianostriana.e06_ejercicio02.repositories;

import com.salesianostriana.e06_ejercicio02.models.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}
