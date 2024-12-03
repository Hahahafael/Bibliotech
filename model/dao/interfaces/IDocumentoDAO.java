package model.dao.interfaces;

import java.io.IOException;

public interface IDocumentoDAO {
  
  String SQL_INSERT = "INSERT INTO Documento (cod_documento, titulo, capa, data_publicacao, num_paginas, idioma, num_categoria) VALUES (?, ?, ?, ?, ?, ?, ?)";
  String SQL_ALTER = "UPDATE Documento SET titulo = ?, SET capa = ?, SET data_publicacao = ?, SET num_paginas = ?, SET idioma = ? SET num_categoria = ?, WHERE cod_documento = ?";
  String SQL_DELETE = "DELETE FROM Documento WHERE cod_documento = ?";
  String SQL_SELECT = "SELECT * FROM Documento WHERE cod_documento = ?";

  public boolean find();

  public boolean insert() throws IOException;
  
  public boolean remove();

  public boolean update();

}
