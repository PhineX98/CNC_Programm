package application;

/**
 *Diese Klasse implementiert den M02 Befehl des G-Codes ->
 *
 *	// Programm Ende
	// Spindel aus
	// Vorschub aus
	// Kühlmittel aus
	// Bohrspeed = 0
 *
 * @author Jannik Orth
 */
public class M02 extends Befehl {

	public void exec(Spindel s, Fraeser f, SampleController c, Logging l) {
		// Programm beenden

		s.stop();
		f.setFraeserStatus(false);
		f.setCoolingStatus(false);
		f.setFahrSpeed(0);

		l.addToLog("M02 ausgef�hrt");
		resetStatus(s, f, c);
	}

	// Programm Ende
	// Spindel aus
	// Vorschub aus
	// Kühlmittel aus
	// Bohrspeed = 0
}
