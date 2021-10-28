package com.salesianostriana.e08_herencia.repositories;

import com.salesianostriana.e08_herencia.models.Cliente;
import com.salesianostriana.e08_herencia.models.Pedido;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {


    @Query("select c from Cliente c where TYPE(c) = ClienteCorporativo")
    List<Cliente> findAllClientesCorporativos();

  /*  @EntityGraph("grafo-pedido-cliente")
    @Query("""
            SELECT p
            FROM Pedido p
            INNER JOIN Cliente c
            WHERE TYPE(c) = 'ClienteCorporativo'
            """)
    List<Pedido> findAllPedidosFromClientesCorporativos();
*/

    @EntityGraph(Cliente.CLIENTE_PEDIDO)
    Optional<Cliente> findById(Long id);

}
