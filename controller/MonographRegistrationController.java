package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.dao.classes.MonografiaDAO;
import model.entities.Categoria;
import model.entities.Monografia;

public class MonographRegistrationController {
  @FXML TextField codeMonograph;
  @FXML TextField titleMonograph;
  @FXML TextField advisorMonograph;
  @FXML TextField institutionMonograph;
  @FXML TextField pageMonograph;
  @FXML TextField languageMonograph;
  @FXML TextField categoryMonograph;
  @FXML TextField categoryNumberMonograph;
  @FXML DatePicker yearOfPublicationMonograph; 
  @FXML Button registerButtonMonograph;

  @FXML Button addPhotoButtonMonographResgistration;

  private Stage window;
  private Scene scene;

  /**
   * returns a page based on the page the user is on
   * 
   * @param event the triggered event, usually a click on a button.
   * @throws IOException if an error occurs while loading the FXML file from the home screen.
   */
  public void returnPreviousPage(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/view/chooseDocument.fxml"));
    window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    window.setScene(scene);
    window.show();
  }

  

  /**
   * register the monograph
   * 
   * @param event the triggered event, usually a click on a button.
   * @throws IOException if an error occurs during file operations or while attempting to load resources 
   *                     (e.g., FXML files, external configurations) needed for the registration process.
   */
  public void registerMonograph(ActionEvent event) throws IOException {
    String codigo = codeMonograph.getText();
    String titulo = titleMonograph.getText();
    String orientador = advisorMonograph.getText();
    String instituicao = institutionMonograph.getText();
    int paginas = Integer.parseInt(pageMonograph.getText());
    String idioma = languageMonograph.getText();
    String categoria = categoryMonograph.getText();
    int numeroCategoria = Integer.parseInt(categoryNumberMonograph.getText());
    java.sql.Date anoDePublicacao = java.sql.Date.valueOf(yearOfPublicationMonograph.getValue());

    Categoria categoriaObj = new Categoria(numeroCategoria, categoria);
    Monografia monografia = new Monografia(codigo, titulo, anoDePublicacao, paginas, idioma, categoriaObj, orientador, instituicao);
    MonografiaDAO monografiaDAO = new MonografiaDAO(monografia);
    boolean resultado = monografiaDAO.insert();

    if (resultado) {
      System.out.println("Monografia registrada com sucesso!");
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/homeScreen.fxml"));
      Parent root = loader.load();
      window = (Stage) ((Node) event.getSource()).getScene().getWindow();
      scene = new Scene(root);
      window.setScene(scene);
      window.show();
    } else {
      System.out.println("Erro ao registrar monografia.");
    }
  }
}
