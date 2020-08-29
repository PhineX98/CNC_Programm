package application;

import fileParser.CommandCode;
import javafx.scene.shape.MoveTo;


/**
 *
 * @author Jannik Orth
 */
public class G00 extends Befehl {
	/**
	 * Verfahrbewegung im Eilgang(nur ohne Bohren/Fräsen möglich !!!Nur möglich wenn
	 * fräser aus!!!
	 * 
	 */

	public void exec(Spindel s, Fraeser f, SampleController c, Logging l, CommandCode values) {
		l.zeitStarten();
		
		SampleController.path1.getElements().add(new MoveTo(values.getX(),values.getY()));
		
		
		l.addToLog("G00 ausgeführt in " + l.zeitGebraucht());
	}
}
