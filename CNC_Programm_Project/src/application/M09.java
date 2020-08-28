package application;

/**
 *Diese Klasse implementiert den M09 Befehl des G-Codes ->
 *
 *  // Kühhlung aus
	// Bohrspeed = 2
 *
 * @author Jannik Orth
 */
public class M09 extends Befehl {

	// KÃ¼hlmittel aus
	public void exec(Spindel s, Fraeser f, SampleController c, Logging l) {
		f.setCoolingStatus(false);
		f.setSchnittSpeed(2);

		l.addToLog("M09 ausgeführt");
		resetStatus(s, f, c);
	}
	

}
