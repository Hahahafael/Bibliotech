package model.entities;

import java.text.DateFormat;

public class Emprestimo {
    private int id;
    private DateFormat dataRetirada;
    private DateFormat dataDevolucao;
    private String status;
    private int quantRenovacao;
    private Usuario usuario;
    private Documento documento;

    public Emprestimo(int id, DateFormat dataRetirada, DateFormat dataDevolucao, String status, int quantRenovacao, Usuario usuario, Documento documento) {
        this.id = id;
        this.dataRetirada = dataRetirada;
        this.dataDevolucao = dataDevolucao;
        this.status = status;
        this.quantRenovacao = quantRenovacao;
        this.usuario = usuario;
        this.documento = documento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DateFormat getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(DateFormat dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public DateFormat getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(DateFormat dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQuantRenovacao() {
        return quantRenovacao;
    }

    public void setQuantRenovacao(int quantRenovacao) {
        this.quantRenovacao = quantRenovacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }
}
