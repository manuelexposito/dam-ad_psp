package com.salesianostriana.e06_ejercicio01.services;

import com.salesianostriana.e06_ejercicio01.models.Categoria;
import com.salesianostriana.e06_ejercicio01.repositories.CategoriaRepository;
import com.salesianostriana.e06_ejercicio01.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService extends BaseService<Categoria, Long, CategoriaRepository> {
}
