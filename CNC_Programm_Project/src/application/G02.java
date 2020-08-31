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

	public void exec(Spindel s, Fraeser f, SampleController c, Logging l, CommandCode values) {
		System.out.println("hier");
		l.zeitStarten();
		
		i = values.getI()/2;
		j = values.getJ()/2;
		r = Math.sqrt(i * i + j * j);
		
		xRead = Math.round(values.getX()/2);
		yRead = Math.round(values.getY()/2);

		xCenter = c.fraeser.getPosX() + i;
		yCenter = c.fraeser.getPosY() + j;

		sDeg = calcDegree(r, j, -i);
		System.out.println("-----");
		if (c.fraeser.getPosY() == yRead) {
			eDeg = calcDegree(r, 0, xRead - xCenter);
			System.out.println(eDeg + "   1");
		} else {
			eDeg = calcDegree(r, yRead + yCenter, xRead - xCenter);
			System.out.println(r + "   " +(yRead+yCenter)+ "  " + (xRead-xCenter)+ "  "+ yCenter+"  " + i );
		}
		
		System.out.println(eDeg + "  " + sDeg);
		if(eDeg > sDeg) {
			targetDeg = eDeg-sDeg;
		}else {
			targetDeg = 360 - sDeg + eDeg;			
		}
		System.out.println(eDeg + "  " + sDeg);
		
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
		double lengthStep = 2*r*Math.PI*targetDeg/360;
		double temp = f.getAktSpeed()*10/lengthStep;
		double temp2 = 600/temp;
		cutter.circle(xRead, yRead, xCenter,yCenter, targetDeg,r, c,temp2);
		
		l.addToLog("G02 ausgeführt in " + l.zeitGebraucht());
	}

	private double calcDegree(double r, double dy, double dx) {

		if (dx < 0 && 0 < dy) { // 2
			System.out.println(15);
			//return 180 - Math.toDegrees(Math.asin(dy / r));
			return 180 - Math.atan(dy/dx);
		} else if (0 < dx && dy < 0) {// 1
			System.out.println(2);
			//return 360 + Math.toDegrees(Math.asin(dy / r));
			return 360+Math.atan(dy/dx);
		} else if (0 < dx && 0 < dy) {// 3
			System.out.println((dy/r) + "   §");
			System.out.println(Math.asin(1.1));
			//return Math.toDegrees(Math.asin(dy / r));
			return Math.atan(dy/dx);
		} else if (dx < 0 && dy < 0) {// 4
			System.out.println(4);
			//return Math.toDegrees(Math.asin(Math.abs(dy) / r)) + 180;
			return Math.atan(dy/dx)+180;
		} else if (dx == 0 && dy < 0) {
			System.out.println(5);
			return 270;
		} else if (dx == 0 && 0 < dy) {
			System.out.println(6);
			return 90;
		} else if (dx < 0 && dy == 0) {
			System.out.println(7);
			return 180;
		} else if (0 < dx && dy == 0) {
			System.out.println(8);
			return 0;
		} else {
			return 420.420;
		}
	}

}