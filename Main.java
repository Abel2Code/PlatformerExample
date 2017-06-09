package application;
	
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	public static int currentLevel = 0;
	public static Scene scene = new Scene(MainMenu.createMainMenu(),649,650);
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			scene.getStylesheets().add("application/application.css");
//			pane.startLevel(currentLevel);
//			scene.setRoot(MainMenu.createMainMenu());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}