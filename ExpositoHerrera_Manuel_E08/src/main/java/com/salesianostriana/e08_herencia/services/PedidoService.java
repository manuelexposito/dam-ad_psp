package com.salesianostriana.e08_herencia.services;

import com.salesianostriana.e08_herencia.models.Pedido;
import com.salesianostriana.e08_herencia.repositories.PedidoRepository;
import com.salesianostriana.e08_herencia.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class PedidoService extends BaseService<Pedido, Long, PedidoRepository> {
}
