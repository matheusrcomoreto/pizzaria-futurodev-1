package br.com.agls.pizzariafuturodev.model.exception;

public class SaldoInsuficienteException extends RuntimeException {

    public SaldoInsuficienteException() {
        super("Saldo insuficiente!");
    }
}
