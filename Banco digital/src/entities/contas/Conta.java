package entities.contas;

import entities.Cliente;
import services.ContaService;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.lang.String.format;

public abstract class Conta implements ContaService {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    private static int ID = 1;

    protected Integer agencia;
    protected Integer numero;
    protected Double saldo;
    private Cliente cliente;
    private final TipoConta conta;
    Map<Integer, String> historicoOperacoes = new HashMap<>();


     public Conta(Cliente cliente, TipoConta conta) {
         this.conta = conta;
         this.agencia = Conta.AGENCIA_PADRAO;
         this.numero = SEQUENCIAL++;
         this.cliente = cliente;
         this.saldo = 0.0;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public Integer getNumero() {
        return numero;
    }

    public Double getSaldo() {
        return saldo;
    }

     public Cliente getCliente() {
         return cliente;
     }

     public void adicionarHistorico(String operacao){
         historicoOperacoes.put(ID++, operacao);
     }

     @Override
     public void exibirExtrato(Cliente cliente) {
         System.out.println(cliente.getNome());
         System.out.println("Saldo da conta R$"+ format("%.2f", saldo));
         for (Map.Entry<Integer, String> entry : historicoOperacoes.entrySet()){
             System.out.println("ID"+ entry.getKey() + ": "+ entry.getValue());
         }
     }

     @Override
     public void sacar(double valor) {
         if (saldo >= valor){
             saldo -= valor;
             adicionarHistorico("Saque, R$"+ format("%.2f", valor));
             System.out.println("Saque feito com sucesso!");
         }else{
             System.out.println("\nSaldo insuficiente!");
         }
     }

     @Override
     public void depositar(double valor) {
         if (valor > 0.1){
             saldo += valor;
             adicionarHistorico("Depósito, R$"+ format("%.2f", valor));
             System.out.println("Depósito feito com sucesso!");
         }else{
             System.out.println("\nSó depositamos valores acima de R$0,1");
         }
     }

     @Override
     public void transferir(double valor, Conta destino) {
         if(saldo >= valor){
             this.sacar(valor);
             destino.depositar(valor);
             adicionarHistorico("Transferência para "+ destino.getCliente().getNome() + ", R$" + format("%.2f", valor));
             System.out.println("Transferência feita com sucesso!");
         }else{
             System.out.println("Saldo insuficiente para realizar a operação.");
         }
     }

    @Override
    public String toString() {
        return "\nConta: " +
                "\nNome: " + getCliente().getNome() +
                "\nAgencia: " + agencia +
                "\nNumero: " + numero +
                "\nSaldo: " + saldo ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return Objects.equals(getAgencia(), conta.getAgencia()) && Objects.equals(getNumero(), conta.getNumero()) && Objects.equals(getSaldo(), conta.getSaldo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAgencia(), getNumero(), getSaldo());
    }

     public TipoConta getConta() {
         return conta;
     }
 }
