package application;

/**
 * Abstrakte Klasse zur Erstellung der Command Handler
 * 
 * @author Jannik
 */

public abstract class Befehl {

	public void exec(Spindel s, Fraeser f, SampleController c) {

		// Wird von jeder Unterklasse einzeln implementiert, zum richtigen Handling der
		// Commands.

	}

	public void resetStatus(Spindel s, Fraeser f, SampleController c) {

		// Setzen des eingestellten Fräserstatus
		if (f.getFraeserStatus()) {
			c.statFraeser.setText("AN");
		} else {
			c.statFraeser.setText("AUS");
		}

		// Setzen des eingestellten Kühlungsstatus
		if (f.getCoolingStatus()) {
			c.statCooling.setText("AN");
		} else {
			c.statCooling.setText("AUS");
		}

		// Setzen der angezeigten Drehrichtung (EIN/AUS oder - bei ausgeschalteter
		// Fräse)
		if (!s.drillRichtung && f.fraeserStatus) {
			c.statDirection.setText("Rechts");
		} else if (s.drillRichtung && f.fraeserStatus) {
			c.statDirection.setText("Links");
		} else {
			c.statDirection.setText("-");
		}

		// Einstellung der angezeigten Geschwindigkeit
		if (s.drillStatus) {
			c.statSpeed.setText(c.lblSpeedNoCooling.getText());
		} else if (s.drillStatus && f.coolingStatus) {
			c.statSpeed.setText(c.lblSpeedCooling.getText());
		} else if (!s.drillStatus && f.getFraeserStatus()) {
			c.statSpeed.setText(c.lblSpeedNoDrill.getText());
		} else if (!f.getFraeserStatus() && !s.getStatus()) {
			c.statSpeed.setText("0");
		} else {
			c.statSpeed.setText("-");
		}

	}
}
