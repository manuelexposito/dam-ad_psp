package com.salesianostriana.Apuntes_Service.repositories;

import com.salesianostriana.Apuntes_Service.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
