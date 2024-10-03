package entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Bootcamp {
    private final String nome;
    private final String descricao;
    private final LocalDate dataInicial = LocalDate.now();
    private final LocalDate dataFinal = dataInicial.plusDays(45);
    private final Set<Dev> devsInscritos = new HashSet<>();
    private final Set<Conteudo> conteudos = new LinkedHashSet<>();

    public Bootcamp(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public void adicionarMentoria(Mentoria mentoria){
        getConteudos().add(mentoria);
    }

    public void adicionarCurso(Curso curso){
        getConteudos().add(curso);
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public Set<Dev> getDevsInscritos() {
        return devsInscritos;
    }

    public Set<Conteudo> getConteudos() {
        return conteudos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n\nBootcamp: ").append(nome).append("\n");
        sb.append("Descrição: ").append(descricao).append("\n");
        sb.append("Conteúdos:\n");

        if (conteudos.isEmpty()) {
            sb.append("  Nenhum conteúdo cadastrado.\n");
        } else {
            for (Conteudo conteudo : conteudos) {
                sb.append("  - ").append(conteudo.getTitulo())
                        .append(" (").append(conteudo.getClass().getSimpleName()).append(")\n");
            }
        }

        return sb.toString();
    }



}
