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
      primaryStage.setScene(new Scene(root));         
      primaryStage.show();          
      primaryStage.sizeToScene();  
      primaryStage.setOnCloseRequest(e -> {System.exit(0);}); 
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}