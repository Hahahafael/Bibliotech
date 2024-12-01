package model.dao.classes;

import model.dao.interfaces.IComentarioDAO;
import model.entities.Comentario;

public class ComentarioDAO implements IComentarioDAO {

  private Comentario comentario;

  public ComentarioDAO(Comentario comentario) {
    this.comentario = comentario;
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
