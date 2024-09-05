package application;

import entities.ContaTerminal;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        ContaTerminal conta = new ContaTerminal(1021, "067-8", "Mario Andrade", 237.48);

        System.out.print("Por favor, digite o número da Agência: ");
        String agencia = sc.nextLine();

        System.out.print("Usuário: ");
        int numero = sc.nextInt();

        if (conta.getNumero().equals(numero) && conta.getAgencia().equals(agencia)){
            System.out.println(conta);
        }else{
            System.out.println("Esse usuário não existe ou o número da agência está incorreto.");
        }

        sc.close();
    }
}
