package application;

import fileParser.CommandCode;

/**
 *
 * @author Jannik Orth
 */
public class G02 extends Befehl {
	// Kreisinterpolation im Uhrzeigersinn

	public void exec(Spindel s, Fraeser f, SampleController c, Logging l, CommandCode values) {
		l.zeitStarten();
		
		
		
		l.addToLog("G02 ausgef�hrt in " + l.zeitGebraucht());
	}
}
