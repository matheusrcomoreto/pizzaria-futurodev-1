package br.com.agls.pizzariafuturodev.model.service.interfaces;

import br.com.agls.pizzariafuturodev.model.entity.Categoria;

import java.util.List;

public interface CategoriaService {

    Categoria salvar(Categoria categoria);
    Categoria atualizar(Categoria categoria);
    Categoria buscar(Long id);
    List<Categoria> listar();
    void deletar(Long id);
}
