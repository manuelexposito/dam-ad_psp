package com.salesianostriana.e08_herencia.repositories;

import com.salesianostriana.e08_herencia.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
