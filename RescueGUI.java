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
   ADRepos adDatabase = new ADRepos();
   int Counts[] = new int[Constants.NUMBER_OF_STATES];
   String States[] = new String[Constants.NUMBER_OF_STATES];
   public static HashMap<String, Integer> State_Count_Map = new HashMap<String, Integer>();
   String dataFileName = "allDogDescriptions_simplified.csv";
  
   @Override
   public void start(Stage primaryStage) throws Exception {
  
      // Load the ad file
      System.out.printf("Loading ads from %s...\n", dataFileName);
      adDatabase.loadADs(dataFileName);
      System.out.println("Loading file is done.");
    
      // Prepare test data
      prepareCountData();

      // Layout the application GUI
      // Side offsets for outter pane in the scene
      FlowPane outterPane = new FlowPane();
      outterPane.setPadding(new Insets(Constants.SCENE_SIDE_MARGIN, Constants.SCENE_SIDE_MARGIN, 
                            Constants.SCENE_SIDE_MARGIN, Constants.SCENE_SIDE_MARGIN));
      outterPane.setHgap(Constants.PANE_H_GAP);
      outterPane.setVgap(Constants.PANE_V_GAP);
    
      // Search button
      StackPane btnPane = new StackPane();
      Button btnSearch = new Button("Search");
      btnSearch.setFont(Font.font("Arial", 18));
      btnSearch.setPrefWidth(Constants.BUTTON_WIDTH);
      btnPane.getChildren().add(btnSearch);
    
      // Search text field
      TextField srchText = new TextField();
      srchText.setPrefColumnCount(1);
      srchText.setPromptText("Enter a key word to search in the ads");
      srchText.setPrefWidth(Constants.TEXTFIELD_WIDTH);
      srchText.setPrefHeight(Constants.TEXTFIELD_HEIGHT);
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
      barChart.setMinWidth(Constants.SCENE_WIDTH*0.90);
      barChart.setMaxWidth(Constants.SCENE_WIDTH);
      
      xAxis.setLabel("State");
      yAxis.setLabel("Match Count");
      
      XYChart.Series series = new XYChart.Series();
      for (int i = 0; i < Constants.NUMBER_OF_STATES; i++) {
         series.getData().add(new XYChart.Data(States[i], Counts[i]));
      }
//     State_Count_Map.forEach((k, v) -> { series.getData().add(new XYChart.Data(k, v)); });
      barChart.getData().addAll(series);

      // Place nodes in the outter pane
      outterPane.getChildren().addAll(barChart, srchText, btnPane);
    
      // Construct the scene
      Scene scene = new Scene(outterPane, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
    
      // Stage
      primaryStage.setTitle("Rescue");
      primaryStage.setScene(scene);
      primaryStage.setResizable(false);
      primaryStage.show();
   }

   public static void main(String[] args) {
      Application.launch(args);
   }

   // Generate dummy random count data
   private void prepareCountData() {
       Random random = new Random();
       Random random = new Random();
       for(int i = 0; i < Constants.NUMBER_OF_STATES; i++) {
         States[i] = Constants.STATE_NAME_CODES[i];
         Counts[i] = random.nextInt(100);
         State_Count_Map.put(Constants.STATE_NAME_CODES[i], Counts[i]);
      }
   }
}