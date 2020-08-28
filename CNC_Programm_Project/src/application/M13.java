package application;

/**
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
	// Spindel ein
	// Vorschub ein?
	// Drehrichtung rechts
	// Kühlmittel an
	// Bohrspeed = 3
}
