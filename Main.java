import controller.AccountDetailsController;
import controller.BookRegistrationController;
import controller.ChooseDocumentController;
import controller.EbookRegistrationController;
import controller.HomeScreenController;
import controller.LoginController;
import controller.MonographRegistrationController;
import controller.RegisterController;
import model.dao.classes.AutorDAO;
import model.dao.classes.CategoriaDAO;
import model.dao.classes.ComentarioDAO;
import model.dao.classes.DocumentoDAO;
import model.dao.classes.EbookDAO;
import model.dao.classes.EmprestadoDAO;
import model.dao.classes.EmprestimoDAO;
import model.dao.classes.EscreveDAO;
import model.dao.classes.LivroDAO;
import model.dao.classes.MonografiaDAO;
import model.dao.classes.RecebeDAO;
import model.dao.classes.UsuarioDAO;
import model.dao.interfaces.IAutorDAO;
import model.dao.interfaces.ICategoriaDAO;
import model.dao.interfaces.IComentarioDAO;
import model.dao.interfaces.IDocumentoDAO;
import model.dao.interfaces.IEbookDAO;
import model.dao.interfaces.IEmprestadoDAO;
import model.dao.interfaces.IEmprestimoDAO;
import model.dao.interfaces.IEscreveDAO;
import model.dao.interfaces.ILivroDAO;
import model.dao.interfaces.IMonografiaDAO;
import model.dao.interfaces.IRecebeDAO;
import model.dao.interfaces.IUsuarioDAO;
import model.entities.Autor;
import model.entities.Categoria;
import model.entities.Comentario;
import model.entities.Documento;
import model.entities.Ebook;
import model.entities.Emprestado;
import model.entities.Emprestimo;
import model.entities.Escreve;
import model.entities.Livro;
import model.entities.Monografia;
import model.entities.Recebe;
import model.entities.Usuario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application{
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    try {
      Parent root = FXMLLoader.load(getClass().getResource("/view/homeScreen.fxml"));
      primaryStage.getIcons().add(new Image("/img/icon.png"));                            
      primaryStage.setTitle("Bibliotech"); 
      primaryStage.setResizable(false);         
      primaryStage.setScene(new Scene(root, 1280, 720));         
      primaryStage.show();          
      primaryStage.sizeToScene();  
      primaryStage.setOnCloseRequest(e -> {System.exit(0);}); 
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}