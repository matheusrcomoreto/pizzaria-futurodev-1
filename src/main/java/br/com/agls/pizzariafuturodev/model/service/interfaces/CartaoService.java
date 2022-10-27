package br.com.agls.pizzariafuturodev.model.service.interfaces;

import br.com.agls.pizzariafuturodev.model.entity.Cartao;

public interface CartaoService extends DefaultCrud<Cartao> {

    Cartao buscarPeloNumeroCartaoCliente(String numero, Long idCliente);
}
