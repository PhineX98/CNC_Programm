package gCode;

import application.SampleController;
import fileParser.CommandCode;
import handler.AnimationHandler;
import handler.Befehl;
import komponenten.Fraeser;
import komponenten.Spindel;
import logging.Logging;


/**
 * Diese Klasse implemenmtiert eine Verfahrbewegung im Eilgang. (nur ohne
 * Bohren/Fräsen möglich 
 *  -> G00 des G-Codes
 *
 * @author Jannik Orth
 */
public class G00 extends Befehl {

	/*
	 * Ausführen des eingehenden Verfahrbefehls
	 */
	public void exec(Spindel s, Fraeser f, SampleController c, Logging l, CommandCode values) {
		l.zeitStarten();
		
		
		if(!f.getFraeserStatus() && !s.getStatus()) {
			startAnimation(s, f, c, l, values);
		}else {
			c.errorHandler.youHaveAnIvalidCommandInAction(c,values);
		}
	}
	
	/*
	 * Benötigte Logik zum Starten und Animieren des Fahrbefehls
	 */
	private void startAnimation(Spindel s, Fraeser f, SampleController c, Logging l, CommandCode values){
		/*
		 * xRead 	-> eingegebener xZeilwert
		 * yRead 	-> 			    yZielwert
		 * aktX	 	-> aktuelle xPosition
		 * aktY  	-> 		 	yPosition
		 * xToDrill -> zu fräsen in xRichtung
		 * yToDrill -> 				yRichtung
		 * dx	-> Steps in xRichtung
		 * dy 	-> Steps in yRichtung
		 */
		double xRead = values.getX() / 2;
		double yRead = values.getY() / 2;
		double aktX = f.getPosX();
		double aktY = f.getPosY();
		double xToMove = Math.abs(xRead - aktX);
		double yToMove = Math.abs(yRead - aktY);
		double dx, dy;

		// Fahrtrichtung und Schritte in x und y Richtung festlegen
		if (xToMove > yToMove) {
			dx = 1;
			if (aktX > xRead) {
				dx = -1;
			}
			dy = (yToMove) / (xToMove);
			
		} else if (xToMove < yToMove) {

			dx = xToMove / yToMove;
			dy = 1;
			if (aktY > yRead) {
				dy = -1;
			}

		} else 
		{
			if (xRead < aktX) {
				dx = -1;
			} else {
				dx = 1;
			}
			if (yRead < aktY) {
				dy = -1;
			} else {
				dy = 1;
			}
		}

		//Zum Animieren der Fräsung
		AnimationHandler cutter = new AnimationHandler();
		double lengthStep = Math.sqrt(dx*dx + dy*dy);
		double temp = f.getFahrSpeed()*10/lengthStep;
		double speed = 600/temp;


			
		if (dx == 0) {
			cutter.lineYFast(xRead, yRead, c, dx, dy, yToMove,speed);
		} else if (dy == 0) {
			cutter.lineXFast(xRead, yRead, c, dx, dy, xToMove,speed);
		}

		else if (xToMove < yToMove) {
			cutter.lineXFast(xRead, yRead, c, dx, dy, xToMove,speed);
		} else if (xToMove > yToMove) {
			cutter.lineYFast(xRead, yRead, c, dx, dy, yToMove,speed);
		} else {
			cutter.lineYFast(xRead, yRead, c, dx, dy, yToMove,speed);
		}
		
		
			l.addToLog("G00 ausgeführt in " + l.zeitGebraucht());
		
	}
	

}
