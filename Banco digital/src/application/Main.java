package application;

import entities.Cliente;
import entities.Banco;
import entities.contas.Conta;
import entities.contas.ContaCorrente;
import entities.contas.ContaPoupanca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Banco banco = new Banco();
        int opcao;

        do {
            System.out.println("\n--------------------------- Menu ---------------------------\n");
            System.out.println("[1] Criar conta");
            System.out.println("[2] Exibir conta");
            System.out.println("[3] Verificar existência de conta");
            System.out.println("[4] Listar clientes do banco");
            System.out.println("[5] Sacar");
            System.out.println("[6] Depositar");
            System.out.println("[7] Transferir");
            System.out.println("[8] Exibir extrato");
            System.out.println("[0] Sair");
            System.out.print("\nEscolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n--------------------------- Criar conta ---------------------------\n");
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF: ");
                    String CPF = sc.nextLine();

                    System.out.println("\n[1] Conta corrente\n[2] Conta poupança\nDigite o tipo de conta que deseja abrir para esse cliente: ");
                    int tipoConta = sc.nextInt();

                    if (tipoConta == 1) {
                        Conta conta = new ContaCorrente(new Cliente(nome, CPF));
                        banco.adicionarCliente(conta);
                        System.out.println("Conta corrente de " + conta.getCliente().getNome() + " criada com sucesso!");
                    } else if (tipoConta == 2) {
                        Conta conta = new ContaPoupanca(new Cliente(nome, CPF));
                        banco.adicionarCliente(conta);
                        System.out.println("Conta poupança de " + conta.getCliente().getNome() + " criada com sucesso!");
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    break;

                case 2:
                    System.out.print("\nDigite o número da conta para exibir: ");
                    int numeroConta = sc.nextInt();
                    Conta contaExibir = banco.buscarConta(numeroConta);
                    if (contaExibir != null) {
                        System.out.println(contaExibir);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 3:
                    System.out.print("\nDigite o número da conta para verificar existência: ");
                    int numeroContaVerificar = sc.nextInt();
                    Conta contaBuscar = banco.buscarConta(numeroContaVerificar);
                    if (contaBuscar != null) {
                        System.out.println("A conta existe.");
                        System.out.println(contaBuscar);
                    } else {
                        System.out.println("A conta não existe.");
                    }
                    break;

                case 4:
                    System.out.println(banco);
                    break;

                case 5:
                    System.out.print("\nDigite o número da conta para sacar: ");
                    int numeroContaSaque = sc.nextInt();
                    Conta contaSacar = banco.buscarConta(numeroContaSaque);
                    if (contaSacar != null) {
                        System.out.print("Digite o valor para sacar: ");
                        double valorSaque = sc.nextDouble();
                        contaSacar.sacar(valorSaque);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 6:
                    System.out.print("\nDigite o número da conta para depositar: ");
                    int numeroContaDeposito = sc.nextInt();
                    Conta contaDepositar = banco.buscarConta(numeroContaDeposito);
                    if (contaDepositar != null) {
                        System.out.print("Digite o valor para depositar: ");
                        double valorDeposito = sc.nextDouble();
                        contaDepositar.depositar(valorDeposito);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 7:
                    System.out.print("\nDigite o número da conta de origem: ");
                    int numeroContaOrigem = sc.nextInt();
                    Conta contaOrigem = banco.buscarConta(numeroContaOrigem);
                    if (contaOrigem != null) {
                        System.out.print("Digite o número da conta de destino: ");
                        int numeroContaDestino = sc.nextInt();
                        Conta contaDestino = banco.buscarConta(numeroContaDestino);
                        if (contaDestino != null) {
                            System.out.print("Digite o valor para transferir: ");
                            double valorTransferencia = sc.nextDouble();
                            contaOrigem.transferir(valorTransferencia, contaDestino);
                        } else {
                            System.out.println("Conta de destino não encontrada.");
                            return;
                        }
                    } else {
                        System.out.println("Conta de origem não encontrada.");
                        return;
                    }
                    break;

                case 8:
                    System.out.print("\nDigite o número da conta para exibir o extrato: ");
                    int numeroContaExtrato = sc.nextInt();
                    Conta contaExtrato = banco.buscarConta(numeroContaExtrato);
                    if (contaExtrato != null) {
                        contaExtrato.exibirExtrato(contaExtrato.getCliente());
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 0:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);

        sc.close();
    }
}
