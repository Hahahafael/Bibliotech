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
     * Método chamado para configurar os detalhes da conta do usuário logado.
     * Preenche os campos de texto com os dados do usuário.
     * @param event O evento disparado (geralmente um clique em um botão).
     * @throws IOException Se ocorrer um erro ao carregar o arquivo FXML da tela.
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
     * Retorna para a tela anterior (HomeScreen).
     * @param event O evento disparado (geralmente um clique em um botão).
     * @throws IOException Se ocorrer um erro ao carregar o arquivo FXML da tela.
     */
    public void returnPreviousPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/homeScreen.fxml"));
        window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }

    /**
     * Vai para a tela de empréstimo.
     * @param event O evento disparado (geralmente um clique em um botão).
     * @throws IOException Se ocorrer um erro ao carregar o arquivo FXML da tela.
     */
    public void goToLoanScreen(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/loanScreen.fxml"));
        window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }
}
