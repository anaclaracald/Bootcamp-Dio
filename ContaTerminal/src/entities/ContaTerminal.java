package entities;

import java.util.Objects;

public class ContaTerminal {
    private Integer numero;
    private String agencia;
    private String nomeCliente;
    private Double saldo;

    public ContaTerminal(Integer numero, String agencia, String nomeCliente, Double saldo) {
        this.numero = numero;
        this.agencia = agencia;
        this.nomeCliente = nomeCliente;
        this.saldo = saldo;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Double getSaldo() {
        return saldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContaTerminal that = (ContaTerminal) o;
        return Objects.equals(numero, that.numero) && Objects.equals(agencia, that.agencia) && Objects.equals(nomeCliente, that.nomeCliente) && Objects.equals(saldo, that.saldo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, agencia, nomeCliente, saldo);
    }

    @Override
    public String toString() {
        return "Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, " +
                "sua agência é "+ agencia +", conta "+ numero +" e seu saldo "+ saldo + " já " +
                "está disponível para saque";
    }
}
