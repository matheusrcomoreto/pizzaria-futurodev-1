package br.com.agls.pizzariafuturodev.model.repository;

import br.com.agls.pizzariafuturodev.model.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
