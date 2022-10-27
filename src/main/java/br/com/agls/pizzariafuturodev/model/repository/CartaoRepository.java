package br.com.agls.pizzariafuturodev.model.repository;

import br.com.agls.pizzariafuturodev.model.entity.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao,Long> {
    Optional<Cartao> findByNumeroAndClienteId(String numero, Long idCliente);
}
