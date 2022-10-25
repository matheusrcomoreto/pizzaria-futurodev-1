package br.com.agls.pizzariafuturodev.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
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

    //@Max(16)
    //@Column(length = 16)
    @Size(max = 16)
    private String numero;

    @NotNull
    private LocalDate validade;

    @PositiveOrZero
    private Double limite;

    private Double limiteUtilizado;

    private Double saldo;
}
