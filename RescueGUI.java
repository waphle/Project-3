import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class RescueGUI extends Application {

  @Override
  public void start(Stage primaryStage){
    Button btOK = new Button("Search");
    Scene scene = new Scene(btOK, 750, 450);
    primaryStage.setTitle("RescueGUI");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args){
    Application.launch(args);
  }
}