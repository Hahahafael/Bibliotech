package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.dao.classes.UsuarioDAO;
import model.entities.Usuario;

public class LoginController {
  @FXML TextField loginTextField;
  @FXML TextField passwordLogin;
  @FXML Button loginButton;
  
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
  public void login(ActionEvent event) throws IOException {
    String login = loginTextField.getText();
    String senha = passwordLogin.getText();
    if (login.isEmpty() || senha.isEmpty()) {
        System.out.println("Por favor, preencha todos os campos!");
        return;
    }
    Usuario usuario = new Usuario(login, senha);
    UsuarioDAO usuarioDAO = new UsuarioDAO(usuario);
    boolean autenticado = usuarioDAO.findByLogin();
    if (autenticado) {
        System.out.println("Login realizado com sucesso!");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/homeScreen.fxml"));
        Parent root = loader.load();
        HomeScreenController homeScreenController = loader.getController();
        homeScreenController.setLoggedIn(true);  
        window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        window.setScene(scene);
        window.show();
    } else {
        System.out.println("Login ou senha inválidos.");
    }
  }

}
