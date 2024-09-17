package application;

import entities.Iphone;

public class Main {
    public static void main(String[] args){
        Iphone iphone = new Iphone();

        System.out.println("\n");
        iphone.getReprodutorMusical().selecionarMusica("Meu bem querer - Djavan");
        iphone.getReprodutorMusical().tocar();
        iphone.getReprodutorMusical().pausar();

        System.out.println("\n");
        iphone.getAparelhoTelefonico().atender();
        iphone.getAparelhoTelefonico().iniciarCorreioVoz();
        iphone.getAparelhoTelefonico().ligar("88384873483");

        System.out.println("\n");
        iphone.getNavegadorInternet().exibirPagina("www.google.com");
        iphone.getNavegadorInternet().atualizarPagina();
        iphone.getNavegadorInternet().adicionarNovaAba();
    }
}
