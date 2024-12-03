package model.dao.classes;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.interfaces.IEbookDAO;
import model.db.ConnectionFactory;
import model.entities.Categoria;
import model.entities.Documento;
import model.entities.Ebook;

public class EbookDAO implements IEbookDAO{

  private Ebook ebook;

  public EbookDAO(Ebook ebook) {
    this.ebook = ebook;
  }
  
  @Override
  public boolean find() throws IOException {
      try{
      PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(SQL_SELECT);
      ps.setString(1, ebook.getCodigo());

      ResultSet rs = ps.executeQuery();

      // testa se tem algo em rs
      if(rs.next()) {
        ebook.setEditora(rs.getString(1));
        ebook.setEdicao(rs.getInt(2));
        ebook.setCodigo(rs.getString(3));
        DocumentoDAO documentoEbook = new DocumentoDAO(new Documento(ebook.getCodigo()));
        documentoEbook.find();
        ebook.setTitulo(documentoEbook.getDocumento().getTitulo());
        ebook.setData(documentoEbook.getDocumento().getData());
        ebook.setCapa(documentoEbook.getDocumento().getCapa());
        ebook.setNumPaginas(documentoEbook.getDocumento().getNumPaginas());
        ebook.setIdioma(documentoEbook.getDocumento().getIdioma());
        ebook.setCategoria(documentoEbook.getDocumento().getCategoria());
        
        return true;
      }
      return false;
      
    } catch(SQLException e) {
      System.out.println("Erro ao buscar. Exception: " + e.getMessage());
    }
    
    return false;
  }

  @Override
  public boolean insert() {
    try{
        PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(SQL_INSERT);
        ps.setInt(1, ebook.getEdicao());
        ps.setString(2, ebook.getEditora());
        ps.setString(3, ebook.getCodigo());

        ps.executeUpdate();

        return true;

      }catch (SQLException e){
        System.out.println("Erro ao cadastrar. Exception: " + e.getMessage());
      }
      return false;
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
