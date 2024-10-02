package entities.contas;

import entities.Cliente;

public class ContaPoupanca extends Conta {
    private static final double TAXA_RENDIMENTO = 0.005; // 0,5% de rendimento

    public ContaPoupanca(Cliente cliente) {
        super(cliente, TipoConta.CONTA_POUPANCA);
    }

    // Método específico da conta poupança
    public void renderJuros() {
        double rendimento = saldo * TAXA_RENDIMENTO;
        saldo += rendimento;
        adicionarHistorico("Rendimento de juros de R$ " + String.format("%.2f", rendimento));
    }
}
