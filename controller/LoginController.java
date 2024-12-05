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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Session;
import model.dao.classes.UsuarioDAO;
import model.entities.Usuario;

public class LoginController {
    @FXML TextField loginTextField;
    @FXML TextField passwordLogin;
    @FXML Button loginButton;
    @FXML ImageView logoImage;

    private Stage window;
    private Scene scene;

   /**
   * go to register screen
   * @param event the triggered event, usually a click on a button.
   * @throws IOException if an error occurs while loading the FXML file from the home screen.
   */
    public void goToRegisterScreen(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/register.fxml"));
        window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }

   /**
   * return to homeScreen 
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

    /**
    * Do almost all of login feature
    * @param event the triggered event, usually a click on a button.
    * @throws IOException if an error occurs while loading the FXML file from the home screen.
    */
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
            Session.setUsuarioLogado(usuario);
            System.out.println("Login realizado com sucesso!");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/homeScreen.fxml"));
            Parent root = loader.load();
            window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            window.setScene(scene);
            window.show();
        } else {
            System.out.println("Login ou senha inválidos.");
        }
    }
}
