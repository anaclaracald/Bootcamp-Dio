package entities;

import entities.contas.Conta;

import java.util.HashMap;
import java.util.Map;

public class Banco {
    Map<Integer, Conta> clientes = new HashMap<>();

    public void adicionarCliente(Conta conta){
        clientes.put(conta.getNumero(), conta);
        System.out.println("\nConta adicionada com sucesso!\n");
    }

    public void removerCliente(int numeroConta){
        if(clientes.containsKey(numeroConta)){
            clientes.remove(numeroConta);
            System.out.println("\nConta removida com sucesso!\n");
        }else{
            System.out.println("\nEssa conta não existe!\n");
        }
    }

    public Conta buscarConta(int numeroConta) {
        return clientes.get(numeroConta);
    }

    public boolean verificarExistenciaConta(String CPF) {
        for (Conta conta : clientes.values()) {
            if (conta.getCliente().getCPF().equals(CPF)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Clientes:\n");
        for (Map.Entry<Integer, Conta> c : clientes.entrySet()){
            sb.append("\nNúmero da conta: ").append(c.getValue().getNumero());
            sb.append("\nCPF: ").append(c.getValue().getCliente().getCPF());
            sb.append("\nNome: ").append(c.getValue().getCliente().getNome());
            sb.append("\nSaldo: ").append(c.getValue().getSaldo()).append("\n");
        }
        return sb.toString();
    }
}
