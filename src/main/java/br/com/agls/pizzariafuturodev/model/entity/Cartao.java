package br.com.agls.pizzariafuturodev.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(length = 16)
    @Size(max = 16)
    private String numero;

    @NotNull
    private LocalDate validade;

    @PositiveOrZero
    private Double limite;

    private Double limiteUtilizado = 0.0;

    private Double saldo = 0.0;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    /*
        alter table cartao add constranit forenig key(fk_usuario_cartao)
        column usuario_id references usuario(id);
     */
}
