package application;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.util.Duration;


public class LineAnimation extends Animation {
	
	
	public static void line( double xEnd, double yEnd, SampleController sc) {
		
		double xStart = sc.fraeser.getPosX();
		double yStart = sc.fraeser.getPosY();
		
		
		if(!sc.fraeser.getFraeserStatus()) {
			sc.fraeser.setFahrSpeed(sc.fraeser.fahrSpeed/60);;
		}else if(sc.fraeser.getCoolingStatus()){
			sc.fraeser.setFahrSpeed(sc.fraeser.schnittSpeedCooling/60);
		}else if(!sc.fraeser.getCoolingStatus()) {
			sc.fraeser.setFahrSpeed(sc.fraeser.getSchnittSpeedNoCooling()/60);
		}
		
		Line line = new Line();
		line.setStartX(xStart);		
		line.setStartY(yStart);
		line.setEndX(xEnd);
		line.setEndY(yEnd);
		line.setStrokeWidth(sc.fraeser.getDrillDiameter()/4);
		line.setStroke(Color.BLACK);
	
		sc.drawPane.getChildren().add(line);
		line.toBack();
		if(!(temp == null)) {
			temp.setVisible(false);
		}
		
		Circle cir = new Circle(sc.fraeser.getPosX(), sc.fraeser.getPosY(),sc.fraeser.getDrillDiameter()/4,Color.RED);
		cir.toBack();
		sc.drawPane.getChildren().add(cir);
		temp = cir;
		
//
//		Timeline t = new Timeline();
//		t.getKeyFrames().add(new KeyFrame(Duration.seconds(getDauer( sc.fraeser.getAktSpeed() ,xStart-sc.fraeser.getPosX() , yStart + sc.fraeser.getPosY())), 
//				new KeyValue(line.endXProperty(),sc.fraeser.getPosX()),
//				new KeyValue(line.endYProperty(), sc.fraeser.getPosY()),
//				new KeyValue(cir.centerXProperty(), sc.fraeser.getPosX()),
//				new KeyValue(cir.centerYProperty(), sc.fraeser.getPosY())
//							
//				));
//		
//	
//		Timeline t2 = new Timeline();
//		int intervalle = 200;
//		for(int a = 1; a <= intervalle ; a++) {
//		t2.getKeyFrames().add(new KeyFrame(Duration.seconds(((getDauer( SampleController.sc.fraeser.getAktSpeed() ,xStart-xEnd , yStart-1050 + yEnd))/intervalle)*a),
//				new KeyValue(sc.statX.textProperty(), String.valueOf(Math.round(xStart+((xEnd-xStart)/intervalle)*a))),
//				new KeyValue(sc.statY.textProperty(), String.valueOf(Math.round(1050-yStart+((-1050+yEnd+yStart)/intervalle)*a)))));
//		}
//		TranslateTransition trans = new TranslateTransition();
//		trans.setNode(sc.statX);
//		sc.setAndPlayTimeline(t, t2);
//		t.setOnFinished(ActionEvent ->{
//			CodeVerarbeitung.setBoolWeiter(true);
//		});
		
		sc.fraeser.setPosX(xEnd);
		sc.fraeser.setPosY(yEnd);

	
		};
//
//		// Diese Timeline sorgt dafür, dass der Kopf animiert wird.
//		Timeline t = new Timeline();
//		t.getKeyFrames().add(new KeyFrame(Duration.seconds(getDauer( Main.getAktGeschw() ,xStart-xEnd , yStart-1050 + yEnd)),
//				new KeyValue(cir.centerXProperty(), xEnd),
//				new KeyValue(cir.centerYProperty(), GUI.getHeight()- yEnd)
//				));
//		
//		// Diese Timeline sorgt dafür, dass die X und Y Koordinaten in der GUI aktualisiert werden.
//		Timeline t2 = new Timeline();
//		int intervalle = 200;
//		for(int a = 1; a <= intervalle ; a++) {
//		t2.getKeyFrames().add(new KeyFrame(Duration.seconds(((getDauer( Main.getAktGeschw() ,xStart-xEnd , yStart-1050 + yEnd))/intervalle)*a),
//				new KeyValue(GUI.aktuellX.textProperty(), String.valueOf(Math.round(xStart+((xEnd-xStart)/intervalle)*a))),
//				new KeyValue(GUI.aktuellY.textProperty(), String.valueOf(Math.round(1050-yStart+((-1050+yEnd+yStart)/intervalle)*a)))
//				));
//		}
//		TranslateTransition trans = new TranslateTransition();
//		trans.setNode(GUI.aktuellX);
//		GUI.setAndPlayTimeline(t, t2);
//		t.setOnFinished(ActionEvent ->{
//			CodeVerarbeitung.setBoolWeiter(true);
//		});
		
//		sc.fraeser.setPosX(xEnd);
//		sc.fraeser.setPosY(yEnd);

//		});
		public static void lineJustKreis( double xEnd, double yEnd,SampleController sc) {
//			Platform.runLater(()->{
			double xStart = sc.fraeser.getPosX();
			double yStart = sc.fraeser.getPosY();
			
			
			if(!sc.fraeser.getFraeserStatus()) {
				sc.fraeser.setFahrSpeed(sc.fraeser.fahrSpeed/60);;
			}else if(sc.fraeser.getCoolingStatus()){
				sc.fraeser.setFahrSpeed(sc.fraeser.schnittSpeedCooling/60);
			}else if(!sc.fraeser.getCoolingStatus()) {
				sc.fraeser.setFahrSpeed(sc.fraeser.getSchnittSpeedNoCooling()/60);
			}
			
						
			Circle cir = new Circle(sc.fraeser.getPosX(), sc.fraeser.getPosY(),sc.fraeser.getDrillDiameter()/4,Color.RED);
//			GUI.KopfsetVisible(false);
			sc.drawPane.getChildren().add(cir);
			cir.toBack();
			if(!(temp == null)) {
				temp.setVisible(false);
			}
			
			Timeline t = new Timeline();
//			t.getKeyFrames().add(new KeyFrame(Duration.seconds(getDauer( sc.fraeser.getAktSpeed() ,xStart-sc.fraeser.getPosX() , yStart + sc.fraeser.getPosY())), 
//					new KeyValue(line.endXProperty(),sc.fraeser.getPosX()),
//					new KeyValue(line.endYProperty(), sc.fraeser.getPosY()),
//					new KeyValue(cir.centerXProperty(), sc.fraeser.getPosX()),
//					new KeyValue(cir.centerYProperty(), sc.fraeser.getPosY())
//								
//					));
//			
	//	
//			Timeline t2 = new Timeline();
//			int intervalle = 200;
//			for(int a = 1; a <= intervalle ; a++) {
//			t2.getKeyFrames().add(new KeyFrame(Duration.seconds(((getDauer( SampleController.sc.fraeser.getAktSpeed() ,xStart-xEnd , yStart-1050 + yEnd))/intervalle)*a),
//					new KeyValue(sc.statX.textProperty(), String.valueOf(Math.round(xStart+((xEnd-xStart)/intervalle)*a))),
//					new KeyValue(sc.statY.textProperty(), String.valueOf(Math.round(1050-yStart+((-1050+yEnd+yStart)/intervalle)*a)))));
//			}
//			TranslateTransition trans = new TranslateTransition();
//			trans.setNode(sc.statX);
//			sc.setAndPlayTimeline(t, t2);
//			t.setOnFinished(ActionEvent ->{
//				CodeVerarbeitung.setBoolWeiter(true);
//			});
			
			sc.fraeser.setPosX(xEnd);
			sc.fraeser.setPosY(yEnd);
		
			});
		}
	}
//}
