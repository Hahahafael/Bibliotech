package model.entities;

public class Escreve {
    private Documento documento;
    private Autor autor;

    public Escreve(Documento documento, Autor autor) {
        this.documento = documento;
        this.autor = autor;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
