package controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MonographRegistrationController {
  @FXML ImageView ImageViewMonographRegistration;

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
   * the "edite" button can chose a photo file in your PC
   * @param event the triggered event, usually a click on a button.
   * @throws IOException IOException if an error occurs while trying to access or read the selected file, 
   *                     or if the application encounters an issue while processing the file's URI.
   */
  public void selectImage(ActionEvent event) throws IOException {
    FileChooser fileChooser = new FileChooser();
    FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Imagens (JPG, PNG, GIF)", "*.jpg", "*.jpeg", "*.png", "*.gif");
    fileChooser.getExtensionFilters().add(imageFilter);
    File selectedFile = fileChooser.showOpenDialog(null);
    if (selectedFile != null) {
      Image image = new Image(selectedFile.toURI().toString());
      ImageViewMonographRegistration.setImage(image);
    }
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
    String paginas = pageMonograph.getText();
    String idioma = languageMonograph.getText();
    String categoria = categoryMonograph.getText();
    String numeroCategoria = categoryNumberMonograph.getText();
    LocalDate anoDePublicacao = yearOfPublicationMonograph.getValue();

     // Print values to the console for debugging
     System.out.println("Code: " + codigo);
     System.out.println("Title: " + titulo);
     System.out.println("Advisor: " + orientador);
     System.out.println("Institution: " + instituicao);
     System.out.println("Pages: " + paginas);
     System.out.println("Language: " + idioma);
     System.out.println("Category: " + categoria);
     System.out.println("Category Number: " + numeroCategoria);
     System.out.println("Year of Publication: " + anoDePublicacao);
  }
}
