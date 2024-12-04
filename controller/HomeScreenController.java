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
import model.entities.Usuario;

public class HomeScreenController {
    @FXML Button goToLoginScreen;
    @FXML ImageView imageViewHelp;
    @FXML Rectangle rectangleHelp;
    @FXML Button accountButton;

    private Stage window;
    private Scene scene;
    private boolean isLoggedIn = false;
    
    // Variável global para armazenar o usuário logado
    private Usuario usuarioLogado;

    // Método para configurar o usuário logado
    public void setUsuarioLogado(Usuario usuario) {
        this.usuarioLogado = usuario;
        setLoggedIn(true);
    }

    // Método para atualizar a visibilidade do botão de login
    public void setLoggedIn(boolean loggedIn) {
        this.isLoggedIn = loggedIn;
        updateLoginButtonVisibility(); 
    }

    // Atualiza a visibilidade do botão de login
    private void updateLoginButtonVisibility() {
        if (isLoggedIn) {
            goToLoginScreen.setVisible(false);  
            accountButton.setVisible(true);
        } else {
            goToLoginScreen.setVisible(true); 
            accountButton.setVisible(false);
        }
    }

    // Redireciona para a tela de login
    public void goToLoginScreen(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/login.fxml"));
        window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }

    // Redireciona para a tela de documentos
    public void goToChooseDocumentScreen(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/chooseDocument.fxml"));
        window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }

    // Função para mostrar a ajuda
    public void showHelpRectangle(ActionEvent event) throws IOException {
        rectangleHelp.setVisible(!rectangleHelp.isVisible());
        imageViewHelp.setVisible(!imageViewHelp.isVisible());
    }

    // Redireciona para a tela da conta
    public void goToAccountScreen(ActionEvent event) throws IOException {
        // Carregar a tela de AccountDetails
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/accountDetails.fxml"));
        Parent root = loader.load();
        
        // Obter o controlador de AccountDetails
        AccountDetailsController accountDetailsController = loader.getController();
        
        // Passar o usuário logado para a tela de detalhes
        accountDetailsController.setAccountDetails(usuarioLogado);  // Método que vamos criar na próxima etapa
    
        // Mostrar a nova tela
        window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }
}
