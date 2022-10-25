package br.com.agls.pizzariafuturodev.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartaoResponseDto {

    private Long id;

    private String numero;
}
