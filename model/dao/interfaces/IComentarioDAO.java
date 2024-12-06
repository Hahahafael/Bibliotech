package model.dao.interfaces;

public interface IComentarioDAO {
  
  String SQL_INSERT = "INSERT INTO Comentario (data_comentario, texto, id_usuario, cod_documento) VALUES (?, ?, ?, ?)";
  String SQL_ALTER = "UPDATE Comentario SET data_comentario = ?, SET texto = ?, SET id_usuario = ? WHERE id_comentario = ?";
  String SQL_DELETE = "DELETE FROM Comentario WHERE id_comentario = ?";
  String SQL_SELECT = "SELECT * FROM Comentario WHERE id_comentario = ?";

  public boolean find();

  public boolean insert();
  
  public boolean remove();

  public boolean update();

}
