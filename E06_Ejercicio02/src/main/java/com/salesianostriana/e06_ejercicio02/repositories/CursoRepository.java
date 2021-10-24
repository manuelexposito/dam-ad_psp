package com.salesianostriana.e06_ejercicio02.repositories;

import com.salesianostriana.e06_ejercicio02.models.CursoOnline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CursoRepository extends JpaRepository<CursoOnline, Long> {

    @Query("select distinct c from CursoOnline c join fetch c.videos")
    List<CursoOnline> findAllJoin();

}
