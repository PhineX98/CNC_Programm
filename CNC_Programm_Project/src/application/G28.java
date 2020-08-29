package application;

import fileParser.CommandCode;

/**
 *Diese Klasse implementiert das zurückfahren zur Homeposition des Fräsers
 *-> G28 des G-Codes
 *
 * @author Jannik Orth
 */
public class G28 extends Befehl {

	public void exec(Spindel s, Fraeser f, SampleController c, Logging l, CommandCode values) {
		l.zeitStarten();
		

		
		l.addToLog("G28 ausgeführt in " + l.zeitGebraucht());
	}
}
