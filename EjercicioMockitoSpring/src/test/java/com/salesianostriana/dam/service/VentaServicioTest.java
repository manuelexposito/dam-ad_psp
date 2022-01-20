package com.salesianostriana.dam.service;

import com.salesianostriana.dam.model.Cliente;
import com.salesianostriana.dam.model.LineaDeVenta;
import com.salesianostriana.dam.model.Producto;
import com.salesianostriana.dam.model.Venta;
import com.salesianostriana.dam.repos.ProductoRepositorio;
import com.salesianostriana.dam.repos.VentaRepositorio;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

///CON MOCKITO
@ExtendWith(MockitoExtension.class)
class VentaServicioTest {

    @Mock
    ProductoRepositorio productoRepositorio;

    @Mock
    VentaRepositorio ventaRepositorio;

    @InjectMocks
    VentaServicio ventaServicio;


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

    @Test
    void addProductoToVenta() {


    }

    @Test
    void removeLineaVenta() {

        Producto producto = Producto.builder()
                .id(1L)
                .codigoProducto("1")
                .nombre("Patatas")
                .precio(1.30)
                .build();
        Venta v = Venta.builder().id(1L)
                .lineasDeVenta(
                        List.of(
                                LineaDeVenta.builder()
                                        .producto(producto)
                                        .pvp(producto.getPrecio())
                                        .cantidad(2).build()
                        )
                ).build();


        lenient().when(ventaRepositorio.findById(v.getId()).get()).thenReturn(v);
        lenient().when(productoRepositorio.findById(1L).get()).thenReturn(producto);

        ventaServicio.removeLineaVenta(v.getId(), producto.getId());


        assertTrue(!v.getLineasDeVenta().contains(producto));


    }
}