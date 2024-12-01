package model.dao.interfaces;

public interface IComentarioDAO {
  
  String SQL_INSERT = "INSERT INTO Comentario (id_comentario, data_comentario, texto, id_usuario) VALUES (?, ?, ?, ?)";
  String SQL_ALTER = "UPDATE Comentario SET data_comentario = ?, SET texto = ?, SET id_usuario = ? WHERE id_usuario = ?";
  String SQL_DELETE = "DELETE FROM Comentario WHERE id_usuario = ?";
  String SQL_SELECT = "SELECT * FROM Comentario WHERE id_usuario = ?";

  public boolean find();

  public boolean insert();
  
  public boolean remove();

  public boolean update();

}
