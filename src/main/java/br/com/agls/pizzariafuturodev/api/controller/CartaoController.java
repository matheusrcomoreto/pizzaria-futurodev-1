package br.com.agls.pizzariafuturodev.api.controller;

import br.com.agls.pizzariafuturodev.api.dto.request.CartaoRequestDto;
import br.com.agls.pizzariafuturodev.api.dto.response.CartaoResponseDto;
import br.com.agls.pizzariafuturodev.model.entity.Cartao;
import br.com.agls.pizzariafuturodev.model.service.interfaces.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {

    @Autowired
    private CartaoService cartaoService;

    @PostMapping
    public ResponseEntity<CartaoResponseDto> salvar(@RequestBody @Valid CartaoRequestDto cartaoRequestDto) {
        Cartao cartao = instanciarCartao(cartaoRequestDto);

        Cartao cartaoSalvo = this.cartaoService.salvar(cartao);

        CartaoResponseDto cartaoResponse = instanciarCartaoResponse(cartaoSalvo);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(cartaoResponse);
    }

    private Cartao instanciarCartao(CartaoRequestDto cartaoRequestDto){
        Cartao cartao = new Cartao();
        cartao.setNumero(cartaoRequestDto.getNumero());
        cartao.setValidade(cartaoRequestDto.getValidade());
        cartao.setLimite(cartaoRequestDto.getLimite());
        cartao.setUsuario((cartaoRequestDto.getUsuario()));

        return cartao;
    }

    private CartaoResponseDto instanciarCartaoResponse(Cartao cartao) {
        CartaoResponseDto cartaoResponse = new CartaoResponseDto();
        cartaoResponse.setId(cartao.getId());
        cartaoResponse.setNumero(cartao.getNumero());
        return cartaoResponse;
    }
}
