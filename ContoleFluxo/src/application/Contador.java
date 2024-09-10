package application;

import exceptions.ParametrosInvalidosException;

import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Contador {
    public static void main(String[] args){
            Scanner sc = new Scanner(System.in);

            System.out.print("Digite o primeiro parâmetro: ");
            int parametroUm  = sc.nextInt();
            System.out.print("Digite o segundo parâmetro: ");
            int parametroDois = sc.nextInt();

            try {
                contar(parametroUm, parametroDois);
            }catch (ParametrosInvalidosException | InterruptedException exception) {
                System.out.println("Parâmetros inválidos: " + exception.getMessage());
            }

        }
        static void contar(int parametroUm, int parametroDois ) throws ParametrosInvalidosException, InterruptedException {
            if (parametroUm > parametroDois){
                throw new ParametrosInvalidosException("O primeiro parâmetro tem que ser menor que o segundo");
            }else {
                int contagem = parametroDois - parametroUm;
                for (int i = 0; i < contagem; i++) {
                    System.out.println("Imprimindo o número " + (i + 1));
                    Thread.sleep(500);
                }
            }
        }
}
