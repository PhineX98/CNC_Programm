package application;

/**
 *
 * @author Jannik Orth
 */
public class G00 extends Befehl {
	/**
	 * Verfahrbewegung im Eilgang(nur ohne Bohren/Fr�sen m�glich !!!Nur m�glich wenn
	 * fr�ser aus!!!
	 * 
	 */

	public void exec(Spindel s, Fraeser f, SampleController c, Logging l) {
		l.zeitStarten();
		
		
		
		l.addToLog("G00 ausgef�hrt in " + l.zeitGebraucht());
	}
}
