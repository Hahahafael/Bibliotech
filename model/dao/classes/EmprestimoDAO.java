package model.dao.classes;

import model.dao.interfaces.IEmprestimoDAO;
import model.entities.Emprestimo;

public class EmprestimoDAO implements IEmprestimoDAO {
  
  private Emprestimo emprestimo;

  public EmprestimoDAO(Emprestimo emprestimo) {
    this.emprestimo = emprestimo;
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
