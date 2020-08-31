package mCode;

import application.SampleController;
import handler.Befehl;
import komponenten.Fraeser;
import komponenten.Spindel;
import logging.Logging;

/**
 *Diese Klasse implementiert den M05 Befehl des G-Codes ->
 *
 *  // Spindel aus
	// Bohrspeed = 2
 *
 * @author Jannik Orth
 */
public class M05 extends Befehl {

	// Spindel stopp
	public void exec(Spindel s, Fraeser f, SampleController c, Logging l) {
		s.stop();
		
		
		l.addToLog("M05 ausgeführt");
		resetStatus(s, f, c);
	}

	
}
