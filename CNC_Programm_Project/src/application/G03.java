package application;

import fileParser.CommandCode;

/**
 *
 * @author Jannik Orth
 */
public class G03 extends Befehl {
	// Kreisinterpolation gegen Uhrzeigersinn

	public void exec(Spindel s, Fraeser f, SampleController c, Logging l, CommandCode values) {
		l.zeitStarten();
		
		
		
		l.addToLog("G03 ausgef�hrt in " + l.zeitGebraucht() );
	}
}
