package model.dao.interfaces;

public interface ICategoriaDAO {
  
  String SQL_INSERT = "INSERT INTO Categoria (numero, nome) VALUES (?, ?)";
  String SQL_ALTER = "UPDATE Categoria SET nome = ?, WHERE numero = ?";
  String SQL_DELETE = "DELETE FROM Categoria WHERE numero = ?";
  String SQL_SELECT = "SELECT * FROM Categoria WHERE numero = ?";

  public boolean find();

  public boolean insert();
  
  public boolean remove();

  public boolean update();

}
