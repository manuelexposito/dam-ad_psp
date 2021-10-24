package com.salesianostriana.e06_ejercicio01.services;

import com.salesianostriana.e06_ejercicio01.models.Producto;
import com.salesianostriana.e06_ejercicio01.repositories.ProductoRepository;
import com.salesianostriana.e06_ejercicio01.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ProductoService extends BaseService<Producto, Long, ProductoRepository> {
}
