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
      primaryStage.setScene(scene);
      primaryStage.show();
   }
   
   public void start(Scene primaryScene){
      Scene scene = new Scene(new Group());  
      TextField textField = new TextField();
      textField.setPromptText("Search: ");
      Scene scene2 = new Scene(textField, 200, 100);
      textField.setOnKeyReleased(keyEvent -> {
      // Code here
      });
   }
   
  public static void main(String[] args){
    Application.launch(args);
  }
  
}
   
//    // Do not delete
//       Stage stage = new Stage();
//       stage.setScene(scene);
//       stage.setTitle("Search: ");
//       TextField textField = new TextField();
//       textField.setPromptText("Search: ");
//       Scene scene2 = new Scene(textField, 200, 100);
//       textField.setOnKeyReleased(keyEvent -> {
//       // Code here
//       });
//          
//       stage.setScene(scene);
//       stage.show();
//    }

      

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