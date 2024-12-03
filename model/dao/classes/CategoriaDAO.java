package model.dao.classes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.dao.interfaces.ICategoriaDAO;
import model.db.ConnectionFactory;
import model.entities.Categoria;

public class CategoriaDAO implements ICategoriaDAO {
  
  private Categoria categoria;

  public CategoriaDAO(Categoria categoria){
    this.categoria = categoria;
  }

  @Override
  public boolean find() {
      return false;
  }

  @Override
  public boolean insert() {
     try{
        PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(SQL_INSERT);
        ps.setInt(1, categoria.getNumero());
        ps.setString(2, categoria.getNome());

        ps.executeUpdate();

        return true;

      }catch (SQLException e){
        System.out.println("Erro ao cadastrar. Exception: " + e.getMessage());
      }
      return false;
  }

  @Override
  public boolean remove() {
      return true;
  }

  @Override
  public boolean update() {
      return true;
  }

}
