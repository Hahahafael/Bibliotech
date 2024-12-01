package model.entities;

public class Emprestado {
    private Emprestimo emprestimo;
    private Livro livro;

    // Construtor
    public Emprestado(Emprestimo emprestimo, Livro livro) {
        this.emprestimo = emprestimo;
        this.livro = livro;
    }

    // Getters e setters
    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
