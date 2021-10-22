package com.salesianostriana.Apuntes_Service.repositories;

import com.salesianostriana.Apuntes_Service.model.Notas;
import com.salesianostriana.Apuntes_Service.model.NotasPK;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NotasRepository extends JpaRepository<Notas, NotasPK> {
}
