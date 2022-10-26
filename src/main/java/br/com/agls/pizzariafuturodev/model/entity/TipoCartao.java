package br.com.agls.pizzariafuturodev.model.entity;

import lombok.Getter;

@Getter
public enum TipoCartao {

    DEBITO("Débito"),
    CREDITO("Crédito");

    private String tipoCartao;

    private TipoCartao(String tipoCartao) {
        this.tipoCartao = tipoCartao;
    }
}
