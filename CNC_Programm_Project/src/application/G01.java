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

		if(f.getFraeserStatus()) {
			starten(s, f, c, l, values);
		}else {
			c.errorHandler.youHaveToStartTheDrillViaCommand();
		}
	}
	
	
	private void starten(Spindel s, Fraeser f, SampleController c, Logging l, CommandCode values){

		double xRead = values.getX() / 2;
		double yRead = values.getY() / 2;
		double aktX = f.getPosX();
		double aktY = f.getPosY();
		double xToDrill = Math.abs(xRead - aktX);
		double yToDrill = Math.abs(yRead - aktY);
		double dx, dy;
		
		if (xToDrill > yToDrill) {
			//dx = Math.round(Math.signum(xRead));
			//dx = xToDrill;
			dx=1;
			if (aktX>xRead) {
				dx = -1;
			}
			//dy = Math.round(yToDrill / xToDrill);
			dy = (yToDrill ) / (xToDrill );
			
//			AnimationHandler cutter = new AnimationHandler();
//			System.out.println("Y");
			//cutter.lineY(xRead, yRead, c, dx, dy,yToDrill);
			
		} else if (xToDrill < yToDrill) {
			//dx = Math.round(xToDrill / yToDrill);
			dx = xToDrill / yToDrill;
			//dy = Math.round(Math.signum(yRead));
			//dy= yToDrill;
			dy=1;
			if (aktY>yRead) {
				dy = -1;
			} 
			
			
//			AnimationHandler cutter = new AnimationHandler();
//			cutter.lineX(xRead, yRead, c, dx, dy,xToDrill);
			System.out.println("X");
			//cutter.lineX(xRead, yRead, c, dx, dy);
		}else {
				if (xRead<aktX) {
					dx = -1;
				}else {
					dx = 1;
				}
				if (yRead<aktY) {
					dy = -1;
				}else {
					dy = 1;
				}
		}
		
		AnimationHandler cutter = new AnimationHandler();
		double lengthStep = Math.sqrt(dx*dx + dy*dy);
		double temp = f.getAktSpeed()*10/lengthStep;
		double temp2 = 600/temp;
		//temp2 = 20;
		
		
		System.out.println(xRead + " " + yRead + " " +dx + " "+ dy + "dgzasgfzgzgfzaggzvn" + xToDrill + "  " + yToDrill + "  " +aktX + "  " + aktY);
		
		if (dx == 0) {
			//dy = 1;
			//AnimationHandler cutter = new AnimationHandler();
			cutter.lineY(xRead, yRead, c, dx, dy,yToDrill, temp2);
			System.out.println("1");
		}else if (dy == 0) {
			//AnimationHandler cutter = new AnimationHandler();
			//dx = 1;
			cutter.lineX(xRead, yRead, c, dx, dy,xToDrill, temp2);
			System.out.println("2");
		}

		 else if (xToDrill < yToDrill) {
			// AnimationHandler cutter = new AnimationHandler();
		
				cutter.lineX(xRead, yRead, c, dx, dy,xToDrill, temp2);
				System.out.println("3");
				
		} else if (xToDrill > yToDrill){
			//AnimationHandler cutter = new AnimationHandler();
	
			cutter.lineY(xRead, yRead, c, dx, dy,yToDrill, temp2);
			System.out.println("4");
		} else {
			//AnimationHandler cutter = new AnimationHandler();
			
			cutter.lineY(xRead, yRead, c, dx, dy,yToDrill, temp2);
			System.out.println("5");
			
		}
		

		

		l.addToLog("G01 ausgeführt in " + l.zeitGebraucht());
	}
}
