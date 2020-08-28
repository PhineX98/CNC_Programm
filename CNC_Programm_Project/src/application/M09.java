package application;

/**
 *
 * @author Jannik Orth
 */
public class M09 extends Befehl {

	// Kühlmittel aus
	public void exec(Spindel s, Fraeser f, SampleController c, Logging l) {
		f.setCoolingStatus(false);
		f.setSchnittSpeed(2);

		l.addToLog("M09 ausgef�hrt");
		resetStatus(s, f, c);
	}
	// Kühlung aus
	// Bohrspeed = 2

}
