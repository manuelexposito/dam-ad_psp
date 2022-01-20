package com.salesianostriana.dam.service;

import com.salesianostriana.dam.model.Cliente;
import com.salesianostriana.dam.model.LineaDeVenta;
import com.salesianostriana.dam.model.Producto;
import com.salesianostriana.dam.model.Venta;
import com.salesianostriana.dam.repos.ProductoRepositorio;
import com.salesianostriana.dam.repos.VentaRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
///CON SPRING
@ExtendWith(SpringExtension.class)
public class VentaServicioTest2 {

    @MockBean
    ProductoRepositorio productoRepositorio;

    @MockBean
    VentaRepositorio ventaRepositorio;


    VentaServicio ventaServicio;

    @BeforeEach
    public void setUp() {
        ventaServicio = new VentaServicio(productoRepositorio, ventaRepositorio);
    }


    @Test
    void nuevaVentaSuccess() {

        Cliente c = Cliente.builder()
                .id(1L)
                .dni("12345A")
                .nombre("Pepe Pérez")
                .email("pepeperez@email.com")
                .build();

        Producto p = Producto.builder()
                .id(1L)
                .nombre("Cocacola")
                .precio(1.50).build();


        Map<Long, Integer> productosMap = Map.of(1L, 1);

        Venta v = Venta.builder()
                .id(1L)
                .cliente(c)
                .fecha(LocalDate.now()).build();

        v.addLineaVenta(LineaDeVenta.builder()
                .cantidad(1)
                .venta(v)
                .producto(p)
                .pvp(p.getPrecio()).build());

        lenient().when(productoRepositorio.findById(any(Long.class))).thenReturn(Optional.of(p));
        lenient().when(ventaRepositorio.save(any(Venta.class))).thenReturn(v);


        assertEquals(v, ventaServicio.nuevaVenta(productosMap, c));


        //Por no tener método EQUALS en Venta, el test FALLA por AssertionFailedError
    }


}
