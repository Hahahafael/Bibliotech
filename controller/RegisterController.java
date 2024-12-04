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

public class RegisterController {
    @FXML TextField NameRegister;
    @FXML TextField EmailRegister;
    @FXML TextField PhoneRegister;
    @FXML TextField PasswordRegister;
    @FXML Button RegisterButton;

    private Stage window;
    private Scene scene;

    // Função para registrar um novo usuário
    public void goToLoginScreen(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/login.fxml"));
        window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }

    // Função para retornar à tela inicial
    public void returnPreviousPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/homeScreen.fxml"));
        window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }

    // Função de registro
    public void register(ActionEvent event) throws IOException {
        String nome = NameRegister.getText();
        String email = EmailRegister.getText();
        String telefone = PhoneRegister.getText();
        String senha = PasswordRegister.getText();
        Usuario novoUsuario = new Usuario(nome, nome, email, telefone, senha);
        novoUsuario.setLogin(email);
        novoUsuario.setNome(nome);
        novoUsuario.setEmail(email); 
        novoUsuario.setTelefone(telefone);
        novoUsuario.setSenha(senha);
        novoUsuario.setMultaAcumulada(0); 
        novoUsuario.setStatusDaConta("Ativa"); 
        novoUsuario.setTipo("Aluno");

        // Registrar o novo usuário no banco de dados
        UsuarioDAO usuarioDAO = new UsuarioDAO(novoUsuario);
        boolean resultado = usuarioDAO.insert();

        if (resultado) {
            System.out.println("Usuário registrado com sucesso!");

            // Login automático após o registro
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/homeScreen.fxml"));
            Parent root = loader.load();
            HomeScreenController homeScreenController = loader.getController();
            
            // Passar o usuário logado para a tela inicial
            homeScreenController.setUsuarioLogado(novoUsuario);

            window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            window.setScene(scene);
            window.show();
        } else {
            System.out.println("Erro ao registrar usuário.");
        }
    }
}
