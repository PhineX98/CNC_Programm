package application;

import fileParser.CommandCode;

/**
 *Diese Klasse implementiert eine Kreispolation gegen den Uhrzeigersinn
 *-> G03 des G-Codes
 *
 * @author Simon Bohner
 */
public class G03 extends Befehl {
	
	double i, j, r, xRead, yRead;
	double xCenter, yCenter, sDeg, eDeg;
	double targetDeg;
	
	public void exec(Spindel s, Fraeser f, SampleController c, Logging l, CommandCode values) {
		l.zeitStarten();
		
		i = values.getI();
		j = values.getJ();
		r = Math.sqrt(i * i + j * j);
		
		xRead = Math.round(values.getX()/2);
		yRead = Math.round(values.getY()/2);

		xCenter = c.fraeser.getPosX() - i;
		yCenter = c.fraeser.getPosY() + j;

		sDeg = calcDegree(r, j, -i);
		if (c.fraeser.getPosY() == yRead) {
			eDeg = calcDegree(r, 0, xRead - xCenter);
		} else {
			eDeg = calcDegree(r, yRead + yCenter, xRead - i);
		}
		
		if(eDeg > sDeg) {
			targetDeg = eDeg-sDeg;
		}else {
			targetDeg = 360 - sDeg + eDeg;			
		}
		
		if( !((Math.pow((xCenter - xRead),2)+Math.pow((yCenter-yRead), 2)==r*r) && (Math.pow((xCenter - f.getPosX()),2)+Math.pow((yCenter-f.getPosY()), 2)==r*r))) {
			//ERROR: Es liegen nicht beide Punkte auf dem Kreis....
		}else {
		AnimationHandler cutter = new AnimationHandler();
		double lengthStep = 2*r*Math.PI*targetDeg/360;
		double temp = f.getAktSpeed()*10/lengthStep;
		double temp2 = 600/temp;
		cutter.circle(xRead, yRead, xCenter,yCenter, targetDeg,r, c,temp2);
		}
		
		l.addToLog("G03 ausgeführt in " + l.zeitGebraucht());
	}

	private static double calcDegree(double r, double dy, double dx) {

		if (dx < 0 && 0 < dy) { // 2
			return 180 - Math.toDegrees(Math.asin(dy / r));
		} else if (0 < dx && dy < 0) {// 1
			return 360 + Math.toDegrees(Math.asin(dy / r));
		} else if (0 < dx && 0 < dy) {// 3
			return Math.toDegrees(Math.asin(dy / r));
		} else if (dx < 0 && dy < 0) {// 4
			return Math.toDegrees(Math.asin(Math.abs(dy) / r)) + 180;
		} else if (dx == 0 && dy < 0) {
			return 270;
		} else if (dx == 0 && 0 < dy) {
			return 90;
		} else if (dx < 0 && dy == 0) {
			return 180;
		} else if (0 < dx && dy == 0) {
			return 0;
		} else {
			return 420.420;
		}
	}
		
	
}