package application;

import fileParser.CommandCode;

/**
 * Diese Klasse implementiert den Fräsvorgang einer Geraden von Punkt a zu Punkt
 * b -> G28 des G-Codes
 *
 * @author Jannik Orth
 */
public class G28 extends Befehl {

	/*
	 * Ausführen des eingehenden Verfahrbefehls
	 */
	public void exec(Spindel s, Fraeser f, SampleController c, Logging l, CommandCode values) {
		System.out.println("G28");
		l.zeitStarten();

		values.setX(c.fraeser.getHomePosX());
		values.setY(c.fraeser.getHomePosX());
		
		if (!f.getFraeserStatus()) {
			startAnimation(s, f, c, l, values);
		} else {
			c.errorHandler.youHaveToStartTheDrillViaCommand();
		}
	}

	/*
	 * Benötigte Logik zum Starten und Animieren des Fahrbefehls
	 */
	private void startAnimation(Spindel s, Fraeser f, SampleController c, Logging l, CommandCode values) {

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
		double xToDrill = Math.abs(xRead - aktX);
		double yToDrill = Math.abs(yRead - aktY);
		double dx, dy;

		// Fahrtrichtung und Schritte in x und y Richtung festlegen
		if (xToDrill > yToDrill) {

			dx = 1;
			if (aktX > xRead) {
				dx = -1;
			}

			dy = (yToDrill) / (xToDrill);

		} else if (xToDrill < yToDrill) {

			dx = xToDrill / yToDrill;

			dy = 1;
			if (aktY > yRead) {
				dy = -1;
			}

		} else {
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

		AnimationHandler cutter = new AnimationHandler();
		double lengthStep = Math.sqrt(dx * dx + dy * dy);
		double temp = f.getAktSpeed() * 10 / lengthStep;
		double speed = 600 / temp;

//		System.out.println(xRead + " " + yRead + " " + dx + " " + dy + "   " + xToDrill + "  "
//				+ yToDrill + "  " + aktX + "  " + aktY);

		
		if (dx == 0) {
			cutter.lineY(xRead, yRead, c, dx, dy, yToDrill, speed);

		} else if (dy == 0) {
			cutter.lineX(xRead, yRead, c, dx, dy, xToDrill, speed);

		} else if (xToDrill < yToDrill) {
			cutter.lineX(xRead, yRead, c, dx, dy, xToDrill, speed);

		} else if (xToDrill > yToDrill) {
			cutter.lineY(xRead, yRead, c, dx, dy, yToDrill, speed);

		} else {
			cutter.lineY(xRead, yRead, c, dx, dy, yToDrill, speed);

		}

		l.addToLog("G28 ausgeführt in " + l.zeitGebraucht());
	}
}
