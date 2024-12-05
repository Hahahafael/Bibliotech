package model.dao.classes;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.dao.interfaces.IDocumentoDAO;
import model.db.ConnectionFactory;
import model.entities.*;

public class DocumentoDAO implements IDocumentoDAO {

  private Documento documento;

  public DocumentoDAO(Documento documento) {
    this.documento = documento;
  }

  @Override
  public boolean find() throws IOException {
    try {
      PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(SQL_SELECT);
      ps.setString(1, documento.getCodigo());

      ResultSet rs = ps.executeQuery();

      // testa se tem algo em rs
      if (rs.next()) {
        documento.setCodigo(rs.getString(1));
        documento.setTitulo(rs.getString(2));
        documento.setData(rs.getDate(4));
        documento.setNumPaginas(rs.getInt(5));
        documento.setIdioma(rs.getString(6));

        CategoriaDAO categoriaDocumento = new CategoriaDAO(new Categoria(rs.getInt(7)));
        categoriaDocumento.find();
        int numeroCategoria = categoriaDocumento.getCategoria().getNumero();
        String nomeCategoria = categoriaDocumento.getCategoria().getNome();
        documento.setCategoria(new Categoria(numeroCategoria, nomeCategoria));

        String tipo = rs.getString(10);
        switch (tipo.toLowerCase()) {
          case "livro":
            if (documento instanceof Livro) {
              Livro livro = (Livro) documento;
              livro.setEdicao(rs.getInt(7));
              livro.setEditora(rs.getString(6));
            }
            break;
          case "ebook":
            if (documento instanceof Ebook) {
              Ebook ebook = (Ebook) documento;
              ebook.setEdicao(rs.getInt(7));
              ebook.setEditora(rs.getString(6));
            }
            break;
          case "monografia":
            if (documento instanceof Monografia) {
              Monografia monografia = (Monografia) documento;
              monografia.setOrientador(rs.getString(8));
              monografia.setInstituicao(rs.getString(9));
            }
            break;
          default:
            System.out.println("Tipo de documento desconhecido: " + tipo);
            return false;
        }
        return true;
      }
      return false;

    } catch (SQLException e) {
      System.out.println("Erro ao buscar. Exception: " + e.getMessage());
    }
    return false;
  }

  @Override
  public boolean insert() throws IOException {
     try {
        PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(SQL_INSERT);
        ps.setString(1, documento.getCodigo());
        ps.setString(2, documento.getTitulo());
        ps.setDate(3, new java.sql.Date(documento.getData().getTime()));
        ps.setInt(4, documento.getNumPaginas());
        ps.setString(5, documento.getIdioma());
        ps.setInt(11, documento.getCategoria().getNumero());
      if (documento instanceof Livro) {
        Livro livro = (Livro) documento;
        ps.setString(6, livro.getEditora());
        ps.setInt(7, livro.getEdicao());
        ps.setNull(8, java.sql.Types.VARCHAR);
        ps.setNull(9, java.sql.Types.VARCHAR);
        ps.setString(10, "Livro");
      }
      ps.executeUpdate();
      return true;
    } catch (SQLException e) {
      System.out.println("Erro ao cadastrar documento. Exception: " + e.getMessage());
      return false;
    }
  }

  @Override
  public boolean remove() {
    return true;
  }

  @Override
  public boolean update() {
    return true;
  }

  public Documento getDocumento() {
    return this.documento;
  }

}
