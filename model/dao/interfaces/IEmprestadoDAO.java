package model.dao.interfaces;

public interface IEmprestadoDAO {
    
  String SQL_INSERT = "INSERT INTO Emprestado (cod_emprestimo, cod_documento) VALUES (?, ?)";
  // String SQL_ALTER = "UPDATE Emprestado SET cod_emprestimo = ?, SET cod_documento = ?, WHERE cod_emprestimo = ? AND cod_documento = ?";
  String SQL_DELETE = "DELETE FROM Emprestado WHERE cod_emprestimo = ? AND cod_documento = ?";
  String SQL_SELECT = "SELECT * FROM Emprestado WHERE cod_emprestimo = ? AND cod_documento = ?";

  public boolean find();

  public boolean insert();
  
  public boolean remove();

  // public boolean update();

}
