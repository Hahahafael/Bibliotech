package model.dao.classes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.dao.interfaces.IMonografiaDAO;
import model.db.ConnectionFactory;
import model.entities.Monografia;

public class MonografiaDAO implements IMonografiaDAO {
  
  private Monografia monografia;

  public MonografiaDAO(Monografia monografia) {
    this.monografia = monografia;
  }

  @Override
  public boolean find() {
      return false;
  }

  @Override
  public boolean insert() {
      try{
        PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(SQL_INSERT);
        ps.setString(1, monografia.getOrientador());
        ps.setString(2, monografia.getInstituicao());
        ps.setString(3, monografia.getCodigo());

        //orientador, instituicao, cod_documento

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
