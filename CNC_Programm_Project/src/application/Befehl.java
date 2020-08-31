package application;

/**
 * Abstrakte Klasse zur Erstellung der Command Handler
 * 
 * @author Jannik
 */
public abstract class Befehl {

	public void exec(Spindel s, Fraeser f, SampleController c, Logging l) {

		// Wird von jeder Unterklasse einzeln implementiert, zum richtigen Handling der
		// Commands.

	}
	


	/*
	 * Zum aktualisieren der Anzeige für den aktuellen Status der Maschine
	 */
	public void resetStatus(Spindel s, Fraeser f, SampleController c) {

		// Setzen des eingestellten Fräserstatus
		if (!f.getFraeserStatus() || !s.getStatus()) {
			c.statFraeser.setText("AUS");
		} else {
			c.statFraeser.setText("AN");
		}

		// Setzen des eingestellten Kühlungsstatus
		if (f.getCoolingStatus()) {
			c.statCooling.setText("AN");
		} else {
			c.statCooling.setText("AUS");
		}

		// Setzen der angezeigten Drehrichtung (EIN/AUS oder - bei ausgeschalteter
		// Fräse)
		if (!s.getRichtung() && f.getFraeserStatus()) {
			c.statDirection.setText("Rechts");
		} else if (s.getRichtung() && f.getFraeserStatus()) {
			c.statDirection.setText("Links");
		} else {
			c.statDirection.setText("-");
		}

		// Einstellung der angezeigten Geschwindigkeit
		c.statSpeed.setText(Double.toString(f.getAktSpeed()));

	}
}
