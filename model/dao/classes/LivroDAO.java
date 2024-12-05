package model.dao.classes;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.interfaces.ILivroDAO;
import model.db.ConnectionFactory;
import model.entities.Documento;
import model.entities.Livro;

public class LivroDAO implements ILivroDAO {

  private Livro livro;

  public LivroDAO(Livro livro) {
    this.livro = livro;
  }

  @Override
  public boolean find() throws IOException {
      try{
      PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(SQL_SELECT);
      ps.setString(1, livro.getCodigo());

      ResultSet rs = ps.executeQuery();

      // testa se tem algo em rs
      if(rs.next()) {
        livro.setEdicao(rs.getInt(1));
        livro.setEditora(rs.getString(2));
        livro.setCodigo(rs.getString(3));
        DocumentoDAO documentoLivro= new DocumentoDAO(new Documento(livro.getCodigo()));
        documentoLivro.find();
        livro.setTitulo(documentoLivro.getDocumento().getTitulo());
        livro.setData(documentoLivro.getDocumento().getData());
        livro.setNumPaginas(documentoLivro.getDocumento().getNumPaginas());
        livro.setIdioma(documentoLivro.getDocumento().getIdioma());
        livro.setCategoria(documentoLivro.getDocumento().getCategoria());
        
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
        ps.setInt(1, livro.getEdicao());
        ps.setString(2, livro.getEditora());
        ps.setString(3, livro.getCodigo());

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
