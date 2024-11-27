package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginController {
  
  private Stage window;
  private Scene scene;

  /**
   * Changes the current screen to the register screen.
   * 
   * @param event the triggered event, usually a click on a button.
   * @throws IOException if an error occurs while loading the FXML file from the login screen.
   */
  public void goToRegisterScreen(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/view/register.fxml"));
    window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    window.setScene(scene);
    window.show();
  }

  /**
   * Changes the current screen to the home screen.
   * 
   * @param event the triggered event, usually a click on a button.
   * @throws IOException if an error occurs while loading the FXML file from the login screen.
   */
  public void goToHomeScreen(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/view/homeScreen.fxml"));
    window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    window.setScene(scene);
    window.show();
  }

}