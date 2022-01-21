package com.salesianostriana.dam.repos;

import com.salesianostriana.dam.model.Producto;
import org.apache.catalina.core.ApplicationContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.sql.Array;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class ProductoRepositorioTest {

    @Autowired
    ApplicationContext applicationContext;


    //USAREMOS TEST ENTITY MANAGER PARA PROBAR LAS BASES DE DATOS
    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ProductoRepositorio productoRepositorio;

    Producto p1, p2;

    @BeforeEach
    void init(){
        p1 = Producto.builder()
                .nombre("Producto1")
                .codigoProducto("1234")
                .precio(6.3).build();

        p2 = Producto.builder()
                .nombre("otro")
                .codigoProducto("7572")
                .precio(1.2).build();


        //Se guardan
        testEntityManager.persist(p1);
        testEntityManager.persist(p2);


    }

    @Test
    void testFindAll_success(){

        List<Producto> res = productoRepositorio.findAll();

        assertEquals(2, res.size());
    }

    @Test
    void whenQueryContains_success(){

        List<Producto> result = productoRepositorio.findByNombreContainsIgnoreCase("OTRO");
        assertEquals(1, result.size());
    }


    @Test
    void whenQueryRange_success(){

        assertEquals(0, productoRepositorio.findByRangoPrecio(15.0, 20).size());
        assertEquals(1, productoRepositorio.findByRangoPrecio(5.0, 10).size());
        assertEquals(2, productoRepositorio.findByRangoPrecio(1.0, 7.0).size());
    }

