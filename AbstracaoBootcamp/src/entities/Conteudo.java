package entities;

public abstract class Conteudo {
    private String titulo;
    private String descricao;
    protected static final double XP_PADRAO = 10;

    public Conteudo(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public abstract double calcularXP();


}
