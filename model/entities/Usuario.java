package model.entities;

public class Usuario {
    private int id;
    private String nome;
    private String login;
    private String senha;
    private String email;
    private String telefone;
    private float multaAcumulada;
    private String statusDaConta;
    private String tipo;

    public Usuario(int id, String nome, String login, String senha, String email, String telefone, 
float multaAcumulada, String statusDaConta, String tipo) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.telefone = telefone;
        this.multaAcumulada = multaAcumulada;
        this.statusDaConta = statusDaConta;
        this.tipo = tipo;
    }

    public Usuario(String nome, String login, String senha, String email, String telefone) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.telefone = telefone;
    }

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Usuario(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public float getMultaAcumulada() {
        return multaAcumulada;
    }

    public void setMultaAcumulada(float multaAcumulada) {
        this.multaAcumulada = multaAcumulada;
    }

    public String getStatusDaConta() {
        return statusDaConta;
    }

    public void setStatusDaConta(String statusDaConta) {
        this.statusDaConta = statusDaConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
