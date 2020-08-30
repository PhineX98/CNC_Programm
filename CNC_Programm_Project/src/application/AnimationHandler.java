package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class AnimationHandler {

public void  line( double xRead, double yRead, SampleController sc, double dx, double dy) {
	

	
	 new Thread(() -> {
         do {
             try {
                 Thread.sleep(20);//Thread.sleep((int) ((1000 - sc.gets.getAktuelleSchnittgeschwindigkeit()) / 100 * 1.5));
                 
             } catch (InterruptedException ex) {
                 ex.printStackTrace();
             }
             Platform.runLater(() -> {
                
            	 if (sc.fraeser.getPosX() < (xRead) || sc.fraeser.getPosY() < (yRead) ) {
//     				if (sc.fraeser.getPosX() >= xRead) {
//     					 //double dx = 0;
//     				}
//     
//     				else if (sc.fraeser.getPosY() >= yRead) {
//     					//final double dy = 0;
//     				} 
     				Circle circle = new Circle(sc.fraeser.getPosX(), sc.fraeser.getPosY() , sc.fraeser.getDrillDiameter()/2, sc.drillColor);
     				sc.drawPane.getChildren().add(circle);
     				sc.circDrill.toFront();
     				
     				sc.circDrill.setLayoutX(Math.round(sc.circDrill.getLayoutX() + dx));
     				sc.fraeser.setPosX(sc.circDrill.getLayoutX());
     				sc.circDrill.setLayoutY(Math.round(sc.circDrill.getLayoutY() + dy));
     				sc.fraeser.setPosY(sc.circDrill.getLayoutY());
     				
     				System.out.println(sc.circDrill.getLayoutX() + "  " + sc.circDrill.getLayoutY() + "  " + xRead+ "   "+yRead + "   " + dx +"  " + dy);

     				
     			}
     			sc.refreshDrillPos();

            	 
            	 System.out.println("testeinnen");
//                 fraeseViewController.drawShape();
//                 fraeseViewController.gc.setColor(Color.WHITE);
//                 fraeseViewController.gc.setStroke(new BasicStroke(befehle.getWerkzeugdurchmesser(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
//                 if (cut != null) {
//                     fraeseViewController.gc.draw(cut);
//                 }
//                 commandList.get(getListPos()).draw(fraeseViewController);
//                 fräse.draw(fraeseViewController);
//                 drawNP();
             });
         }
         while (( sc.circDrill.getLayoutX() != xRead) || ( sc.circDrill.getLayoutY() != yRead));
         
         
         //HIer könnte man den nächsten kommand aufrufen wenn der thred fertig ist
         //sc.launchCommand();
         
         if (Thread.interrupted()) {
             return;
         }
     }).start();
	
	

//	Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {
//		
//		public void handle(ActionEvent t) {
//			
//			if (sc.fraeser.getPosX() < (xRead) || sc.fraeser.getPosY() < (yRead)) {
//				if (sc.fraeser.getPosX() >= xRead) {
//					final double dx = 0;
//				}
//
//				else if (sc.fraeser.getPosY() >= yRead) {
//					final double dy = 0;
//				}
//				Circle circle = new Circle(sc.fraeser.getPosX(), sc.fraeser.getPosY() , sc.fraeser.getDrillDiameter()/2, sc.drillColor);
//				sc.drawPane.getChildren().add(circle);
//				sc.circDrill.toFront();
//				
//				sc.circDrill.setLayoutX(sc.circDrill.getLayoutX() + dx);
//				sc.fraeser.setPosX(sc.circDrill.getLayoutX());
//				sc.circDrill.setLayoutY(sc.circDrill.getLayoutY() + dy);
//				sc.fraeser.setPosY(sc.circDrill.getLayoutY());
//				
//				System.out.println(sc.circDrill.getLayoutX() + "  " + sc.circDrill.getLayoutY() + "  " + xRead+ "   "+yRead + "   " + dx +"  " + dy);
////				if (sc.circDrill.getLayoutX() == xRead) {
////					//System.out.println("fertig");
////					//sc.cutCode(sc.commands.get(sc.iterator+1));
////					
////				}
//				
//			}
//			sc.refreshDrillPos();
//
//		}
//		
//		
//	}));
//	
//	timeline.setCycleCount(Timeline.INDEFINITE);
//	timeline.play();
		
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

