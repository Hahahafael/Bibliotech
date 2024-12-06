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
import model.Session;

public class HomeScreenController {
    @FXML Button goToLoginScreen;
    @FXML Button goToChooseDocumentScreen;
    @FXML Button goToMakeLoanScreen;
    @FXML ImageView imageViewHelp;
    @FXML Rectangle rectangleHelp;
    @FXML Button accountButton;

    private Stage window;
    private Scene scene;

    public void initialize() {
        if (Session.isUsuarioLogado()) {
            goToLoginScreen.setVisible(false);
            accountButton.setVisible(true);
            if (Session.getUsuarioLogado().getTipo().equals("Administrador")) {
                goToChooseDocumentScreen.setVisible(true);
                goToMakeLoanScreen.setVisible(true);
            }
        } 
    }

   /**
   * go to Login Screen
   * @param event the triggered event, usually a click on a button.
   * @throws IOException if an error occurs while loading the FXML file from the home screen.
   */
    public void goToLoginScreen(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/login.fxml"));
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
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
   * go to make loan screen
   * @param event the triggered event, usually a click on a button.
   * @throws IOException if an error occurs while loading the FXML file from the home screen.
   */
    public void goToMakeLoanScreen(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/makeLoanScreen.fxml"));
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
        window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }
}
