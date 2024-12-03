package model.dao.classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
      try{
      PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(SQL_SELECT);
      ps.setInt(1, categoria.getNumero());

      ResultSet rs = ps.executeQuery();

      // testa se tem algo em rs
      if(rs.next()) {
        categoria.setNumero(rs.getInt(1));
        categoria.setNome(rs.getString(2));
        
        return true;
      }
      return false;
      
    } catch(SQLException e) {
      System.out.println("Erro ao buscar. Exception: " + e.getMessage());
    }
    
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
