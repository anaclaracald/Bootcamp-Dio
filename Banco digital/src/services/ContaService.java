package services;

import entities.Cliente;
import entities.contas.Conta;

public interface ContaService {
    void sacar(double valor);
    void depositar(double valor);
    void transferir(double valor, Conta destino);
    void exibirExtrato(Cliente cliente);
}
