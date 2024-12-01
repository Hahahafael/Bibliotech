package model.entities;

import java.awt.image.BufferedImage;
import java.text.DateFormat;

public class Monografia extends Documento{
    private String orientador;
    private String instituicao;

    // Construtor
    public Monografia(String codigo, String titulo, DateFormat data, BufferedImage capa, int numPaginas, String idioma, Categoria categoria, String orientador, String instituicao) {
        super(codigo, titulo, data, capa, numPaginas, idioma, categoria);
        this.orientador = orientador;
        this.instituicao = instituicao;
    }

    // Getters e setters
    public String getOrientador() {
        return orientador;
    }

    public void setOrientador(String orientador) {
        this.orientador = orientador;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

}
