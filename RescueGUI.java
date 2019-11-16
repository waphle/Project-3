import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.geometry.Insets;

public class RescueGUI extends Application {

  // Scene geometric parameters
  final int Scene_Width = 1000;
  final int Scene_Hight = 600;
  final int Side_Padding = 25;
  final int Pane_H_Gap = 15;
  final int Pane_V_Gap = 15;
  final int Button_Width = 100;
  
  @Override
  public void start(Stage primaryStage) {
    // Layout the application GUI
    // Side offsets for outter pane in the scene
    FlowPane outterPane = new FlowPane();
    outterPane.setPadding(new Insets(Side_Padding, Side_Padding, Side_Padding, Side_Padding));
    outterPane.setHgap(Pane_H_Gap);
    outterPane.setVgap(Pane_V_Gap);
    
    // Search button
    StackPane btnPane = new StackPane();
    Button btnSearch = new Button("Search");
    btnSearch.setFont(Font.font("Arial", 18));
    btnPane.getChildren().add(btnSearch);
    btnPane.setPrefWidth(Button_Width);
    
    // Search text field
    TextField srchText = new TextField();
    srchText.setPrefColumnCount(1);
    srchText.setPromptText("Enter a key word to search in the ads");
    srchText.setPrefWidth(Scene_Width - Pane_H_Gap - 2*Side_Padding - 1.5*Button_Width);
    srchText.setPrefHeight(40);
    
    // Place nodes in the outter pane
    outterPane.getChildren().addAll(srchText, btnPane);
    
    // Construct the scene
    Scene scene = new Scene(outterPane, Scene_Width, Scene_Hight);
    
    // Stage
    primaryStage.setTitle("Rescue");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

}