package application;

/**
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

	// Spindel aus
	// Bohrspeed = 2
}
