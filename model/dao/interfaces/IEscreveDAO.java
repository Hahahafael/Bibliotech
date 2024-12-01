package model.dao.interfaces;

public interface IEscreveDAO {
  
  String SQL_INSERT = "INSERT INTO Escreve (cod_documento, id_autor) VALUES (?, ?)";
  // String SQL_ALTER = "UPDATE Escreve SET cod_documento = ?, SET id_autor = ?, WHERE cod_documento = ? AND id_autor = ?";
  String SQL_DELETE = "DELETE FROM Escreve WHERE cod_documento = ? AND id_autor = ?";
  String SQL_SELECT = "SELECT * FROM Escreve WHERE cod_documento = ? AND id_autor = ?";

  public boolean find();

  public boolean insert();
  
  public boolean remove();

  // public boolean update();

}
