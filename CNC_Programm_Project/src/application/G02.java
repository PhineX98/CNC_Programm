package application;

/**
 *
 * @author Jannik Orth
 */
public class G02 extends Befehl {
	// Kreisinterpolation im Uhrzeigersinn

	public void exec(Spindel s, Fraeser f, SampleController c, Logging l) {
		l.zeitStarten();
		
		
		
		l.addToLog("G02 ausgeführt in " + l.zeitGebraucht());
	}
}
