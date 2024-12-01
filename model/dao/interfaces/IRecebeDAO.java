package model.dao.interfaces;

public interface IRecebeDAO {
  
  String SQL_INSERT = "INSERT INTO Recebe (id_comentario, cod_documento) VALUES (?, ?)";
  // String SQL_ALTER = "UPDATE Recebe SET id_comentario = ?, SET cod_documento = ?, WHERE id_comentario = ? AND cod_documento = ?";
  String SQL_DELETE = "DELETE FROM Recebe WHERE id_comentario = ? AND cod_documento = ?";
  String SQL_SELECT = "SELECT * FROM Recebe WHERE id_comentario = ? AND cod_documento = ?";

  public boolean find();

  public boolean insert();
  
  public boolean remove();

  // public boolean update();

}
