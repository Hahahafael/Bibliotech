package model.dao.classes;

import model.dao.interfaces.IDocumentoDAO;
import model.entities.Documento;


public class DocumentoDAO implements IDocumentoDAO {
  
  private Documento documento;

  public DocumentoDAO(Documento documento) {
    this.documento = documento;
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
