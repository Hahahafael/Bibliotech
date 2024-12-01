package model.dao.classes;

import model.dao.interfaces.IEbookDAO;
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
