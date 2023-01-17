package br.com.vr.authorizer.infra.exception.enums;

public enum ExceptionsE {

    INSUFFICIENT_BALANCE("Saldo insuficiente"),
    INVALID_PASSWORD("Senha Incorreta"),
    CREDIT_CARD_ALREADY_REGISTERED("Cartão ja Cadastrado"),
    NON_EXISTING_CARD("Cartão não existente");

    private final String descricao;

    ExceptionsE(String tipo) {
        this.descricao = tipo;
    }

    public String getTipo() {
        return descricao;
    }
}
