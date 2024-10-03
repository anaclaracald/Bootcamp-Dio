package entities;

public class Curso extends Conteudo{
    private Integer cargaHoraria;

    public Curso(String titulo, String descricao, Integer cargaHoraria) {
        super(titulo, descricao);
        this.cargaHoraria = cargaHoraria;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "titulo='" + super.getTitulo() + '\'' +
                ", descricao='" + super.getDescricao() + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                '}';
    }

    @Override
    public double calcularXP() {
        return cargaHoraria * XP_PADRAO;
    }
}
