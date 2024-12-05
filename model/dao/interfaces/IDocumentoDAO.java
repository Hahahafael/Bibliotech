package model.dao.interfaces;

import java.io.IOException;

public interface IDocumentoDAO {
  
  String SQL_INSERT_EBOOK_BOOK = "INSERT INTO Documento (cod_documento, titulo, data_publicacao, num_paginas, idioma, editora, edicao, tipo_documento, num_categoria) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
  String SQL_INSERT_MONOGRAPH = "INSERT INTO Documento (cod_documento, titulo, data_publicacao, num_paginas, idioma, orientador, instituicao, tipo_documento, num_categoria) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
  String SQL_ALTER = "UPDATE Documento SET titulo = ?, SET data_publicacao = ?, SET num_paginas = ?, SET idioma = ? SET num_categoria = ?, WHERE cod_documento = ?";
  String SQL_DELETE = "DELETE FROM Documento WHERE cod_documento = ?";
  String SQL_SELECT = "SELECT * FROM Documento WHERE cod_documento = ?";

  public boolean find() throws IOException;

  public boolean insertBookAndEbook() throws IOException;

  public boolean insertMonograph() throws IOException;
  
  public boolean remove();

  public boolean update();

}
