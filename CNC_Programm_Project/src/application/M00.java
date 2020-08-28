package application;

/**
 *
 * @author Jannik Orth
 */
public class M00 extends Befehl {

	// Programmhalt

	public void exec(Spindel s, Fraeser f, SampleController c, Logging l) {
		s.stop();
		f.setFraeserStatus(false);
		f.setSchnittSpeed(0);
		f.setCoolingStatus(false);

		/*
		 * c.statFraeser.setText("AUS"); c.statDirection.setText("-");
		 * c.statCooling.setText("AUS"); c.statSpeed.setText("0");
		 */
		
		l.addToLog("M00 ausgef�hrt");
		resetStatus(s, f, c);

	}

	// Spindel aus
	// Vorschub aus
	// K�hlmittel aus
	// Bohrspeed = 0
}
