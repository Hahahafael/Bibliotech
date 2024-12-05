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
import model.dao.classes.DocumentoDAO;
import model.dao.classes.LivroDAO;
import model.entities.Categoria;
import model.entities.Documento;
import model.entities.Livro;

public class BookRegistrationController {
  @FXML Button addPhotoButtonBookResgistration;
  @FXML TextField codeBookRegistration;
  @FXML TextField titleBookRegistration;
  @FXML TextField publisherBookRegistration;
  @FXML TextField editionBookRegistration;
  @FXML TextField pagesBookRegistration;
  @FXML TextField languageBookRegistration;
  @FXML TextField categoryBookRegistration;
  @FXML TextField categoryNumberBookRegistration;
  @FXML Button buttonBookRegistration;
  @FXML DatePicker dateBookRegistration;

  private Stage window;
  private Scene scene;

  /**
   * returns a page based on the page the user is on
   * 
   * @param event the triggered event, usually a click on a button.
   * @throws IOException if an error occurs while loading the FXML file from the
   *                     home screen.
   */
  public void returnPreviousPage(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/view/chooseDocument.fxml"));
    window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    window.setScene(scene);
    window.show();
  }

  /**
   * Registers a book in the system.
   * 
   * @param event the triggered event, usually a click on a button.
   * @throws IOException if an error occurs while loading the FXML file from the
   *                     home screen.
   */
  public void registerBook(ActionEvent event) throws IOException {
    String code = codeBookRegistration.getText();
    String title = titleBookRegistration.getText();
    String publisher = publisherBookRegistration.getText();
    int edition = Integer.parseInt(editionBookRegistration.getText());
    int pages = Integer.parseInt(pagesBookRegistration.getText());
    String language = languageBookRegistration.getText();
    String category = categoryBookRegistration.getText();
    int categoryNumber = Integer.parseInt(categoryNumberBookRegistration.getText());
    java.sql.Date date = java.sql.Date.valueOf(dateBookRegistration.getValue()); 
    Categoria categoria = new Categoria(categoryNumber, category);
    Documento documentoLivro = new Documento(code, title, date, pages, language, categoria);
    DocumentoDAO documentoLivroDAO = new DocumentoDAO(documentoLivro);
    boolean resultadoDocumento = documentoLivroDAO.insert();
    Livro livro = new Livro(code, publisher, edition);
    LivroDAO livroDAO = new LivroDAO(livro);
    boolean resultado = livroDAO.insert();
    if (resultado) {
      boolean resultadoLivro = livroDAO.insert();
      if (resultadoDocumento && resultadoLivro) {
        System.out.println("Livro registrado com sucesso!");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/homeScreen.fxml"));
        Parent root = loader.load();
        window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        window.setScene(scene);
        window.show();
      } else {
        System.out.println("Erro ao registrar livro.");
      }
    }
  }

}