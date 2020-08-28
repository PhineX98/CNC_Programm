package application;

/**
 *
 * @author Jannik Orth
 */
public class G01 extends Befehl {
	// Gerade

	public void exec(Spindel s, Fraeser f, SampleController c, Logging l) {
		l.zeitStarten();
		
		
		
		l.addToLog("G01 ausgeführt in " + l.zeitGebraucht());
	}
}
