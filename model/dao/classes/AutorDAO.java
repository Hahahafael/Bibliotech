package model.dao.classes;

import model.dao.interfaces.IAutorDAO;
import model.entities.Autor;

public class AutorDAO implements IAutorDAO{

  private Autor autor;

  public AutorDAO(Autor autor){
    this.autor = autor;
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
