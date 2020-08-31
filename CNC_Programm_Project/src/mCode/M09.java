package mCode;

import application.SampleController;
import handler.Befehl;
import komponenten.Fraeser;
import komponenten.Spindel;
import logging.Logging;

/**
 *Diese Klasse implementiert den M09 Befehl des G-Codes ->
 *
 *  // K�hhlung aus
	// Bohrspeed = 2
 *
 * @author Jannik Orth
 */
public class M09 extends Befehl {

	// Kühlmittel aus
	public void exec(Spindel s, Fraeser f, SampleController c, Logging l) {
		f.setCoolingStatus(false);
		f.setAktSpeed(s);

		l.addToLog("M09 ausgef�hrt");
		resetStatus(s, f, c);
	}
	

}
