package application;

import fileParser.CommandCode;

/**
 * Diese Klasse implementiert den Fräsvorgang einer Geraden von Punkt a zu Punkt
 * b -> G01 des G-Codes
 *
 * @author Jannik Orth
 */
public class G01 extends Befehl {

	public void exec(Spindel s, Fraeser f, SampleController c, Logging l, CommandCode values) {
		l.zeitStarten();

//		double dx ,dy;	
//		double xToDrill = values.getX()/2 - f.getPosX();
//		double yToDrill = values.getY()/2 - f.getPosY();
//		
//		if (xPosDrill > yPosDrill) {
//			dy = (yPosDrill ) / (xPosDrill );
//			dx = Math.signum(values.getX()/2);
//		}
//		
//		else if(xPosDrill < yPosDrill){
//			dx = (xPosDrill ) / (yPosDrill );
//			dy = Math.signum(values.getY()/2);
//		}else {
//			dx = 1;
//			dy = 1;
//		}

		double xRead = Math.round(values.getX() / 2);
		double yRead = Math.round(values.getY() / 2);
		double aktX = f.getPosX();
		double aktY = f.getPosY();
		double xToDrill = xRead - aktX;
		double yToDrill = yRead - aktY;
		double dx, dy;
		if (xToDrill > yToDrill) {
			dx = Math.round(Math.signum(xRead));
			dy = Math.round(yToDrill / xToDrill);
			
		} else  {
			dx = Math.round(xToDrill / yToDrill);
			dy = Math.round(Math.signum(yRead));
		}
		
//		} else if (xToDrill < yToDrill) {
//			dx = Math.round(xToDrill / yToDrill);
//			dy = Math.signum(yRead);
//		} else {
//			dx = 1;
//			dy = 1;
//		}
		
		
		
		
		
		
		System.out.println(xRead + " " + yRead + " " +dx + " "+ dy + "dgzasgfzgzgfzaggzvn");
		AnimationHandler cutter = new AnimationHandler();
		cutter.line(xRead, yRead, c, dx, dy);

		l.addToLog("G01 ausgeführt in " + l.zeitGebraucht());
	}
}
