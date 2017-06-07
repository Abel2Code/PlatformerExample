package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Main extends Application {
	private static int currentLevel = 1;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane window = new BorderPane();
			HBox game = new HBox();
			EnvironmentGUIPane pane = new EnvironmentGUIPane();
			Scene scene = new Scene(window,1500,650);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			scene.getStylesheets().add("application/application.css");
			window.setCenter(game);
			game.getChildren().add(pane);
			pane.startLevel(currentLevel);
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