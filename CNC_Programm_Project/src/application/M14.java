package application;

/**
 * Diese Klasse implementiert den M14 Befehl des G-Codes ->
 *
 *	// Spindel ein
	// Vorschub ein?
	// Drehrichtung links
	// K�hlmittel an
	// Bohrspeed = 3
 *
 * @author Jannik Orth
 */
public class M14 extends Befehl {

	// Spindel ein, Linkslauf und Kühlmittel ein
	public void exec(Spindel s, Fraeser f, SampleController c, Logging l) {
		s.startLeft();
		f.setCoolingStatus(true);
		f.setSchnittSpeed(3);
		
		l.addToLog("M14 ausgef�hrt");
		resetStatus(s, f, c);
	}


}
