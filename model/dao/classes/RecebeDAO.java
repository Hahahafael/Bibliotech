package model.dao.classes;

import model.dao.interfaces.IRecebeDAO;
import model.entities.Recebe;

public class RecebeDAO implements IRecebeDAO {
  
  private Recebe recebe;

  public RecebeDAO(Recebe recebe) {
    this.recebe = recebe;
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

  // @Override
  // public boolean update() {
  //     return true;
  // }

}
