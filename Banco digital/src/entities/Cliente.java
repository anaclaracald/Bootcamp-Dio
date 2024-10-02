package entities;

import entities.contas.Conta;

public class Cliente {
    private String nome;
    private String CPF;

    public Cliente(String nome, String CPF) {
        if (!isCPFValido(CPF)) {
            throw new IllegalArgumentException("CPF inválido.");
        }
        this.nome = nome;
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return CPF;
    }

    private boolean isCPFValido(String CPF) {
        return CPF != null && CPF.matches("\\d{11}");
    }
}
