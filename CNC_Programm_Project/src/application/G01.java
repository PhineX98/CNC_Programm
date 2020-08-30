package application;

import fileParser.CommandCode;
import javafx.animation.Timeline;

/**
 *Diese Klasse implementiert den Fräsvorgang einer Geraden von Punkt a zu Punkt b
 *-> G01 des G-Codes
 *
 * @author Jannik Orth
 */
public class G01 extends Befehl {

	public void exec(Spindel s, Fraeser f, SampleController c, Logging l, CommandCode values) {
		l.zeitStarten();
		
		double dx ,dy;	
		double xPosDrill = values.getX() - f.getPosX();
		double yPosDrill = values.getY() - f.getPosY();
		
		if (xPosDrill > yPosDrill) {
			dy = (yPosDrill ) / (xPosDrill );
			dx = Math.signum(values.getX());
		}
		
		else if(xPosDrill < yPosDrill){
			dx = (xPosDrill ) / (yPosDrill );
			dy = Math.signum(values.getY());
		}else {
			dx = 1;
			dy = 1;
		}
		
		AnimationHandler cutter = new AnimationHandler();
		cutter.line(values.getX(), values.getY(), c, dx ,dy);
		
		
		l.addToLog("G01 ausgeführt in " + l.zeitGebraucht());
	}
}
