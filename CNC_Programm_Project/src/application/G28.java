package application;

import fileParser.CommandCode;

/**
 *
 * @author Jannik Orth
 */
public class G28 extends Befehl {
	// Homeposition wieder anfahren

	public void exec(Spindel s, Fraeser f, SampleController c, Logging l, CommandCode values) {
		l.zeitStarten();
		

		
		l.addToLog("G28 ausgeführt in " + l.zeitGebraucht());
	}
}
