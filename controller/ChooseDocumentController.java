package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ChooseDocumentController {
  @FXML ImageView logoImage;

  private Stage window;
  private Scene scene;

  /**
   * returns a page based on the page the user is on
   * 
   * @param event the triggered event, usually a click on a button.
   * @throws IOException if an error occurs while loading the FXML file from the home screen.
   */
  public void returnPreviousPage(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/view/homeScreen.fxml"));
    window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    window.setScene(scene);
    window.show();
  }


  /**
   * Changes the current screen to the book registration screen.
   * 
   * @param event the triggered event, usually a click on a button.
   * @throws IOException if an error occurs while loading the FXML file from the book registration screen.
   */
  public void goToBookRegistrationScreen(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/view/bookRegistration.fxml"));
    window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    window.setScene(scene);
    window.show();
  }

  /**
   * Changes the current screen to the ebook registration screen.
   * 
   * @param event the triggered event, usually a click on a button.
   * @throws IOException if an error occurs while loading the FXML file from the ebook registration screen.
   */
  public void goToEbookRegistrationScreen(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/view/ebookRegistration.fxml"));
    window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    window.setScene(scene);
    window.show();
  }

  /**
   * Changes the current screen to the monograph registration screen.
   * 
   * @param event the triggered event, usually a click on a button.
   * @throws IOException if an error occurs while loading the FXML file from the monograph registration screen.
   */
  public void goToMonographRegistrationScreen(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/view/monographRegistration.fxml"));
    window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    window.setScene(scene);
    window.show();
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