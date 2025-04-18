package br.edu.utfpr.td.tsi.gerenciador.documentos.modelo;

public class Documento {
    private String id;
    private String nome;
    private String descricao;
    private String conteudo;
    private Autor autor; // Adicionado campo para o autor

    // Getters e setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Documento [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", conteudo=" + conteudo
                + ", autor=" + (autor != null ? autor.getNome() : "null") + "]";
    }
}
