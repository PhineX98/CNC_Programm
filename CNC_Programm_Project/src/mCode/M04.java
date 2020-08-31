package mCode;

import application.SampleController;
import handler.Befehl;
import komponenten.Fraeser;
import komponenten.Spindel;
import logging.Logging;

/**
 *Diese Klasse implementiert den M04 Befehl des G-Codes ->
 *
 *	// Spindel ein
	// Vorschub ein?
	// Drehrichtung links
	// Bohrspeed = 2
 *
 * @author Jannik Orth
 */
public class M04 extends Befehl {

	// Spindel ein gegen den Uhrzeigersinn (Linkslauf)

	public void exec(Spindel s, Fraeser f, SampleController c, Logging l) {
		s.startLeft();
		f.setAktSpeed(s);

		l.addToLog("M04 ausgeführt");
		resetStatus(s, f, c);
	}


}
