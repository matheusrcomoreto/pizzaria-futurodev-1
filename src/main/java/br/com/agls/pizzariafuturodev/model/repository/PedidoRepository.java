package br.com.agls.pizzariafuturodev.model.repository;

import br.com.agls.pizzariafuturodev.model.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
