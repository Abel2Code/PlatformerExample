package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class Main extends Application {
//	private static int currentLevel = 1;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			EnvironmentGUIPane root = getLevel();
			Scene scene = new Scene(root,1500,650);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			scene.getStylesheets().add("application/application.css");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private EnvironmentGUIPane getLevel(){
		FirstLevel level = new FirstLevel();
		return level.getLayout();
	}
}
