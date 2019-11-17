import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.geometry.Insets;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import java.util.Random;
import java.util.HashMap; 
import java.util.Map; 

public class RescueGUI extends Application {

  // Frame layout geometric parameters
  final int Scene_Width = 1000;
  final int Scene_Hight = 600;
  final int Side_Padding = 25;
  
  final int Pane_H_Gap = 15;
  final int Pane_V_Gap = 15;
  
  final int Button_Width = 100;
  
  final int TextField_Width = 800;
  final int TextField_Height = 40;
  
  // Search count data
  final String[] stateAbbNames = {
  final String[] stateAbbNames = {
      "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "DC", "FL", 
      "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME",
      "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", 
      "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI",
      "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI",
      "WY" };
  final int Num_States = 51;
  int Counts[] = new int[Num_States];
  String States[] = new String[Num_States];
  public static HashMap<String, Integer> State_Count_Map = new HashMap<String, Integer>();
  
  @Override
  public void start(Stage primaryStage) {
  
    // Prepare test data
    prepareCountData();

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
    btnSearch.setPrefWidth(Button_Width);
    btnPane.getChildren().add(btnSearch);
    
    // Search text field
    TextField srchText = new TextField();
    srchText.setPrefColumnCount(1);
    srchText.setPromptText("Enter a key word to search in the ads");
    srchText.setPrefWidth(TextField_Width);
    srchText.setPrefHeight(TextField_Height);
    srchText.setFont(Font.font("Arial", 16));
    
    // Search result bar chart
    CategoryAxis xAxis = new CategoryAxis();
    NumberAxis yAxis = new NumberAxis();
    BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
    barChart.setHorizontalGridLinesVisible(false);
    barChart.setVerticalGridLinesVisible(false);
    barChart.setLegendVisible(false);
    barChart.setCategoryGap(2);
    barChart.setBarGap(0);
    barChart.setMinWidth(Scene_Width*0.90);
    barChart.setMaxWidth(Scene_Width);
    
    xAxis.setLabel("State");
    yAxis.setLabel("Match Count");
    
    XYChart.Series series = new XYChart.Series();
    for (int i = 0; i < Num_States; i++) {
       series.getData().add(new XYChart.Data(States[i], Counts[i]));
    }
//     State_Count_Map.forEach((k, v) -> { series.getData().add(new XYChart.Data(k, v)); });
    barChart.getData().addAll(series);

    // Place nodes in the outter pane
    outterPane.getChildren().addAll(barChart, srchText, btnPane);
    
    // Construct the scene
    Scene scene = new Scene(outterPane, Scene_Width, Scene_Hight);
    
    // Stage
    primaryStage.setTitle("Rescue");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  // Generate dummy random count data
  private void prepareCountData() {
      Random random = new Random();
      for(int i = 0; i < Num_States; i++) {
         States[i] = stateAbbNames[i];
         Counts[i] = random.nextInt(100);
         State_Count_Map.put(stateAbbNames[i], Counts[i]);
      }
  }
}