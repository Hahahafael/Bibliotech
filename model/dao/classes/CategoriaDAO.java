package model.dao.classes;

import model.dao.interfaces.ICategoriaDAO;
import model.entities.Categoria;

public class CategoriaDAO implements ICategoriaDAO{
  
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
