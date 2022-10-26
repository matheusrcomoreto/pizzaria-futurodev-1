package br.com.agls.pizzariafuturodev.model.exception;

public class FalhaNoPagamentoException extends RuntimeException {

    public FalhaNoPagamentoException() {
        super("Houve uma falha no processamento do pagamento.");
    }
}
