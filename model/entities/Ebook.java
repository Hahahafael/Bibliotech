package model.entities;

import java.util.Date;


public class Ebook extends Documento{
    private String editora;
    private int edicao;

    // Construtor
    public Ebook(String codigo, String titulo, Date data, int numPaginas, String idioma, Categoria categoria, String editora, int edicao) {
        super(codigo, titulo, data, numPaginas, idioma, categoria);
        this.editora = editora;
        this.edicao = edicao;
    }

    public Ebook(String codigo) {
        super(codigo);
    }

    // Getters e setters
    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

}
