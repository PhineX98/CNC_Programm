package application;

/**
*Dies ist die MAIN Klasse, die das Programm startet
*
* @author Jannik Orth
*/
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("Window.fxml"));
			Scene scene = new Scene(root, 1241, 660);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
			primaryStage.setTitle("CNC Simulation");

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public static void main(String[] args) {
		launch(args);

	}

}