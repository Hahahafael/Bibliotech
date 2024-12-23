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

public class RegisterController {
    @FXML TextField NameRegister;
    @FXML TextField EmailRegister;
    @FXML TextField PhoneRegister;
    @FXML TextField PasswordRegister;
    @FXML TextField LoginRegister;
    @FXML Button RegisterButton;
    @FXML ImageView logoImage;

    private Stage window;
    private Scene scene;

   /**
   * go to login screen
   * @param event the triggered event, usually a click on a button.
   * @throws IOException if an error occurs while loading the FXML file from the home screen.
   */
    public void goToLoginScreen(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/login.fxml"));
        window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }

   /**
   * go to homeScreen page
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
   * put informations into database and after do login
   * @param event the triggered event, usually a click on a button.
   * @throws IOException if an error occurs while loading the FXML file from the home screen.
   */
    public void register(ActionEvent event) throws IOException {
        String nome = NameRegister.getText();
        String email = EmailRegister.getText();
        String telefone = PhoneRegister.getText();
        String senha = PasswordRegister.getText();
        String login = LoginRegister.getText();
        Usuario novoUsuario = new Usuario(nome, nome, email, telefone, senha);
        novoUsuario.setLogin(login);
        novoUsuario.setNome(nome);
        novoUsuario.setEmail(email); 
        novoUsuario.setTelefone(telefone);
        novoUsuario.setSenha(senha);
        novoUsuario.setMultaAcumulada(0); 
        novoUsuario.setStatusDaConta("Ativa"); 
        novoUsuario.setTipo("Aluno");
        UsuarioDAO usuarioDAO = new UsuarioDAO(novoUsuario);
        boolean resultado = usuarioDAO.insert();
        if (resultado) {
            System.out.println("Usuário registrado com sucesso!");
            Session.setUsuarioLogado(novoUsuario);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/homeScreen.fxml"));
            Parent root = loader.load();
            window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            window.setScene(scene);
            window.show();
        } else {
            System.out.println("Erro ao registrar usuário.");
        }
    }
}
