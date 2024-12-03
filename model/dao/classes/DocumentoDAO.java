package model.dao.classes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.imageio.ImageIO;

import model.dao.interfaces.IDocumentoDAO;
import model.db.ConnectionFactory;
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
  public boolean insert() throws IOException {
    
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ImageIO.write(documento.getCapa(), "png", baos);
    byte[] imagemEmBytes = baos.toByteArray();

    java.sql.Date sqlDate = new java.sql.Date(documento.getData().getTime());

      try{
        PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(SQL_INSERT);
        ps.setString(1, documento.getCodigo());
        ps.setString(2, documento.getTitulo());
        ps.setBytes(3, imagemEmBytes);
        ps.setDate(4, sqlDate);
        ps.setInt(5, documento.getNumPaginas());
        ps.setString(6, documento.getIdioma());
        ps.setInt(7, documento.getCategoria().getNumero());

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
