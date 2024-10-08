package com.alves.backemprego.application.domain.model.enums;

public enum AcademicDegree {

    MEDIO(1, "Médio"),
    FUNDAMENTAL(2, "Fundamental"),
    TECNICO(3, "Técnico"),
    SUPERIOR(4, "Superior"),
    CURSO(5, "Curso"),
    RECONHECIMENTO(6, "Reconhecimento"),
    TRABALHO_VOLUNTARIO(7, "Trabalho Voluntário"),
    CERTIFICADO(8, "Certificado");

    private Integer cod;
    private String description;

    AcademicDegree(int cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public Integer getCod() {
        return cod;
    }

    public String getDescription() {
        return description;
    }

    public static AcademicDegree getAcademicDegree(Integer cod) {
        if (cod == null) {
            return null;
        }
        for (AcademicDegree academicDegree : AcademicDegree.values()) {
            if (cod.equals(academicDegree.getCod())) {
                return academicDegree;
            }
        }
        throw new IllegalArgumentException("Codigo de formação invalido: " + cod);
    }
}
