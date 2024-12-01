package model.dao.interfaces;

public interface IMonografia {

  String SQL_INSERT = "INSERT INTO Monografia (orientador, instituicao, cod_documento) VALUES (?, ?, ?)";
  String SQL_ALTER = "UPDATE Monografia SET orientador = ?, SET instituicao = ?, WHERE cod_documento = ?";
  String SQL_DELETE = "DELETE FROM Monografia WHERE cod_documento = ?";
  String SQL_SELECT = "SELECT * FROM Monografia WHERE cod_documento = ?";

  public boolean find();

  public boolean insert();
  
  public boolean remove();

  public boolean update();

}
