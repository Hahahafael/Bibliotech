package model.dao.classes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.dao.interfaces.IEbookDAO;
import model.db.ConnectionFactory;
import model.entities.Ebook;

public class EbookDAO implements IEbookDAO{

  private Ebook ebook;

  public EbookDAO(Ebook ebook) {
    this.ebook = ebook;
  }
  
  @Override
  public boolean find() {
      return false;
  }

  @Override
  public boolean insert() {
    try{
        PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(SQL_INSERT);
        ps.setInt(1, ebook.getEdicao());
        ps.setString(2, ebook.getEditora());
        ps.setString(3, ebook.getCodigo());

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
