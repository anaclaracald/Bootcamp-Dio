package entities;

import java.time.LocalDateTime;

public class Mentoria extends Conteudo{
    private LocalDateTime data;

    public Mentoria(String titulo, String descricao, LocalDateTime data) {
        super(titulo, descricao);
        this.data = data;
    }

    public LocalDateTime getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Mentoria{" +
                "titulo='" + super.getTitulo() + '\'' +
                ", descricao='" + super.getDescricao() + '\''+
                "data=" + data +
                '}';
    }

    @Override
    public double calcularXP() {
        return XP_PADRAO +20;
    }
}
