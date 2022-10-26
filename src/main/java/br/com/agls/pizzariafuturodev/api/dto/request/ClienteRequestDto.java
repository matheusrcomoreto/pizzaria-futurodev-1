package br.com.agls.pizzariafuturodev.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequestDto {

    @NotNull
    private String nome;

    private List<CartaoRequestDto> cartoes;
}
