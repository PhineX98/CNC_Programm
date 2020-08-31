package application;

/**
 * Dies ist die Abstraktion der Spindel des Fräskopfes
 *
 * @author Jannik Orth
 */
public class Spindel {
	
	
	private boolean drillStatus = false;

	// false -> Rechtslauf | true -> Linkslauf
	private boolean drillRichtung = false;

	// Drill Stoppen
	public void stop() {
		drillStatus = false;
	}

	// Drill Starten rechtsherum
	public void startRight() {
		drillStatus = true;
		drillRichtung = false;
	}

	// Drill Starten linksrum
	public void startLeft() {
		drillStatus = true;
		drillRichtung = true;
	}

	// get Drill Status
	public boolean getStatus() {
		return drillStatus;
	}

	// get Drill Richtung
	public boolean getRichtung() {
		return drillRichtung;
	}



}
