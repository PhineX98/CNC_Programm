package application;

import fileParser.CommandCode;

/**
 *Diese Klasse implementiert eine Kreispolation im Uhrzeigersinn
 *-> G02 des G-Codes
 *
 * @author Jannik Orth
 */
public class G02 extends Befehl {

	public void exec(Spindel s, Fraeser f, SampleController c, Logging l, CommandCode values) {
		l.zeitStarten();
		
		
		
		l.addToLog("G02 ausgeführt in " + l.zeitGebraucht());
	}
}
