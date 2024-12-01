package model.dao.classes;

import model.dao.interfaces.IMonografiaDAO;
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
