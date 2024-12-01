package model.dao.classes;

import model.dao.interfaces.IUsuarioDAO;
import model.entities.Usuario;

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
  public boolean insert() {
      return true;
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
