package model.dao.classes;

import model.dao.interfaces.ILivroDAO;
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
