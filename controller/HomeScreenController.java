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
    private Usuario usuarioLogado;

   /**
   * Turn usuario to logged
   * @param event the triggered event, usually a click on a button.
   * @throws IOException if an error occurs while loading the FXML file from the home screen.
   */
    public void setUsuarioLogado(Usuario usuario) {
        this.usuarioLogado = usuario;
        setLoggedIn(true);
    }

   /**
   * Change to logged and call the updateLoginButtonVisibility function
   * @param event the triggered event, usually a click on a button.
   * @throws IOException if an error occurs while loading the FXML file from the home screen.
   */
    public void setLoggedIn(boolean loggedIn) {
        this.isLoggedIn = loggedIn;
        updateLoginButtonVisibility(); 
    }

   /**
   * update the loginButton and the accountButton visibility
   * @param event the triggered event, usually a click on a button.
   * @throws IOException if an error occurs while loading the FXML file from the home screen.
   */
    private void updateLoginButtonVisibility() {
        if (isLoggedIn) {
            goToLoginScreen.setVisible(false);  
            accountButton.setVisible(true);
        } else {
            goToLoginScreen.setVisible(true); 
            accountButton.setVisible(false);
        }
    }

   /**
   * go to Login Screen
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
   * go to ChooseDocument screen
   * @param event the triggered event, usually a click on a button.
   * @throws IOException if an error occurs while loading the FXML file from the home screen.
   */
    public void goToChooseDocumentScreen(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/chooseDocument.fxml"));
        window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }

   /**
   * Show the help instructions
   * @param event the triggered event, usually a click on a button.
   * @throws IOException if an error occurs while loading the FXML file from the home screen.
   */
    public void showHelpRectangle(ActionEvent event) throws IOException {
        rectangleHelp.setVisible(!rectangleHelp.isVisible());
        imageViewHelp.setVisible(!imageViewHelp.isVisible());
    }

   /**
   * go to AccountDetails screen
   * @param event the triggered event, usually a click on a button.
   * @throws IOException if an error occurs while loading the FXML file from the home screen.
   */
    public void goToAccountScreen(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/accountDetails.fxml"));
        Parent root = loader.load();
        AccountDetailsController accountDetailsController = loader.getController();
        accountDetailsController.setAccountDetails(usuarioLogado); 
        window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }
}
