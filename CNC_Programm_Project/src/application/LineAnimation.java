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
	
	
	public static void line( double xEnd, double yEnd) {
		Platform.runLater(()->{
		double xStart = f.getPosX();
		double yStart = f.getPosY();
		f.setFraeserStatus(true);
		
		if(!f.getFraeserStatus) {
			f.setFahrSpeed(f.getEilgang/60);;
		}else if(f.getCoolingStatus()){
			f.setFahrSpeed(f.getKuehlgang/60);
		}else if(!f.getCoolingStatus()) {
			f.setFahrSpeed(f.getTrockengang/60);
		}
		Line line = new Line();
		line.setStartX(xStart);		
		line.setStartY(yStart);
		line.setEndX(xStart);
		line.setEndY(yStart);
		line.setStrokeWidth(15);
		line.setStroke(Color.BLACK);
	
		drawPane.getChildren().add(line);
		line.toBack();
		if(!(temp == null)) {
			temp.setVisible(false);
		}
		
		Circle cir = new Circle(f.getPosX(), f.getPosY(),7.5,Color.RED);
		cir.toBack();
		KEINEAHNUNG.getChildren().add(cir);
		temp = cir;
		

		Timeline t = new Timeline();
		t.getKeyFrames().add(new KeyFrame(Duration.seconds(getDauer( f.getFahrSpeed ,f.getPosX()-values.getX() , f.getPosY() + values.getY())), 
				new KeyValue(line.endXProperty(), values.getX()),
				new KeyValue(line.endYProperty(), values.getY),
				new KeyValue(cir.centerXProperty(), values.getX()),
				new KeyValue(cir.centerYProperty(), values.getY())
				
				));
		
	
		Timeline t2 = new Timeline();
		int intervalle = 200;
		for(int a = 1; a <= intervalle ; a++) {
		t2.getKeyFrames().add(new KeyFrame(Duration.seconds(((getDauer( Main.getAktGeschw() ,xStart-xEnd , yStart-1050 + yEnd))/intervalle)*a),
				new KeyValue(GUI.aktuellX.textProperty(), String.valueOf(Math.round(xStart+((xEnd-xStart)/intervalle)*a))),
				new KeyValue(GUI.aktuellY.textProperty(), String.valueOf(Math.round(1050-yStart+((-1050+yEnd+yStart)/intervalle)*a)))
				));
		}
		TranslateTransition trans = new TranslateTransition();
		trans.setNode(GUI.aktuellX);
		GUI.setAndPlayTimeline(t, t2);
		t.setOnFinished(ActionEvent ->{
			CodeVerarbeitung.setBoolWeiter(true);
		});
		
		GUI.setKopfX(xEnd);
		GUI.setKopfY(GUI.getHeight() - yEnd);

	
		});
	}
	public static void lineJustKreis( double xEnd, double yEnd) {
		Platform.runLater(()->{
		double xStart = GUI.getKopfX();
		double yStart = GUI.getKopfY();
		
		if(GCodes.getEilgang()) {
			Main.setAktGeschwind_fahrt();
		}else if(Main.isKuehlungAktiv()){
			Main.setAktGeschwind_schnell();
		}else if(!Main.isKuehlungAktiv()) {
			Main.setAktGeschwind_langsam();
		}
		
		if(!(temp == null)) {
			temp.setVisible(false);
		}
		
		Circle cir = new Circle(GUI.getKopfX(), GUI.getKopfY(),GUI.getKopfRadius(),GUI.getKopfFill());
		GUI.KopfsetVisible(false);
		cir.toBack();
		GUI.arbeitsF.getChildren().add(cir);
		temp = cir;
		
		// Diese Timeline sorgt dafür, dass der Kopf animiert wird.
		Timeline t = new Timeline();
		t.getKeyFrames().add(new KeyFrame(Duration.seconds(getDauer( Main.getAktGeschw() ,xStart-xEnd , yStart-1050 + yEnd)),
				new KeyValue(cir.centerXProperty(), xEnd),
				new KeyValue(cir.centerYProperty(), GUI.getHeight()- yEnd)
				));
		
		// Diese Timeline sorgt dafür, dass die X und Y Koordinaten in der GUI aktualisiert werden.
		Timeline t2 = new Timeline();
		int intervalle = 200;
		for(int a = 1; a <= intervalle ; a++) {
		t2.getKeyFrames().add(new KeyFrame(Duration.seconds(((getDauer( Main.getAktGeschw() ,xStart-xEnd , yStart-1050 + yEnd))/intervalle)*a),
				new KeyValue(GUI.aktuellX.textProperty(), String.valueOf(Math.round(xStart+((xEnd-xStart)/intervalle)*a))),
				new KeyValue(GUI.aktuellY.textProperty(), String.valueOf(Math.round(1050-yStart+((-1050+yEnd+yStart)/intervalle)*a)))
				));
		}
		TranslateTransition trans = new TranslateTransition();
		trans.setNode(GUI.aktuellX);
		GUI.setAndPlayTimeline(t, t2);
		t.setOnFinished(ActionEvent ->{
			CodeVerarbeitung.setBoolWeiter(true);
		});
		
		GUI.setKopfX(xEnd);
		GUI.setKopfY(GUI.getHeight() - yEnd);
	
		});
	}
}
