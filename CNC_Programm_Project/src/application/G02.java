package application;

import fileParser.CommandCode;

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
		eDeg = calcDegree(xRead- xCenter,0, yRead- yCenter,0);
		
		if(eDeg < sDeg) {
			eDeg += 360;
		}

		System.out.println(sDeg + "  " + eDeg);

//		if( !((Math.pow((xCenter - xRead),2)+Math.pow((yCenter-yRead), 2))==r*r) && (Math.pow((xCenter - f.getPosX()),2)+Math.pow((yCenter-f.getPosY()), 2)==r*r)) {
//			c.errorHandler.yourEndCoordinateIsNotOnCircle(c, values);
//		}else {
//			
//		AnimationHandler cutter = new AnimationHandler();
//		double lengthStep = 2*r*Math.PI*targetDeg/360;
//		double temp = f.getAktSpeed()*10/lengthStep;
//		double temp2 = 600/temp;
//		cutter.circle(xRead, yRead, xCenter,yCenter, targetDeg,r, c,temp2);
//		}

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
				winkel = 90;
			} else {
				winkel = 270;
			}
		} else if (i1 < i2) {
			if (j1 == j2) {
				winkel = 0;
			} else if (j1 < j2) {
				winkel = 180 + (Math.atan(j1 / i1) * (180 / Math.PI));
			} else if (j1 > j2) {
				winkel = 90 + (Math.atan(i1 / j1) * (180 / Math.PI));
			}
		} else {
			if (j1 == j2) {
				winkel = 180;
			} else if (j1 > j2) {
				winkel = Math.atan(j1 / i1) * (180 / Math.PI);
			} else if (j1 < j2) {
				winkel = 270 + (Math.atan(i1 / j1) * (180 / Math.PI));

			}
		}
		return winkel;
	}

}

//		if (dx < 0 && 0 < dy) { // 2
//			System.out.println(15);
//			//return 180 - Math.toDegrees(Math.asin(dy / r));
//			//return 180 - Math.atan(dy/dx);
//			return 180 - Math.toDegrees(Math.atan(dy/dx));
//		} else if (0 < dx && dy < 0) {// 1
//			System.out.println(2);
//			//return 360 + Math.toDegrees(Math.asin(dy / r));
//			//return 360+Math.atan(dy/dx);
//			return 360+ Math.toDegrees(Math.atan(dy/dx));
//		} else if (0 < dx && 0 < dy) {// 3
//			System.out.println((dy/r) + "   §");
//			System.out.println(Math.asin(1.1));
//			//return Math.toDegrees(Math.asin(dy / r));
//			//return Math.atan(dy/dx);
//			return Math.toDegrees(Math.atan(dy/dx));
//		} else if (dx < 0 && dy < 0) {// 4
//			System.out.println(4);
//			//return Math.toDegrees(Math.asin(Math.abs(dy) / r)) + 180;
//			//return Math.atan(dy/dx)+180;
//			return Math.toDegrees(Math.atan(dy/dx))+180;
//		} else if (dx == 0 && dy < 0) {
//			System.out.println(5);
//			return 270;
//		} else if (dx == 0 && 0 < dy) {
//			System.out.println(6);
//			return 90;
//		} else if (dx < 0 && dy == 0) {
//			System.out.println(7);
//			return 180;
//		} else if (0 < dx && dy == 0) {
//			System.out.println(8);
//			return 0;
//		} else {
//			return 420.420;
//		}
//	}
