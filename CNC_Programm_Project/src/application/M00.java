package application;

import fileParser.CommandCode;

/**
 *Diese Klasse implementiert den M00 Befehl des G-Codes ->
 *
 *	// Spindel aus
	// Vorschub aus
	// Kühlmittel aus
	// Bohrspeed = 0
 *
 * @author Jannik Orth
 */
public class M00 extends Befehl {

	// Programmhalt

	public void exec(Spindel s, Fraeser f, SampleController c, Logging l) {
		s.stop();
		f.setFraeserStatus(false);
		f.setAktSpeed(s);
		f.setCoolingStatus(false);

		/*
		 * c.statFraeser.setText("AUS"); c.statDirection.setText("-");
		 * c.statCooling.setText("AUS"); c.statSpeed.setText("0");
		 */
		
		l.addToLog("M00 ausgeführt");
		resetStatus(s, f, c);

	}


}
