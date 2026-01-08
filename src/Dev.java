import java.util.*;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp) {
        // Adiciona todos os conteúdos do bootcamp aos conteúdos inscritos do Dev
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        // Adiciona o Dev à lista de inscritos do bootcamp
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
        // Pega o primeiro conteúdo da lista (ordem de inscrição)
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if (conteudo.isPresent()) {
            // Se existir, move de "Inscritos" para "Concluídos"
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            System.err.println("Atenção: Você não está matriculado em nenhum conteúdo!");
        }
    }

    public double calcularTotalXp() {
        // Percorre todos os conteúdos concluídos e soma o XP de cada um
        return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    // Getters e Setters para permitir o acesso seguro aos dados (Encapsulamento)
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Set<Conteudo> getConteudosInscritos() { return conteudosInscritos; }
    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) { this.conteudosInscritos = conteudosInscritos; }

    public Set<Conteudo> getConteudosConcluidos() { return conteudosConcluidos; }
    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) { this.conteudosConcluidos = conteudosConcluidos; }

    // Métodos para comparação de objetos (necessário para o Set funcionar corretamente)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && 
               Objects.equals(conteudosInscritos, dev.conteudosInscritos) && 
               Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}
