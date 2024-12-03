package model.dao.classes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.dao.interfaces.ILivroDAO;
import model.db.ConnectionFactory;
import model.entities.Livro;

public class LivroDAO implements ILivroDAO {

  private Livro livro;

  public LivroDAO(Livro livro) {
    this.livro = livro;
  }

  @Override
  public boolean find() {
      return false;
  }

  @Override
  public boolean insert() {
      try{
        PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(SQL_INSERT);
        ps.setInt(1, livro.getEdicao());
        ps.setString(2, livro.getEditora());
        ps.setString(3, livro.getCodigo());

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
