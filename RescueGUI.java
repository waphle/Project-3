import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.Group;
import javafx.scene.Scene;

public class RescueGUI extends Application {

   @Override
   public void start(Stage primaryStage){
      Scene scene = new Scene(new Group());
      primaryStage.setTitle("RescueGUI");
      primaryStage.setWidth(750);
      primaryStage.setHeight(450);
      
      TextField textField = new TextField();
      textField.setPromptText("Search: ");
      textField.setOnKeyReleased(keyEvent -> {
      // Code here
      });

   }

//    // Do not delete
//   @Override
//   public void start(Stage primaryStage){
//     TextField textField = new TextField();
//     textField.setPromptText("Search");
//     Scene scene = new Scene(textField, 750, 450);
//     primaryStage.setTitle("RescueGUI");
//     primaryStage.setScene(scene);
//     primaryStage.show();
//   }

  public static void main(String[] args){
    Application.launch(args);
  }
  
}