package komponenten;

/**
 * Dies ist die Abstraktion der Spindel des Fräskopfes
 *
 * @author Jannik Orth
 */
public class Spindel {
	
	
	private boolean drillStatus = false;

	// false -> Rechtslauf | true -> Linkslauf
	private boolean drillDirection = false;

	// Drill Stoppen
	public void stop() {
		drillStatus = false;
	}

	// Drill Starten rechtsherum
	public void startRight() {
		drillStatus = true;
		drillDirection = false;
	}

	// Drill Starten linksrum
	public void startLeft() {
		drillStatus = true;
		drillDirection = true;
	}

	// get Drill Status
	public boolean getStatus() {
		return drillStatus;
	}

	// get Drill Richtung
	public boolean getDirection() {
		return drillDirection;
	}



}
