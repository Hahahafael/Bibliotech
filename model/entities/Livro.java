package model.entities;

import java.awt.image.BufferedImage;
import java.util.Date;

public class Livro extends Documento{
    private String editora;
    private int edicao;

    // Construtor
    public Livro(String codigo, String titulo, Date data, BufferedImage capa, int numPaginas, String idioma, Categoria categoria, String editora, int edicao) {
        super(codigo, titulo, data, capa, numPaginas, idioma, categoria);
        this.editora = editora;
        this.edicao = edicao;
    }

    public Livro(String codigo) {
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
