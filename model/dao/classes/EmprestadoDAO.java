package model.dao.classes;

import model.dao.interfaces.IEmprestadoDAO;
import model.entities.Emprestado;

public class EmprestadoDAO implements IEmprestadoDAO {

  private Emprestado emprestado;

  public EmprestadoDAO(Emprestado emprestado) {
    this.emprestado = emprestado;
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
