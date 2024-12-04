package controller;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class EbookRegistrationController {
  @FXML ImageView ImageViewEBookRegistration;
  @FXML Button addPhotoButtonEBookResgistration;
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
   * @throws IOException if an error occurs while loading the FXML file from the home screen.
   */
  public void selectImage(ActionEvent event) throws IOException {
    FileChooser fileChooser = new FileChooser();
    FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Imagens (JPG, PNG, GIF)", "*.jpg", "*.jpeg", "*.png", "*.gif");
    fileChooser.getExtensionFilters().add(imageFilter);
    File selectedFile = fileChooser.showOpenDialog(null);
    if (selectedFile != null) {
      Image image = new Image(selectedFile.toURI().toString());
      ImageViewEBookRegistration.setImage(image);
    }
  }
}