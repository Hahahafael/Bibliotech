package model.dao.interfaces;

public interface ICategoria {
  
  String SQL_INSERT = "INSERT INTO Categoria (id, nome) VALUES (?, ?)";
  String SQL_ALTER = "UPDATE Categoria SET nome = ?, WHERE id = ?";
  String SQL_DELETE = "DELETE FROM Categoria WHERE id = ?";
  String SQL_SELECT = "SELECT * FROM Categoria WHERE id = ?";

  public boolean find();

  public boolean insert();
  
  public boolean remove();

  public boolean update();

}
