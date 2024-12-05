package controller;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Session;  
import model.entities.Usuario;

public class AccountDetailsController {
    @FXML TextField nameAccountDatails;
    @FXML TextField loginAccountDatails;
    @FXML TextField emailAccountDatails;
    @FXML TextField passwordAccountDatails;
    @FXML TextField phoneAccountDatails;
    @FXML Label statusLabel;

    private Stage window;
    private Scene scene;

    /**
     * Method called to configure logged in user account details.
     * Fills in the text fields with user data.
     * @param event The event fired (usually a button click).
     * @throws IOException If an error occurs while loading the FXML file from the screen.
     */
    public void initialize() {
        Usuario usuarioLogado = Session.getUsuarioLogado();
        if (usuarioLogado != null) {
            nameAccountDatails.setText(usuarioLogado.getNome());
            loginAccountDatails.setText(usuarioLogado.getLogin());
            emailAccountDatails.setText(usuarioLogado.getEmail());
            phoneAccountDatails.setText(usuarioLogado.getTelefone());
            passwordAccountDatails.setText(usuarioLogado.getSenha());
            statusLabel.setText(usuarioLogado.getStatusDaConta());
        } else {
            System.out.println("Nenhum usuário logado!");
        }
    }

    /**
     * Returns to the previous screen (HomeScreen).
     * @param event The event fired (usually a button click).
     * @throws IOException If an error occurs while loading the FXML file from the screen.
     */
    public void returnPreviousPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/homeScreen.fxml"));
        window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }

    /**
     * Goes to the loan screen.
     * @param event The event fired (usually a button click).
     * @throws IOException If an error occurs while loading the FXML file from the screen.
     */
    public void goToLoanScreen(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/loanScreen.fxml"));
        window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }
}
