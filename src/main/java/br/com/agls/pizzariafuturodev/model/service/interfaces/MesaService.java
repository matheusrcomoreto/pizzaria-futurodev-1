package br.com.agls.pizzariafuturodev.model.service.interfaces;

import br.com.agls.pizzariafuturodev.model.entity.Mesa;

import java.util.List;

public interface MesaService {

    Mesa salvar(Mesa mesa);

    Mesa atualizar(Mesa mesa);

    Mesa buscar(Long id);

    List<Mesa> listar();

    void excluir(Long id);
}
