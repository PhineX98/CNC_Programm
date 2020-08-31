package mCode;

import application.SampleController;
import handler.Befehl;
import komponenten.Fraeser;
import komponenten.Spindel;
import logging.Logging;

/**
 * Diese Klasse implementiert den M13 Befehl des G-Codes ->
 * 
 * 	// Spindel ein
	// Vorschub ein?
	// Drehrichtung rechts
	// Kühlmittel an
	// Bohrspeed = 3
 *
 * @author Jannik Orth
 */
public class M13 extends Befehl {

	// Spindel ein, Rechtslauf und KÃ¼hlmittel ein
	public void exec(Spindel s, Fraeser f, SampleController c, Logging l) {
		s.startRight();
		f.setCoolingStatus(true);
		f.setAktSpeed(s);

		l.addToLog("M13 ausgeführt");
		resetStatus(s, f, c);
	}

}
