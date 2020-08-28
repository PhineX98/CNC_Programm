package application;

/**
 *
 * @author Jannik Orth
 */
public class M03 extends Befehl {

	// Spindel ein im Uhrezigersinn (Rechtslauf)

	public void exec(Spindel s, Fraeser f, SampleController c, Logging l) {
		s.startRight();
		f.setFraeserStatus(true);
		f.setSchnittSpeed(2);

		l.addToLog("M03 ausgeführt");
		resetStatus(s, f, c);
	}

	// Spindel ein
	// Vorschub ein?
	// Drehrichtung rechts
	// Bohrspeed = 2
}
