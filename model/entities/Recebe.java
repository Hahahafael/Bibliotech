package model.entities;

public class Recebe {
    private Comentario comentario;
    private Documento documento;

    public Recebe(Comentario comentario, Documento documento) {
        this.comentario = comentario;
        this.documento = documento;
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }
}
