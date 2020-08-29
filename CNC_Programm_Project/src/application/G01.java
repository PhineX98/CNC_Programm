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
		
		LineAnimation.line(values.getX(),values.getY(), c);
		
		l.addToLog("G01 ausgeführt in " + l.zeitGebraucht());
	}
}
