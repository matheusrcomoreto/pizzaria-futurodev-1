package br.com.agls.pizzariafuturodev.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Mesa mesa;

    private Double valorTotal;

    private Boolean isPago;


    @JsonManagedReference
    @ManyToMany
    @JoinTable(
            name = "pedido_prato",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "prato_id"))
    private List<Prato> pedidoPrato;

    /*create table pedido_prato (
        pedido_id integer,
        prato_id integer,

        add contraint (fk_pedido_id) column pedido_id references pedido (id)
        add contraint (fk_prato_id) column prato_id references prato (id)
    );
     */
}
