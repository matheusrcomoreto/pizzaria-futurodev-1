package br.com.agls.pizzariafuturodev.model.service.interfaces;

import br.com.agls.pizzariafuturodev.model.entity.Prato;

public interface PratoService extends DefaultCrud<Prato> {
    Prato buscarPorNome(String nome);
}
