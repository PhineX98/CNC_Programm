package application;

import fileParser.CommandCode;


/**
 * Diese Klasse implemenmtiert eine Verfahrbewegung im Eilgang. (nur ohne
 * Bohren/Fräsen möglich !!!Nur möglich wenn fräser aus!!! -> G00 des G-Codes
 *
 * @author Jannik Orth
 */
public class G00 extends Befehl {

	public void exec(Spindel s, Fraeser f, SampleController c, Logging l, CommandCode values) {
		l.zeitStarten();
		
		
		if(!f.getFraeserStatus() && !s.getStatus()) {
			starten(s, f, c, l, values);

		}else {
			c.errorHandler.youHaveAnIvalidCommandInAction(c,values);
		}
	}
	
	
	private void starten(Spindel s, Fraeser f, SampleController c, Logging l, CommandCode values){
		double xRead = values.getX() / 2;
		double yRead = values.getY() / 2;
		double aktX = f.getPosX();
		double aktY = f.getPosY();
		double xToMove = Math.abs(xRead - aktX);
		double yToMove = Math.abs(yRead - aktY);
		double dx, dy;

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

		AnimationHandler cutter = new AnimationHandler();
		
		double lengthStep = Math.sqrt(dx*dx + dy*dy);
		double temp = f.getAktSpeed()*10/lengthStep;
		double temp2 = 600/temp;
		//temp2 = 20;

		if (dx == 0) {
			cutter.lineYFast(xRead, yRead, c, dx, dy, yToMove,temp2);
		} else if (dy == 0) {
			cutter.lineXFast(xRead, yRead, c, dx, dy, xToMove,temp2);
		}

		else if (xToMove < yToMove) {
			cutter.lineXFast(xRead, yRead, c, dx, dy, xToMove,temp2);
		} else if (xToMove > yToMove) {
			cutter.lineYFast(xRead, yRead, c, dx, dy, yToMove,temp2);

		} else {
			cutter.lineYFast(xRead, yRead, c, dx, dy, yToMove,temp2);
		}

		
		
			l.addToLog("G00 ausgeführt in " + l.zeitGebraucht());
		
	}
	

}
