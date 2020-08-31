package gCode;

import application.SampleController;
import fileParser.CommandCode;
import handler.AnimationHandler;
import handler.Befehl;
import komponenten.Fraeser;
import komponenten.Spindel;
import logging.Logging;

/**
 * Diese Klasse implementiert eine Kreispolation im Uhrzeigersinn -> G02 des
 * G-Codes
 *
 * @author Simon Bohner
 */
public class G02 extends Befehl {
	double i, j, r, xRead, yRead;
	double xCenter, yCenter, sDeg, eDeg;
	double targetDeg;

	/*
	 * Ausführen des eingehenden Verfahrbefehls
	 */
	public void exec(Spindel s, Fraeser f, SampleController c, Logging l, CommandCode values) {
		l.zeitStarten();

		i = values.getI() / 2;
		j = values.getJ() / 2;
		r = Math.sqrt(i * i + j * j);

		xRead = Math.round(values.getX() / 2);
		yRead = Math.round(values.getY() / 2);

		xCenter = c.fraeser.getPosX() + i;
		yCenter = c.fraeser.getPosY() + j;

		sDeg = calcDegree(i, 0, j, 0);
		eDeg = calcDegree(xRead, xCenter, yRead, yCenter);

		System.out.println(sDeg + "  " + eDeg);

//		if (!((Math.pow((xCenter - xRead), 2) + Math.pow((yCenter - yRead), 2)) == r * r)
//				&& (Math.pow((xCenter - f.getPosX()), 2) + Math.pow((yCenter - f.getPosY()), 2) == r * r)) {
//			c.errorHandler.yourEndCoordinateIsNotOnCircle(c, values);
//		} else {

//		double lengthStep = 2*r*Math.PI*targetDeg/360;
//		double temp = f.getAktSpeed()*10/lengthStep;
//		double temp2 = 600/temp;

			AnimationHandler cutter = new AnimationHandler();
			double lengthStep = 2 * r * Math.PI * targetDeg / 360;
			double temp = f.getAktSpeed() * 10 / lengthStep;
			double temp2 = 600 / temp;
			cutter.circle(xRead, yRead, xCenter, yCenter, sDeg, eDeg, r, c, temp2);

			l.addToLog("G02 ausgeführt in " + l.zeitGebraucht());
		}
	

	/*
	 * Berechnung der Winkel
	 */
	private static double calcDegree(double i1, double i2, double j1, double j2) {
		double winkel = 0;
		if (i1 == i2) {
			if (j1 > j2) {
				winkel = 270;
			} else {
				winkel = 90;
			}
		} else if (i1 < i2) {
			if (j1 == j2) {
				winkel = 0;
			} else if (j1 < j2) {
				winkel = 360 - (Math.atan(j1 / i1) * (180 / Math.PI));
			} else if (j1 > j2) {
				winkel = (Math.atan(i1 / j1) * (180 / Math.PI));
			}
		} else {
			if (j1 == j2) {
				winkel = 180;
			} else if (j1 > j2) {
				winkel = 180 + Math.atan(j1 / i1) * (180 / Math.PI);
			} else if (j1 < j2) {
				winkel = 180 - (Math.atan(i1 / j1) * (180 / Math.PI));

			}
		}
		return winkel;
	}

}