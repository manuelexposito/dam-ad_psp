package com.salesianostriana.e08_herencia;

import com.salesianostriana.e08_herencia.models.*;
import com.salesianostriana.e08_herencia.repositories.ClienteRepository;
import com.salesianostriana.e08_herencia.repositories.EmpleadoRepository;
import com.salesianostriana.e08_herencia.services.ClienteService;
import com.salesianostriana.e08_herencia.services.EmpleadoService;
import com.salesianostriana.e08_herencia.services.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MainPrueba {

    private final ClienteService clienteService;
    private final ClienteRepository clienteRepository;
    private final EmpleadoService empleadoService;
    private final PedidoService pedidoService;

    @PostConstruct
    public void test(){

        Empleado e1 = Empleado.builder()
                .nombre("Juan Pérez")
                .email("juanperez@gmail.com").build();

        empleadoService.save(e1);

        Cliente c1 = ClienteCorporativo.builder()
                .nombre("Charcutería Perez")
                .direccion("Calle Falsa nº 23")
                .empleado(e1)
                .email("cperez@charcuteria.com")
                .build();
        Cliente c2 = ClienteParticular.builder()
                .nombre("Gonzalo Garcia")
                .direccion("Calle Tefalta ")
                .build();

        List<Cliente> clientes = List.of( c1, c2);
        clienteService.saveAll(clientes);


        List<String> nombresCorporativos = clienteRepository.findAllClientesCorporativos().stream()
                .map( x -> x.getNombre()).collect(Collectors.toList());

        nombresCorporativos.stream().forEach(System.out::println);


        //Probando el Entity Graph de empleado - Cliente corporativo

        Pedido p1 = Pedido.builder()
                .producto("Cocacola al por mayor")
                .precio(200.0).build();

        Pedido p2 = Pedido.builder()
                .producto("Natillas al por mayor")
                .precio(250).build();

        Pedido p3 = Pedido.builder()
                .producto("Silla de oficina")
                .precio(120.50).build();

        pedidoService.saveAll(List.of(p1, p2, p3));

        //c1 es el cliente corporativo inicializado arriba
        c1.addPedido(p1);
        c1.addPedido(p2);

        //No funciona. Aun no comprendo como usar los Entity Graphs.
    /*
        List <String> listaProductosDeCorporativos = clienteRepository.findAllPedidosFromClientesCorporativos().stream().map(x -> x.getProducto()).collect(Collectors.toList());

        listaProductosDeCorporativos.stream().forEach(System.out::println);
    */
    }



}
