package model.entities;

import java.text.DateFormat;

public class Comentario {
    private int id;
    private DateFormat data;
    private String texto;
    private Usuario usuario;

    public Comentario(int id, DateFormat data, String texto, Usuario usuario) {
        this.id = id;
        this.data = data;
        this.texto = texto;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DateFormat getData() {
        return data;
    }

    public void setData(DateFormat data) {
        this.data = data;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
