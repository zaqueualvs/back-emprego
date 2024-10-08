package com.alves.backemprego.application.domain.model.enums;

public enum Status {

    INCOMPLETO(1, "Incompleto"),
    EM_ANDAMENTO(2, "Em Andamento"),
    CONCLUIDO(3, "Concluido");

    private Integer cod;
    private String description;

    Status(int cod, String description) {
        this.cod = cod;
        this.description = description;
    }
    public Integer getCod() {
        return cod;
    }
    public String getDescription() {
        return description;
    }

    public static Status getStatus(Integer cod) {
        if (cod == null) {
            return null;
        }
        for (Status status : Status.values()) {
            if (cod.equals(status.getCod())) {
                return status;
            }
        }
        throw new IllegalArgumentException("Codigo de status invalido: " + cod);
    }
}
