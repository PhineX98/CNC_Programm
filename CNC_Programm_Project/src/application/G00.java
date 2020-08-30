package application;

import fileParser.CommandCode;
import javafx.scene.shape.MoveTo;


/**
 *Diese Klasse implemenmtiert eine Verfahrbewegung im Eilgang.
 *(nur ohne Bohren/Fräsen möglich !!!Nur möglich wenn fräser aus!!!
 *-> G00 des G-Codes
 *
 * @author Jannik Orth
 */
public class G00 extends Befehl {

	public void exec(Spindel s, Fraeser f, SampleController c, Logging l, CommandCode values) {
		l.zeitStarten();
		
		c.path.getElements().add(new MoveTo(values.getX(),values.getY()));
		
		l.addToLog("G00 ausgeführt in " + l.zeitGebraucht());
	}
}
