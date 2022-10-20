package br.com.agls.pizzariafuturodev.model.service.interfaces;

import br.com.agls.pizzariafuturodev.model.entity.Categoria;

import java.util.List;

public interface CategoriaService extends DefaultCrud<Categoria> {
    Categoria buscarPorNome(String nome);

}
