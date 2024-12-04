package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.entities.Usuario;

public class AccountDetailsController {
  
  @FXML TextField nameAccountDatails;
  @FXML TextField loginAccountDatails;
  @FXML TextField emailAccountDatails;
  @FXML TextField passwordAccountDatails;
  @FXML TextField phoneAccountDatails;

  private Stage window;
  private Scene scene;

  // Método para receber e exibir as informações da conta logada
  public void setAccountDetails(Usuario usuario) {
      nameAccountDatails.setText(usuario.getNome());
      loginAccountDatails.setText(usuario.getLogin());
      emailAccountDatails.setText(usuario.getEmail());
      phoneAccountDatails.setText(usuario.getTelefone());
      passwordAccountDatails.setText(usuario.getSenha());
  }

  /**
   * returns a page based on the page the user is on
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
}
