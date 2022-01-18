package com.salesianostriana.dam.ejerciciotesting.services;

import com.salesianostriana.dam.ejerciciotesting.model.Cliente;
import com.salesianostriana.dam.ejerciciotesting.model.LineaDeVenta;
import com.salesianostriana.dam.ejerciciotesting.model.Producto;
import com.salesianostriana.dam.ejerciciotesting.model.Venta;
import com.salesianostriana.dam.ejerciciotesting.repos.ClienteRepositorio;
import com.salesianostriana.dam.ejerciciotesting.repos.ProductoRepositorio;
import com.salesianostriana.dam.ejerciciotesting.repos.Repositorio;
import com.salesianostriana.dam.ejerciciotesting.repos.VentaRepositorio;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@ExtendWith(MockitoExtension.class)
class VentaServicioTest {


    @BeforeAll
    static void initAll() {

    }

    @Mock
    ProductoRepositorio productoRepositorio;

    @Mock
    VentaRepositorio ventaRepositorio;

    @InjectMocks
    VentaServicio servicio;

    //CAJA NEGRA
    @Test
    void realizarNuevaVenta() {

        Map<String, Integer> productosMap = new HashMap<>();
        productosMap.put("1", 1);

        Cliente c = Cliente.builder()
                .dni("12345A")
                .nombre("Pepe Pérez")
                .email("pepeperez@email.com")
                .build();

        Producto p = Producto.builder().codigoProducto("1").nombre("Cocacola").precio(1.50).build();

        Venta v = Venta.builder()
                .id(1L)
                .cliente(c)
                .fecha(LocalDate.now())
                .lineasDeVenta(List.of(new LineaDeVenta(p, productosMap.get(p.getCodigoProducto()), p.getPrecio()))).build();

        lenient().when(productoRepositorio.findOne(p.getCodigoProducto())).thenReturn(p);
        lenient().when(ventaRepositorio.save(v)).thenReturn(v);
        assertEquals(v, servicio.nuevaVenta(productosMap, c));

    }

    //CAJA NEGRA
    @Test
    void addProductoToVentaNotNull() {

        Venta v = Venta.builder().id(1L).build();

        Producto producto = Producto.builder()
                .codigoProducto("1")
                .nombre("Patatas")
                .precio(1.30)
                .build();

        lenient().when(ventaRepositorio.findOne(v.getId())).thenReturn(v);
        lenient().when(productoRepositorio.findOne("1")).thenReturn(producto);

        v.addLineaVenta(
                LineaDeVenta.builder()
                        .producto(producto)
                        .cantidad(1)
                        .pvp(producto.getPrecio()).build()
        );


        assertNotNull(servicio.addProductoToVenta(v.getId(), producto.getCodigoProducto(), 1));
/*
Expected :Venta(id=1, fecha=2022-01-18, lineasDeVenta=[LineaDeVenta(producto=Producto(codigoProducto=1, nombre=Patatas, precio=1.3), cantidad=1, pvp=1.3)], cliente=null)
Actual   :null
 */
    }

    //CAJA NEGRA
    @Test
    void removeLineaVenta() {

        Producto producto = Producto.builder()
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


        lenient().when(ventaRepositorio.findOne(v.getId())).thenReturn(v);
        lenient().when(productoRepositorio.findOne("1")).thenReturn(producto);

        servicio.removeLineaVenta(v.getId(), producto.getCodigoProducto());

        //Devuelve TRUE si la linea de venta se ha borrado
        assertTrue(!v.getLineasDeVenta().contains(producto));

    }
}