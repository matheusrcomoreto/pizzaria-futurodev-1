package br.com.agls.pizzariafuturodev.model.repository;

import br.com.agls.pizzariafuturodev.model.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    //Se existir uma categoria com o nome passado como parâmetro, retorna true.
    boolean existsByNome(String nome);

    Optional<Categoria> findByNome(String nome);//select * from categoria where nome = "parametro";
}
