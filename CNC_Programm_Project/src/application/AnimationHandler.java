package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class AnimationHandler {

public void  line( double xEnd, double yEnd, SampleController sc, double dx, double dy) {

	Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>() {
		
		public void handle(ActionEvent t) {
			
			if (sc.fraeser.getPosX() < (xEnd/2) || sc.fraeser.getPosY() < (yEnd/2)) {
				if (sc.fraeser.getPosX() >= xEnd/2) {
					final double dx = 0;
				}

				else if (sc.fraeser.getPosY() >= yEnd/2) {
					final double dy = 0;
				}
				Circle circle = new Circle(sc.fraeser.getPosX(), sc.fraeser.getPosY() , sc.fraeser.getDrillDiameter()/2, sc.drillColor);
				sc.drawPane.getChildren().add(circle);
				sc.circDrill.toFront();
				
				sc.circDrill.setLayoutX(sc.circDrill.getLayoutX() + dx);
				sc.fraeser.setPosX(sc.circDrill.getLayoutX());
				sc.circDrill.setLayoutY(sc.circDrill.getLayoutY() + dy);
				sc.fraeser.setPosY(sc.circDrill.getLayoutY());
				
//				System.out.println(sc.circDrill.getLayoutX() + "  " + sc.circDrill.getLayoutY() + "  " + Math.round(xEnd/2 )+ "   "+yEnd/2);
//				if (sc.circDrill.getLayoutX() == xEnd/2) {
//					System.out.println("fertig");
//					sc.cutCode(sc.commands.get(sc.iterator+1));
//					
//				}
				
			}
			sc.refreshDrillPos();
			
			

		}
		
		
	}));
	
	timeline.setCycleCount(Timeline.INDEFINITE);
	timeline.play();
		
}
	


public void circle( double xEnd, double yEnd, SampleController sc, double dx, double dy) {

	Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>() {
		
		public void handle(ActionEvent t) {
			
			if (sc.fraeser.getPosX() < (xEnd/2) || sc.fraeser.getPosY() < (yEnd/2)) {
				if (sc.fraeser.getPosX() >= xEnd/2) {
					final double dx = 0;
				}

				else if (sc.fraeser.getPosY() >= yEnd/2) {
					final double dy = 0;
				}
				Circle circle = new Circle(sc.fraeser.getPosX(), sc.fraeser.getPosY() , sc.fraeser.getDrillDiameter()/2, sc.drillColor);
				sc.drawPane.getChildren().add(circle);
				sc.circDrill.toFront();
				
				sc.circDrill.setLayoutX(sc.circDrill.getLayoutX() + dx);
				sc.fraeser.setPosX(sc.circDrill.getLayoutX());
				sc.circDrill.setLayoutY(sc.circDrill.getLayoutY() + dy);
				sc.fraeser.setPosY(sc.circDrill.getLayoutY());
			}
			sc.refreshDrillPos();
			
		}
	}));

	timeline.setCycleCount(Timeline.INDEFINITE);
	timeline.play();
}


}

