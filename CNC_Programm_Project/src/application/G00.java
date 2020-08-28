package application;

import fileParser.CommandCode;


/**
 *Diese Klasse implemenmtiert eine Verfahrbewegung im Eilgang.
 *(nur ohne Bohren/Fräsen möglich !!!Nur möglich wenn fräser aus!!!
 *-> G01 des G-Codes
 *
 * @author Jannik Orth
 */
public class G00 extends Befehl {

	public void exec(Spindel s, Fraeser f, SampleController c, Logging l, CommandCode values) {
		l.zeitStarten();
		
		
		
		l.addToLog("G00 ausgeführt in " + l.zeitGebraucht());
	}
}
