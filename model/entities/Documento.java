package model.entities;

import java.util.Date;
import java.awt.image.BufferedImage;

public abstract class Documento {
    private String codigo;
    private String titulo;
    private Date data;
    private BufferedImage capa;
    private int numPaginas;
    private String idioma;
    private Categoria categoria;

    public Documento(String codigo, String titulo, Date data, BufferedImage capa, int numPaginas, String idioma, Categoria categoria) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.data = data;
        this.capa = capa;
        this.numPaginas = numPaginas;
        this.idioma = idioma;
        this.categoria = categoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BufferedImage getCapa() {
        return capa;
    }

    public void setCapa(BufferedImage capa) {
        this.capa = capa;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
