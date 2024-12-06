package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.dao.classes.DocumentoDAO;
import model.dao.classes.EmprestadoDAO;
import model.dao.classes.EmprestimoDAO;
import model.dao.classes.UsuarioDAO;
import model.entities.Documento;
import model.entities.Emprestado;
import model.entities.Emprestimo;
import model.entities.Usuario;

public class MakeLoanController {
  @FXML TextField loginUserLoan;
  @FXML TextField titleBookLoan;
  @FXML Label statusField;
  @FXML Button makeLoanButton;


  private Stage window;
  private Scene scene;

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
   * make loan
   * @param event the triggered event, usually a click on a button.
   * @throws IOException if an error occurs while loading the FXML file from the home screen.
   */
  public void makeLoan(ActionEvent event) throws IOException {
  }

  /**
   * seach user in loan
   * @param event the triggered event, usually a click on a button.
   * @throws IOException if an error occurs while loading the FXML file from the home screen.
   */
  public void seachUserLoan(ActionEvent event) throws IOException {
    String loginUser = loginUserLoan.getText();
    Usuario usuario = new Usuario(loginUser); 
    UsuarioDAO usuarioDAO = new UsuarioDAO(usuario);
    if (usuarioDAO.findByOnlyLogin()) {
        statusField.setText(usuario.getStatusDaConta());
    } else {
        System.out.println("Usuário não encontrado!");
    }
  }

}
