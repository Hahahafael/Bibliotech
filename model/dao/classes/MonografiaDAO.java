package model.dao.classes;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.interfaces.IMonografiaDAO;
import model.db.ConnectionFactory;
import model.entities.Documento;
import model.entities.Monografia;

public class MonografiaDAO implements IMonografiaDAO {
  
  private Monografia monografia;

  public MonografiaDAO(Monografia monografia) {
    this.monografia = monografia;
  }

  @Override
  public boolean find() throws IOException {
      try{
      PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(SQL_SELECT);
      ps.setString(1, monografia.getCodigo());

      ResultSet rs = ps.executeQuery();

      // testa se tem algo em rs
      if(rs.next()) {
        monografia.setOrientador(rs.getString(1));
        monografia.setInstituicao(rs.getString(2));
        monografia.setCodigo(rs.getString(3));
        DocumentoDAO documentoMonografia= new DocumentoDAO(new Documento(monografia.getCodigo()));
        documentoMonografia.find();
        monografia.setTitulo(documentoMonografia.getDocumento().getTitulo());
        monografia.setData(documentoMonografia.getDocumento().getData());
        monografia.setCapa(documentoMonografia.getDocumento().getCapa());
        monografia.setNumPaginas(documentoMonografia.getDocumento().getNumPaginas());
        monografia.setIdioma(documentoMonografia.getDocumento().getIdioma());
        monografia.setCategoria(documentoMonografia.getDocumento().getCategoria());
        
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
        ps.setString(1, monografia.getOrientador());
        ps.setString(2, monografia.getInstituicao());
        ps.setString(3, monografia.getCodigo());

        //orientador, instituicao, cod_documento

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
