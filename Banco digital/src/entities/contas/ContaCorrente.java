package entities.contas;

import entities.Cliente;

public class ContaCorrente extends Conta {

    private static final double TAXA_MANUTENCAO = 15.00;

    public ContaCorrente(Cliente cliente) {
        super(cliente, TipoConta.CONTA_CORRENTE);
    }

    // Método específico da conta corrente
    public void cobrarTaxaManutencao() {
        if (saldo >= TAXA_MANUTENCAO) {
            saldo -= TAXA_MANUTENCAO;
            adicionarHistorico("Cobrança de taxa de manutenção de R$ " + String.format("%.2f", TAXA_MANUTENCAO));
        } else {
            adicionarHistorico("Tentativa de cobrança de taxa de manutenção de R$ " + String.format("%.2f", TAXA_MANUTENCAO) + " - Saldo insuficiente");
        }
    }
}
