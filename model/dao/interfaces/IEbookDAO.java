package model.dao.interfaces;

import java.io.IOException;

public interface IEbookDAO {
  
  String SQL_INSERT = "INSERT INTO Ebook (edicao, editora, cod_documento) VALUES (?, ?, ?)";
  String SQL_ALTER = "UPDATE Ebook SET edicao = ?, SET editora = ?, WHERE cod_documento = ?";
  String SQL_DELETE = "DELETE FROM Ebook WHERE cod_documento = ?";
  String SQL_SELECT = "SELECT * FROM Ebook WHERE cod_documento = ?";

  public boolean find() throws IOException;

  public boolean insert();
  
  public boolean remove();

  public boolean update();

}
