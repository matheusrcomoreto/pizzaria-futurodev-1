package br.com.agls.pizzariafuturodev.model.service.interfaces;

import br.com.agls.pizzariafuturodev.model.entity.Pedido;

public interface PedidoService extends DefaultCrud<Pedido>{
    Pedido fecharConta (Long idPedido);
}
