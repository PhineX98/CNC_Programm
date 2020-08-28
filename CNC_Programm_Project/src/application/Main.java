package application;

/**
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
			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root, 1150, 665);
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

		/*
		 * Spindel spindel = new Spindel(); Fraeser fraeser = new Fraeser(0,0);
		 * 
		 * spindel.startLeft(); System.out.println(spindel.getStatus());
		 * System.out.println(spindel.getRichtung());
		 * System.out.println(fraeser.getCoolingStatus());
		 * 
		 * M13 handleM00 = new M13();
		 * 
		 * handleM00.exec(spindel, fraeser); System.out.println(spindel.getStatus());
		 * System.out.println(spindel.getRichtung());
		 * System.out.println(fraeser.getCoolingStatus());
		 */

	}

}