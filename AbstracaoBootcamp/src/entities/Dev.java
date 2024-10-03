package entities;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {
    private final String nome;
    private final Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private final Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public Dev(String nome) {
        this.nome = nome;
    }

    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir(){
        Optional<Conteudo> conteudo= this.conteudosInscritos.stream().findFirst();
        if(conteudo.isPresent()){
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.add(conteudo.get());
        }else{
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

    public Double calcXP(){
        return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXP)
                .sum();
    }

    public String getNome() {
        return nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dev{")
                .append("nome='").append(nome).append('\'')
                .append(", conteudosInscritos=");

        if (conteudosInscritos.isEmpty()) {
            sb.append("Nenhum conteúdo inscrito");
        } else {
            sb.append("\n");
            for (Conteudo conteudo : conteudosInscritos) {
                sb.append("  - ").append(conteudo.getTitulo()).append(" (").append(conteudo.getClass().getSimpleName()).append(")\n");
            }
        }
        sb.append(", conteudosConcluidos=");

        if (conteudosConcluidos.isEmpty()) {
            sb.append("Nenhum conteúdo concluído");
        } else {
            sb.append("\n");
            for (Conteudo conteudo : conteudosConcluidos) {
                sb.append("  - ").append(conteudo.getTitulo()).append(" (").append(conteudo.getClass().getSimpleName()).append(")\n");
            }
        }

        sb.append('}');
        return sb.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(getNome(), dev.getNome()) && Objects.equals(getConteudosInscritos(), dev.getConteudosInscritos()) && Objects.equals(getConteudosConcluidos(), dev.getConteudosConcluidos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getConteudosInscritos(), getConteudosConcluidos());
    }
}
