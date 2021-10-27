package com.salesianostriana.e08_herencia.services;

import com.salesianostriana.e08_herencia.models.Empleado;
import com.salesianostriana.e08_herencia.repositories.EmpleadoRepository;
import com.salesianostriana.e08_herencia.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService extends BaseService<Empleado, Long, EmpleadoRepository> {
}
