package br.com.agls.pizzariafuturodev.model.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Prato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @PositiveOrZero
    private Double valor;

    @ManyToOne
    private Categoria categoria;
    // alter table add constraint forenig_key categoria references categoria(id);

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    @JsonBackReference
    @ManyToMany(mappedBy = "pedidoPrato")
    private List<Pedido> pedido;
}
