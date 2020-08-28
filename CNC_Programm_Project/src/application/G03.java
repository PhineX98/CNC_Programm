package application;

/**
 *
 * @author Jannik Orth
 */
public class G03 extends Befehl {
	// Kreisinterpolation gegen Uhrzeigersinn

	public void exec(Spindel s, Fraeser f, SampleController c, Logging l) {
		l.zeitStarten();
		
		
		
		l.addToLog("G03 ausgeführt in " + l.zeitGebraucht() );
	}
}
