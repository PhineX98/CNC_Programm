package application;

import fileParser.CommandCode;

/**
 *Diese Klasse implementiert eine Kreispolation gegen den Uhrzeigersinn
 *-> G03 des G-Codes
 *
 * @author Jannik Orth
 */
public class G03 extends Befehl {

	public void exec(Spindel s, Fraeser f, SampleController c, Logging l, CommandCode values) {
		l.zeitStarten();
		
		
		
		l.addToLog("G03 ausgeführt in " + l.zeitGebraucht() );
	}
}
