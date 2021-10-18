package com.salesianostriana.Apuntes_Service.repositories;

import com.salesianostriana.Apuntes_Service.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
