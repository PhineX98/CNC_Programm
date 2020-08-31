package mCode;

import application.SampleController;
import handler.Befehl;
import komponenten.Fraeser;
import komponenten.Spindel;
import logging.Logging;

/**
 *Diese Klasse implementiert den M08 Befehl des G-Codes ->
 *
 *  // K�hlung ein
	// Bohrspeed = 3
 *
 * @author Jannik Orth
 */
public class M08 extends Befehl {

	// Kühlmittel ein
	public void exec(Spindel s, Fraeser f, SampleController c, Logging l) {
		f.setCoolingStatus(true);
		f.setAktSpeed(s);

		l.addToLog("M08 ausgef�hrt");
		resetStatus(s, f, c);
	}
	
}
