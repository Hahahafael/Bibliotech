package model.dao.classes;

import model.dao.interfaces.IUsuarioDAO;
import model.entities.Usuario;
import model.db.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO implements IUsuarioDAO {

  private Usuario usuario;
  
  public UsuarioDAO(Usuario usuario) {
    this.usuario = usuario;    
  }

  @Override
  public boolean find() {
      return false;
  }

  @Override
  public boolean findByLogin(){
    try{
      PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(SQL_SELECT_BY_LOGIN);
      ps.setString(1, usuario.getLogin());
      ps.setString(2, usuario.getSenha());

      ResultSet rs = ps.executeQuery();

      // testa se tem algo em rs
      if(rs.next()) {
        usuario.setId(rs.getInt(1));
        usuario.setNome(rs.getString(2));
        usuario.setLogin(rs.getString(3));
        usuario.setSenha(rs.getString(4));
        usuario.setEmail(rs.getString(5));
        usuario.setTelefone(rs.getString(6));
        usuario.setMultaAcumulada(rs.getFloat(7));
        usuario.setStatusDaConta(rs.getString(8));
        usuario.setTipo(rs.getString(9));
        
        return true;
      }
      return false;
      
    } catch(SQLException e) {
      System.out.println("Erro ao buscar. Exception: " + e.getMessage());
    }
    
    return false;
  };

  @Override
  public boolean insert() {
      try{
        PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(SQL_INSERT);
        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getLogin());
        ps.setString(3, usuario.getSenha());
        ps.setString(4, usuario.getEmail());
        ps.setString(5, usuario.getTelefone());
        ps.setFloat(6, 0);
        ps.setString(7, "NULL");
        ps.setString(8, "NULL");

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
