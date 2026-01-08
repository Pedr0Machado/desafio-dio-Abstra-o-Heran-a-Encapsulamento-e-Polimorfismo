public abstract class Conteudo {
    // Encapsulamento: atributos privados
    protected static final double XP_PADRAO = 10d;
    private String titulo;
    private String descricao;

    // Polimorfismo: cada classe filha implementará sua regra de XP
    public abstract double calcularXp();

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}