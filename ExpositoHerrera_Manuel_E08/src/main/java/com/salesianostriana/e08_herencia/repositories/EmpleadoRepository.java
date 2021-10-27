package com.salesianostriana.e08_herencia.repositories;

import com.salesianostriana.e08_herencia.models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}
