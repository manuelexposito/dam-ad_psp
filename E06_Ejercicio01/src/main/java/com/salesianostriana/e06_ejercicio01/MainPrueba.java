package com.salesianostriana.e06_ejercicio01;

import com.salesianostriana.e06_ejercicio01.models.Categoria;
import com.salesianostriana.e06_ejercicio01.models.Producto;
import com.salesianostriana.e06_ejercicio01.services.CategoriaService;
import com.salesianostriana.e06_ejercicio01.services.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MainPrueba {

    private final CategoriaService categoriaService;
    private final ProductoService productoService;

    @PostConstruct
    public void test(){

        //categoriaService.deleteAll();

        List<Categoria> subcatElectronica = List.of(

                Categoria.builder().name("Ordenadores").build(),
                Categoria.builder().name("Smartphones").build()
        );

        List<Categoria> subcatModa = List.of(

                Categoria.builder().name("Ropa infantil").build(),
                Categoria.builder().name("Ropa Adultos").build()
        );

        List<Categoria> subcatComida = List.of(

                Categoria.builder().name("Congelados").build()
        );

        categoriaService.saveAll(subcatElectronica);
        categoriaService.saveAll(subcatModa);
        categoriaService.saveAll(subcatComida);

        List <Categoria> categorias = List.of(

                Categoria.builder()
                        .name("Electrónica").build(),

                Categoria.builder().name("Moda").build(),

                Categoria.builder().name("Comida").build()

        );

        subcatElectronica.forEach( c -> categorias.get(0).addSubCategory(c));
        subcatModa.forEach( c -> categorias.get(1).addSubCategory(c));
        subcatComida.forEach( c -> categorias.get(2).addSubCategory(c));

        categoriaService.saveAll(categorias);


        List <Producto> productos = List.of(

                Producto.builder()
                        .name("Samsung Galaxy")
                        .pvp(350.00)
                        .categoria(categoriaService.findAll().get(1))
                        .build(),

                Producto.builder().name("Pantalones")
                        .pvp(30.00)
                        .categoria(categoriaService.findAll().get(3))
                        .build(),

                Producto.builder()
                        .name("Pizza peperoni")
                        .pvp(3.00)
                        .categoria(categoriaService.findAll().get(4))
                        .build(),

                Producto.builder()
                        .name("Gorra")
                        .pvp(10.00)
                        .categoria(categoriaService.findAll().get(2))
                        .build(),

                Producto.builder()
                        .name("Portátil Asus")
                        .pvp(800.00)
                        .categoria(categoriaService.findAll().get(0))
                        .build(),

                Producto.builder()
                        .name("Arroz")
                        .pvp(2.00)
                        .categoria(categoriaService.findAll().get(7)).
                        build()

        );

        productoService.saveAll(productos);





    }
}
