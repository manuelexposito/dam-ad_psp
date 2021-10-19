package com.salesianostriana.Apuntes_Service.repositories;

import com.salesianostriana.Apuntes_Service.model.Alumno;
import com.salesianostriana.Apuntes_Service.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

    @Query
    List<Alumno> findByCurso(Curso curso);

}
