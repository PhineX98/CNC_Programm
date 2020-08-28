package application;

/**
 * Diese Klasse implementiert den M13 Befehl des G-Codes ->
 * 
 * 	// Spindel ein
	// Vorschub ein?
	// Drehrichtung rechts
	// K�hlmittel an
	// Bohrspeed = 3
 *
 * @author Jannik Orth
 */
public class M13 extends Befehl {

	// Spindel ein, Rechtslauf und Kühlmittel ein
	public void exec(Spindel s, Fraeser f, SampleController c, Logging l) {
		s.startRight();
		f.setCoolingStatus(true);
		f.setSchnittSpeed(3);

		l.addToLog("M13 ausgef�hrt");
		resetStatus(s, f, c);
	}

}
