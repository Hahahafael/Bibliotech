package model.dao.interfaces;

public interface IEmprestimoDAO {
  
  String SQL_INSERT = "INSERT INTO Emprestimo (data_retirada, data_devolucao, multa, status, quant_renovacao, id_usuario) VALUES (?, ?, ?, ?, ?, ?)";
  String SQL_ALTER = "UPDATE Emprestimo SET data_retirada = ?, SET data_devolucao = ?, SET multa = ?, SET status = ?, SET quant_renovacao = ?, SET id_usuario = ?, WHERE cod_emprestimo = ?";
  String SQL_DELETE = "DELETE FROM Emprestimo WHERE cod_emprestimo = ?";
  String SQL_SELECT = "SELECT * FROM Emprestimo WHERE cod_emprestimo = ?";

  public boolean find();

  public boolean insert();
  
  public boolean remove();

  public boolean update();

}
