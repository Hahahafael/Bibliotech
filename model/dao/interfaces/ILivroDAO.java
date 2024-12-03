package model.dao.interfaces;

import java.io.IOException;

public interface ILivroDAO {
  
  String SQL_INSERT = "INSERT INTO Livro (edicao, editora, cod_documento) VALUES (?, ?, ?)";
  String SQL_ALTER = "UPDATE Livro SET edicao = ?, SET editora = ?, WHERE cod_documento = ?";
  String SQL_DELETE = "DELETE FROM Livro WHERE cod_documento = ?";
  String SQL_SELECT = "SELECT * FROM Livro WHERE cod_documento = ?";

  public boolean find() throws IOException;

  public boolean insert();
  
  public boolean remove();

  public boolean update();

}
