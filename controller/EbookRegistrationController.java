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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.dao.classes.DocumentoDAO;
import model.entities.Categoria;
import model.entities.Ebook;


public class EbookRegistrationController {
  @FXML ImageView ImageViewEBookRegistration;
  @FXML ImageView logoImage;
  @FXML TextField codeEbookRegistration;
  @FXML TextField titleEbookRegistration;
  @FXML TextField publisherEbookRegistration;
  @FXML TextField editionEbookRegistration;
  @FXML TextField pagesEbookRegistration;
  @FXML TextField languageEbookRegistration;
  @FXML TextField categoryEbookRegistration;
  @FXML TextField categoryNumberEbookRegistration;
  @FXML DatePicker dateEbookRegistration;
  @FXML Button registerButtonEbook;
  @FXML Button addPhotoButtonEBookResgistration;
  @FXML Button searchFileButtonEbook;

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
   * Search for the ebook file on your computer
   * @param event the triggered event, usually a click on a button.
   * @throws IOException IOException if an error occurs while trying to access or read the selected file, 
   *                     or if the application encounters an issue while processing the file's URI.
   */
  public void searchFileEbook(ActionEvent event) throws IOException {
    System.out.println("botao de procurar arquivo");
  }


  /**
   * register the e-book
   * 
   * @param event the triggered event, usually a click on a button.
   * @throws IOException if an error occurs during file operations or while attempting to load resources 
   *                     (e.g., FXML files, external configurations) needed for the registration process.
   */
  public void registerEbook(ActionEvent event) throws IOException {
    try {
      String code = codeEbookRegistration.getText();
      String title = titleEbookRegistration.getText();
      String publisher = publisherEbookRegistration.getText();
      int edition = Integer.parseInt(editionEbookRegistration.getText());
      int pages = Integer.parseInt(pagesEbookRegistration.getText());
      String language = languageEbookRegistration.getText();
      String category = categoryEbookRegistration.getText();
      int categoryNumber = Integer.parseInt(categoryNumberEbookRegistration.getText());
      java.sql.Date date = java.sql.Date.valueOf(dateEbookRegistration.getValue());
  
      Categoria categoria = new Categoria(categoryNumber, category);
      Ebook ebook = new Ebook(code, title, date, pages, language, categoria, publisher, edition);
      DocumentoDAO documentoDAO = new DocumentoDAO(ebook);
      boolean resultado = documentoDAO.insertBookAndEbook();
  
      if(resultado) {
        System.out.println("E-book registrado com sucesso!");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/chooseDocument.fxml"));
        Parent root = loader.load();
        window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        window.setScene(scene);
        window.show();
      }else {
        System.out.println("Erro ao registrar o e-book.");
      }
      
    } catch (NumberFormatException e) {
      System.out.println("Erro: Verifique os valores numéricos inseridos.");
    } catch (Exception e) {
      System.out.println("Erro ao registrar o e-book. Exception: " + e.getMessage());
    }
  }

  /**
  * Navigates to the home screen when the logo is clicked.
  * 
  * @param event the event triggered by clicking the logo image.
  * @throws IOException if an error occurs while loading the FXML file for the home screen.
  */
  public void goToHomeScreen(MouseEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/view/homeScreen.fxml")); 
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }
 }