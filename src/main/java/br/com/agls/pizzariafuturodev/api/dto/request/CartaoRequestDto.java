package br.com.agls.pizzariafuturodev.api.dto.request;

import br.com.agls.pizzariafuturodev.model.entity.Cartao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartaoRequestDto {

    @Size(max = 16)
    private String numero;

    @NotNull
    private LocalDate validade;

    @PositiveOrZero
    private Double limite;

}
