package application;

/**
 *
 * @author Jannik Orth
 */
public class M08 extends Befehl {

	// Kühlmittel ein
	public void exec(Spindel s, Fraeser f, SampleController c, Logging l) {
		f.setCoolingStatus(true);
		f.setSchnittSpeed(3);

		l.addToLog("M08 ausgef�hrt");
		resetStatus(s, f, c);
	}
	// Kühlung ein
	// Bohrspeed = 3
}
