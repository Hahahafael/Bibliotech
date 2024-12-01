package model.dao.classes;

import model.dao.interfaces.IEscreveDAO;
import model.entities.Escreve;

public class EscreveDAO implements IEscreveDAO {

  private Escreve escreve;

  public EscreveDAO(Escreve escreve) {
    this.escreve = escreve;
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
