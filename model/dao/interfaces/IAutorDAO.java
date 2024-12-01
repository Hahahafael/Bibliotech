package model.dao.interfaces;

public interface IAutorDAO {

  String SQL_INSERT = "INSERT INTO Autor (nome) VALUES (?)";
  String SQL_ALTER = "UPDATE Autor SET nome = ?, WHERE id_autor = ?";
  String SQL_DELETE = "DELETE FROM Autor WHERE id_autor = ?";
  String SQL_SELECT = "SELECT * FROM Autor WHERE id_autor = ?";

  public boolean find();

  public boolean insert();
  
  public boolean remove();

  public boolean update();

}
