package mCode;

import application.SampleController;
import handler.Befehl;
import komponenten.Fraeser;
import komponenten.Spindel;
import logging.Logging;

/**
 *Diese Klasse implementiert den M03 Befehl des G-Codes ->
 *
 *  // Spindel ein
	// Vorschub ein?
	// Drehrichtung rechts
	// Bohrspeed = 2
 *
 * @author Jannik Orth
 */
public class M03 extends Befehl {

	// Spindel ein im Uhrezigersinn (Rechtslauf)

	public void exec(Spindel s, Fraeser f, SampleController c, Logging l) {
		s.startRight();
		f.setFraeserStatus(true);
		f.setAktSpeed(s);

		l.addToLog("M03 ausgef�hrt");
		resetStatus(s, f, c);
	}

	
}
