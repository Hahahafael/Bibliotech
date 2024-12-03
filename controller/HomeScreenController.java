package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class HomeScreenController {
  @FXML Button goToLoginScreen;
  @FXML ImageView imageViewHelp;
  @FXML Rectangle rectangleHelp;

  private Stage window;
  private Scene scene;


  /**
   * Changes the current screen to the login screen.
   * 
   * @param event the triggered event, usually a click on a button.
   * @throws IOException if an error occurs while loading the FXML file from the login screen.
   */
  public void goToLoginScreen(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/view/login.fxml"));
    window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    window.setScene(scene);
    window.show();
  }

  /**
   * Changes the current screen to the choose document screen.
   * 
   * @param event the triggered event, usually a click on a button.
   * @throws IOException if an error occurs while loading the FXML file from the choose document screen.
   */
  public void goToChooseDocumentScreen(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/view/chooseDocument.fxml"));
    window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    window.setScene(scene);
    window.show();
  }

  public void showHelpRectangle(ActionEvent event) throws IOException{
    rectangleHelp.setVisible(!rectangleHelp.isVisible());
    imageViewHelp.setVisible(!imageViewHelp.isVisible());
  }

}
