package application;

import entities.Bootcamp;
import entities.Curso;
import entities.Dev;
import entities.Mentoria;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Bootcamp> bootcamps = new ArrayList<>();
    private static List<Dev> devs = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int opcao;

        do{
            System.out.println("\n\n[0] Sair\n[1] Cadastrar bootcamp\n[2] Cadastrar Dev\n" +
                    "[3] Adicionar conteúdo no Bootcamp\n[4] Exibir bootcamps disponíveis\n[5] Inscrever Dev no Bootcamp");

            System.out.print("Digite a opção desejada: ");
            opcao = sc.nextInt();

            switch (opcao){
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    case 1:
                        cadastrarBootcamp(sc);
                        break;
                    case 2:
                        cadastrarDev(sc);
                        break;
                    case 3:
                        adicionarConteudo(sc);
                        break;
                    case 4:
                        System.out.println(bootcamps);;
                        break;
                    case 5:
                        inscreverDevNoBootcamp(sc);
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
            }


        }while(opcao != 0);

        sc.close();
    }

    private static void adicionarConteudo(Scanner sc) {
        sc.nextLine();

        if (bootcamps.isEmpty()) {
            System.out.println("Nenhum bootcamp cadastrado. Cadastre um bootcamp primeiro.");
            return;
        }

        System.out.print("Digite o nome do bootcamp para adicionar conteúdo: ");
        String nomeBootcamp = sc.nextLine();

        Bootcamp bootcamp = buscarBootcampPorNome(nomeBootcamp);
        if (bootcamp == null) {
            System.out.println("Bootcamp não encontrado.");
            return;
        }

        System.out.println("Escolha o tipo de conteúdo a ser adicionado:");
        System.out.println("[1] Curso\n[2] Mentoria");
        int tipoConteudo = sc.nextInt();
        sc.nextLine();

        switch (tipoConteudo) {
            case 1:
                Curso curso = cadastrarCurso(sc);
                bootcamp.adicionarCurso(curso);
                System.out.println("Curso adicionado ao bootcamp " + bootcamp.getNome());
                break;
            case 2:
                Mentoria mentoria = cadastrarMentoria(sc);
                bootcamp.adicionarMentoria(mentoria);
                System.out.println("Mentoria adicionada ao bootcamp " + bootcamp.getNome());
                break;
            default:
                System.out.println("Tipo de conteúdo inválido.");
        }
    }
    private static void inscreverDevNoBootcamp(Scanner sc) {
        sc.nextLine();

        System.out.print("Digite o nome do Dev: ");
        String nomeDev = sc.nextLine();

        Dev dev = buscarDevPorNome(nomeDev); // Implemente este método para buscar o Dev pela nome
        if (dev == null) {
            System.out.println("Dev não encontrado. Certifique-se de que ele foi cadastrado.");
            return;
        }

        System.out.print("Digite o nome do bootcamp para inscrever: ");
        String nomeBootcamp = sc.nextLine();

        Bootcamp bootcamp = buscarBootcampPorNome(nomeBootcamp);
        if (bootcamp == null) {
            System.out.println("Bootcamp não encontrado.");
            return;
        }

        dev.inscreverBootcamp(bootcamp);
        System.out.println("Dev " + dev.getNome() + " inscrito no bootcamp " + bootcamp.getNome() + " com sucesso!");
    }
    private static Dev buscarDevPorNome(String nomeDev) {
        for (Dev dev : devs) { // listaDeDevs deve ser uma lista que armazena os desenvolvedores
            if (dev.getNome().equalsIgnoreCase(nomeDev)) {
                return dev;
            }
        }
        return null;
    }
    private static Bootcamp buscarBootcampPorNome(String nome) {
        for (Bootcamp bootcamp : bootcamps) {
            if (bootcamp.getNome().equalsIgnoreCase(nome)) {
                return bootcamp;
            }
        }
        return null;
    }
    private static void cadastrarBootcamp(Scanner sc) {
        sc.nextLine();

        System.out.print("Digite o nome do bootcamp: ");
        String nome = sc.nextLine();

        System.out.print("Digite a descrição do bootcamp: ");
        String descricao = sc.nextLine();

        Bootcamp bootcamp = new Bootcamp(nome, descricao);
        System.out.println("Bootcamp cadastrado com sucesso! ");
        bootcamps.add(bootcamp);
    }
    private static void cadastrarDev(Scanner sc) {
        sc.nextLine();

        System.out.print("Digite o nome do Dev: ");
        String nome = sc.nextLine();

        Dev dev = new Dev(nome);
        devs.add(dev);
        System.out.println("\nDev cadastrado com sucesso!" );
    }
    private static Curso cadastrarCurso(Scanner sc){
        sc.nextLine();

        System.out.print("Digite o título do curso: ");
        String titulo = sc.nextLine();

        System.out.print("Digite a descrição do curso: ");
        String descricao = sc.nextLine();

        System.out.print("Digite a carga horária do curso: ");
        int cargaHoraria = sc.nextInt();

        Curso curso = new Curso(titulo, descricao, cargaHoraria);
        System.out.println("Curso cadastrado com sucesso!");
        return curso;
    }
    private static Mentoria cadastrarMentoria(Scanner sc){
        sc.nextLine();
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());

        System.out.print("Digite o título do mentoria: ");
        String titulo = sc.nextLine();

        System.out.print("Digite a descrição do mentoria: ");
        String descricao = sc.nextLine();

        System.out.print("Digite a data e hora da mentoria DD/MM/YYYY HH:MM: ");
        String dataHoraString = sc.nextLine();
        LocalDateTime dataHora = LocalDateTime.parse(dataHoraString, fmt2);

        Mentoria mentoria = new Mentoria(titulo, descricao, dataHora);
        System.out.println("Mentoria cadastrado com sucesso!");
        return mentoria;
    }

}



