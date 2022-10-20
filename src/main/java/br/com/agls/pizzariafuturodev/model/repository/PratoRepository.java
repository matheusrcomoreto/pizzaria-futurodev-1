package br.com.agls.pizzariafuturodev.model.repository;

import br.com.agls.pizzariafuturodev.model.entity.Prato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PratoRepository extends JpaRepository<Prato, Long> {
}
