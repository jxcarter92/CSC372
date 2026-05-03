package application;
	
import javafx.scene.control.MenuBar;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

import java.io.FileWriter;
import javafx.geometry.Insets;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		 // BorderPane allows us to place the menu bar at the top and text area in the center
		BorderPane root = new BorderPane();
		 // Create the main scene with a 400x400 pixel window size
		Scene scene = new Scene(root,400,400);
		try {
			// Create a text area where date/time output will be displayed
            // Size is capped at 300x300 so it fits neatly inside the window
			TextArea textArea = new TextArea();
			textArea.setMaxSize(300, 300);
			// Add 10px padding around the root layout so content doesn't touch the edges
			root.setPadding(new Insets(10));
			// Create the menu bar and the main "Options" drop-down menu
			MenuBar menuBar = new MenuBar();
			Menu menu = new Menu("Options");
			
			// Define the four menu items as required by the assignment
			MenuItem dateTimeItem = new MenuItem("Show Date/Time");
			MenuItem saveLogItem = new MenuItem("Save to Log");
			MenuItem changeBgItem = new MenuItem("Change Background Color to Green");
			MenuItem exitItem = new MenuItem("Exit");
			
			// Add all four items to the Options menu, then add the menu to the menu bar
			menu.getItems().addAll(dateTimeItem, saveLogItem, changeBgItem, exitItem);
			menuBar.getMenus().add(menu);
			
			// Place the menu bar at the top and the text area in the center of the window
			root.setTop(menuBar);
			root.setCenter(textArea);
			
			// Place the menu bar at the top and the text area in the center of the window
			exitItem.setOnAction(e -> Platform.exit());
			
			// Menu item 1 — Show Date/Time: gets the current date and time,
            // formats it as "yyyy-MM-dd HH:mm:ss", and displays it in the text area
			dateTimeItem.setOnAction(e-> textArea.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
			// Menu item 2 — Save to Log: writes the current text area contents
            // to a file named "log.txt" in the project's working directory
			saveLogItem.setOnAction(e -> {
			    try {
			        FileWriter writer = new FileWriter("log.txt");
			        writer.write(textArea.getText());
			        writer.close();// Always close the writer to flush and release the file
			    } catch (Exception ex) { // Print error details if the file cannot be written
			        ex.printStackTrace();
			    }
			});
			
			changeBgItem.setOnAction(e -> {
			    int green = (int)(128 + Math.random() * 127);
			    int other = (int)(Math.random() * 100);
			    String hex = String.format("#%02x%02x%02x", other, green, other);
			    root.setStyle("-fx-background-color: " + hex + ";");
			    });
	
			// Set the scene on the primary stage and display the window
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
