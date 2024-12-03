package model.dao.interfaces;

import java.io.IOException;

public interface IMonografiaDAO {

  String SQL_INSERT = "INSERT INTO Monografia (orientador, instituicao, cod_documento) VALUES (?, ?, ?)";
  String SQL_ALTER = "UPDATE Monografia SET orientador = ?, SET instituicao = ?, WHERE cod_documento = ?";
  String SQL_DELETE = "DELETE FROM Monografia WHERE cod_documento = ?";
  String SQL_SELECT = "SELECT * FROM Monografia WHERE cod_documento = ?";

  public boolean find() throws IOException;

  public boolean insert();
  
  public boolean remove();

  public boolean update();

}
